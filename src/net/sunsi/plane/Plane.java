package net.sunsi.plane;

import net.sunsi.util.GameUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObjects{
    private boolean up, down, left, right;
    private boolean live = true;

    void draw(Graphics g){
        if (live){
            g.drawImage(img, (int)x,(int)y,null);
            move();
        }
    }


    private void move(){

        if (up){
            y -= speed;
        }
        if (down){
            y += speed;
        }
        if (left){
            x -= speed;
        }
        if (right){
            x += speed;
        }
    }

    void addDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                up=true;
                break;
            case KeyEvent.VK_DOWN:
                down=true;
                break;
            case KeyEvent.VK_LEFT:
                left=true;
                break;
            case KeyEvent.VK_RIGHT:
                right=true;
                break;
            default:
                break;
        }
    }

    void minuDiretion(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                up=false;
                break;
            case KeyEvent.VK_DOWN:
                down=false;
                break;
            case KeyEvent.VK_LEFT:
                left=false;
                break;
            case KeyEvent.VK_RIGHT:
                right=false;
                break;
            default:
                break;
        }
    }

    Plane(String imgPath, double x, double y, int speed) {
        super();
        this.img = GameUtil.getImage(imgPath);
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public Plane(){

    }

    void setLive(boolean live) {
        this.live = live;
    }

    boolean isLive() {
        return live;
    }
}
