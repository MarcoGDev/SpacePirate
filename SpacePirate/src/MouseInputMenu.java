import util.STATE;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
// import util.Sound;

   /*
        Listened welke buttons er aangeklikt worden in het menu,
        handled de events.
    */

public class MouseInputMenu implements MouseListener  {




    private final String helpPageURL  = "https://github.com/MarcoGDev/SpacePirate";


    private static final int SCREENSIZE_WIDTH = 400;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    private static void openHelpPage(String link) {

        try {

            Desktop.getDesktop().browse(new URL(link).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void mousePressed(MouseEvent e) {

 //       Sound sound = new Sound();

        int mx = e.getX();
        int my = e.getY();


        // Play Button

        if (mx >= SCREENSIZE_WIDTH / 2 + 120 && mx <= SCREENSIZE_WIDTH / 2 + 220) {
            if (my >= 150 && my <= 200) {
                //Pressed Play button
                Board.State = STATE.GAME;
            }
        }

        // Help Button

        if (mx >= SCREENSIZE_WIDTH / 2 + 120 && mx <= SCREENSIZE_WIDTH / 2 + 220) {
            if (my >= 250 && my <= 300) {
                //Pressed Help Button
                openHelpPage(helpPageURL);
            }
        }


        //Quit Button

        if (mx >= SCREENSIZE_WIDTH / 2 + 120 && mx <= SCREENSIZE_WIDTH / 2 + 220) {
            if (my >= 350 && my <= 400) {
                //Pressed Quit button
                System.exit(1);
            }
        }
}






    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
