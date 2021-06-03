import util.GenerateRandomCoords;
import util.STATE;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import java.util.List;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    private SpaceShip spaceShip;
    private final List<Alien> aliens = new ArrayList<>();
    private boolean inGame;
    private Image backGround;
    private Menu menu;
    private int score = 0;
    //private GenerateRandomCords generateRandomCords;
    //private STATE state;


    //private int SCREENSIZE_WIDTH = 400;
    //private int SCREENSIZE_HEIGHT = 800;



    static STATE State = STATE.MENU;


    Board() {

        initBoard();
    }

    private void initBoard() {

        int ICRAFT_Y = 60;
        int ICRAFT_X = 40;
        int DELAY = 10          ;


        addKeyListener(new TAdapter());
        setFocusable(true);

      //  inGame = true;


        spaceShip = new SpaceShip(ICRAFT_X, ICRAFT_Y);

      //  initAliens();
        menu = new Menu();

        Timer timer = new Timer(DELAY, this);

        this.addMouseListener(new MouseInputMenu());

        timer.start();


    }

    private void initAliens() {



        if(inGame) {
            generateAliens();
            inGame = false;
        }


    }

    private void generateAliens() {

        // Set total amount of aliens
        int[][] alienSize = new int[40][2];


        for( int i = 0 ; i < alienSize.length ; i++ ) {
            for ( int j = 0 ; j < alienSize[i].length ; j++ ) {
                alienSize[i][j] =  GenerateRandomCoords.getRandomNumberInRange(0, 700);
            }
        }

        for( int[] a : alienSize ) {
            //System.out.println(Arrays.toString(a));
            aliens.add(new Alien(a[0], a[1]));
        }

    }


    private void loadInGameBackGround() {
        ImageIcon ii = new ImageIcon("src/image/background.png");
        backGround = ii.getImage();
    }

    private void loadMenuBackGround() {

        ImageIcon ii = new ImageIcon("src/image/menuBackGround.png");
        backGround = ii.getImage();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backGround, 0, 0, null);

        if(State == STATE.GAME) {
            drawObject(g);


        } else if(State == STATE.MENU) {
            menu.render(g);
            loadMenuBackGround();
            inGame = true;
            aliens.clear();
            spaceShip.x = 40;
            spaceShip.y = 60;
        }

        if(inGame) {
            initAliens();
            inGame = false;
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObject(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        loadInGameBackGround();

        if(spaceShip.isVisible()) {
            g2d.drawImage(spaceShip.getImage(), spaceShip.getX(), spaceShip.getY(), this);
        }


        List<Missile> missiles = spaceShip.getMissiles();

        for(Missile missile : missiles) {
            if(missile.isVisible()) {
                g2d.drawImage(missile.getImage(), missile.getX(), missile.getY(), this);
            }
        }


        for(Alien alien : aliens) {
            if(alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                g.setColor(Color.WHITE);
                g.drawString("Aliens left: " + aliens.size(), 5, 15);
                g.drawString("score: " + score, 700, 15);

            }
        }
    }


    private void updateMissiles() {
        List<Missile> missiles = spaceShip.getMissiles();

        for(int i = 0; i < missiles.size(); i++) {
            Missile missile = missiles.get(i);


            if(missile.isVisible()) {
                missile.move();
            } else {
                missiles.remove(i);
            }
        }

            if(aliens.isEmpty()) {
                missiles.clear();
            }
    }


    private void updateSpaceShip() {
        spaceShip.move();
    }

    private void updateAliens() {
        if(aliens.isEmpty()) {
            score = 0;
            State = STATE.MENU;

            return;
        }


        for(int i = 0; i < aliens.size(); i++) {

            Alien a = aliens.get(i);
            if(a.isVisible()) {
                a.move();
            } else {
                aliens.remove(i);
            }
        }
    }

    private void checkCollisions() {
        Rectangle spaceShipBounds = spaceShip.getBounds();
        List<Missile> missileList = spaceShip.getMissiles();


        for (Alien alien : aliens) {

            Rectangle alienBounds = alien.getBounds();

            if(spaceShipBounds.intersects(alienBounds)) {
                State = STATE.MENU;
                score = 0;
                alien.setVisible(false);
                missileList.clear();
              //  initAliens();

              // inGame = true;
            }
        }

        for(Missile missiles : missileList) {
            Rectangle missilesBounds = missiles.getBounds();

            for(Alien alien : aliens) {
                Rectangle alienBounds = alien.getBounds();

                if (missilesBounds.intersects(alienBounds)) {
                    missiles.setVisible(false);
                    alien.setVisible(false);
                    score += 100;
                    System.out.println(score);
                }
            }
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(State == STATE.GAME) {
            updateMissiles();
            updateSpaceShip();
            updateAliens();

            checkCollisions();

        }

        repaint();

    }

    private class TAdapter extends KeyAdapter  {

        @Override
        public void keyReleased(KeyEvent e)  {
            spaceShip.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spaceShip.keyPressed(e);
        }
    }
}
