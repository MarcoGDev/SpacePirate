class Missile extends Sprite {

    Missile(int x, int y) {
        super(x, y);

        initMissile();
    }

    private void initMissile() {
        loadImage("src/image/missile.png");
        getImageDimension();
    }

    void move() {
        int MISSILE_SPEED = 2;

        x += MISSILE_SPEED;

        int BOARD_WIDTH = 800;

        if(x > BOARD_WIDTH) {
            visible = false;
        }
    }
}
