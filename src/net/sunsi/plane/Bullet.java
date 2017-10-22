package net.sunsi.plane;

import net.sunsi.util.GameUtil;


import java.awt.*;

class Bullet extends GameObjects{
    private double degree;

    void draw(Graphics g){
        g.drawImage(img, (int)x,(int)y,null);

        x += speed *Math.cos(degree);
        y += speed *Math.sin(degree);

        if (y> net.sunsi.util.Constant.GAME_HEIGHT-img.getHeight(null)||y<img.getHeight(null)){
            degree = -degree;
        }
        if (x<0||x> net.sunsi.util.Constant.GAME_WIDTH-img.getWidth(null)){
            degree = Math.PI-degree;
        }
    }


    Bullet(){

    }

    Bullet(String imgPath, double x, double y, int speed) {
        super();
        this.img = GameUtil.getImage(imgPath);
        this.x = x;
        this.y = y;
        this.speed = speed;
        degree = Math.random() * Math.PI*2;
    }
}
