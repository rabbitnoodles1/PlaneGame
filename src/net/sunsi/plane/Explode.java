package net.sunsi.plane;

import net.sunsi.util.GameUtil;

import java.awt.*;

public class Explode {
    private Image img;
    private double x, y;

    void draw(Graphics g){
        g.drawImage(img, (int)x, (int)y, null);
    }

    Explode(String imgPath, double x, double y) {
        this.img = GameUtil.getImage(imgPath);
        this.x = x;
        this.y = y;
    }
}
