import util.STATE;

import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.Image;

import java.util.ArrayList;


public class SpaceShip extends Sprite {

    private int dx;
    private int dy;
    private List<Missile> missiles;

    SpaceShip(int x, int y) {
    super(x, y);

    initSpaceShip();
}

    private void initSpaceShip() {
    missiles = new ArrayList<>();

    loadImage("src/image/craft.png");
    getImageDimension();
    }

    void move() {

        x += dx;
        y += dy;

        if(x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }

    List<Missile> getMissiles() {

        return missiles;

    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public Image getImage() {

        return image;
    }

    void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if(Board.State == STATE.GAME) {
            if (key == KeyEvent.VK_LEFT) {
                dx = -2;
            }

            if (key == KeyEvent.VK_RIGHT) {
                dx = 2;
            }

            if (key == KeyEvent.VK_UP) {
                dy = -2;
            }

            if (key == KeyEvent.VK_DOWN) {
                dy = 2;
            }
        }
    }

    private void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }

    void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}