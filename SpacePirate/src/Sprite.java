import javax.swing.*;
import java.awt.*;

public class Sprite {

    int x;
    int y;
    int height;
    int width;
    boolean visible;
    Image image;


    Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        visible = true;
    }

    void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();

        width = image.getWidth(null);
        height = image.getHeight(null);
    }


    void getImageDimension() {
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    boolean isVisible() {
        return visible;
    }

    void setVisible(boolean visible) {
        this.visible = visible;
    }

    Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
