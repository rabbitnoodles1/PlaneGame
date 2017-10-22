package net.sunsi.plane;

import java.awt.*;

public class GameObjects {
    Image img;
    double x, y;
    int speed;

    public GameObjects() {

    }


    Rectangle getRectangle(){
        return new Rectangle((int)x, (int)y, img.getWidth(null), img.getHeight(null));
    }

    public GameObjects(Image img, double x, double y, int speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
}
