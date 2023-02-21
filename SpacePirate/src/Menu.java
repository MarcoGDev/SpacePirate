import java.awt.*;

class Menu {

      /*
        Ingame menu,
        drawt & styled de buttons en positioneert ze.
      */

    private static final int SCREENSIZE_WIDTH = 400;

    void render(Graphics g) {

        Rectangle playButton = new Rectangle(SCREENSIZE_WIDTH / 2 + 120, 150, 100, 50);
        Rectangle helpButton = new Rectangle(SCREENSIZE_WIDTH / 2 + 120, 250, 100, 50);
        Rectangle quitButton = new Rectangle(SCREENSIZE_WIDTH / 2 + 120, 350, 100, 50);



        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 =  new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.WHITE);

         g.drawString("Space Pirate", SCREENSIZE_WIDTH / 2 + 19, 100);
            g.setColor(Color.CYAN);

         Font fnt1 = new Font("arial", Font.BOLD, 30);
         g.setFont(fnt1);

         g.drawString("Play", playButton.x + 19, playButton.y + 30);
           g2d.draw(playButton);

         g.drawString("Help", helpButton.x + 19, helpButton.y + 30);
           g2d.draw(helpButton);

         g.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
           g2d.draw(quitButton);

//        g.drawString("Sound", soundButton.x + 5, soundButton.y + 30);
//           g2d.draw(soundButton);
    }
}
