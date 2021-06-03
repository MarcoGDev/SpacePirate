class Alien extends Sprite {

    Alien(int x, int y) {
        super(x, y);

        initAlien();
    }

    private void initAlien() {

        loadImage("src/image/fc.png");
        getImageDimension();
    }

    void move() {

        if (x < 0) {

            x = 700;
        }

        // Set movement speed of aliens
        x -= 5;
    }
}