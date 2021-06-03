import java.awt.*;
import javax.swing.*;

public class Game extends JFrame {
   /*
    Main class.
    Start de thread, maakt de user interface, en roept Board aan om de game te initialiseren.
   */


    private Game() {

        initUI();
    }

    private void initUI() {
        add(new Board());


        setTitle("Space Pirate");

        final int SCREENSIZE_HEIGHT = 800;
        final int SCREENSIZE_WIDTH = 800;
        setSize(SCREENSIZE_WIDTH, SCREENSIZE_HEIGHT);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            Game ex = new Game();
            ex.setVisible(true);

            String threadName = Thread.currentThread().getName();
            System.out.println("Thread name is = " + threadName);

        });
    }
}
