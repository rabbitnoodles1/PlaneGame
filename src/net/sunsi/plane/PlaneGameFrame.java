package net.sunsi.plane;

import net.sunsi.util.Constant;
import net.sunsi.util.GameUtil;
import net.sunsi.util.MyFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

public class PlaneGameFrame extends MyFrame {
    private Date startTime;
    private Date endTime;
    private Image bg = GameUtil.getImage("images/bg.jpg");
    private Plane plane = new Plane("images/plane.png", 50 ,50, 10);
    private Explode explode;


    private ArrayList bulletList = new ArrayList();

    public void paint(Graphics g){
        g.drawImage(bg,0,0,null);
        plane.draw(g);

        for (Object aBulletList : bulletList) {
            Bullet bullet = (Bullet) aBulletList;
            bullet.draw(g);

            boolean crash = bullet.getRectangle().intersects(plane.getRectangle());
            if (crash) {
                plane.setLive(false);

                if (explode==null){
                    endTime = new Date();
                    explode = new Explode("images/explode.gif", plane.x, plane.y);
                }
                explode.draw(g);
                break;
            }
            if (!plane.isLive()){
                printText(g, "YOU DIED", 100, 200, 400 , Color.WHITE);
                int finalTime = (int) ((endTime.getTime() - startTime.getTime())/1000);
                printText(g, "You lasted "+""+finalTime+" seconds", 50, 150, 500, Color.WHITE);
            }
        }
    }

    private void printText(Graphics g, String text, int size, int x, int y, Color color){
        Color c = g.getColor();
        g.setColor(color);
        Font f = new Font("宋体", Font.BOLD, size);
        g.setFont(f);
        g.drawString(text, x, y);
        g.setColor(c);
    }

    private Image offScreenImage = null;
    public void update(Graphics g){
        if (offScreenImage == null){
            offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage,0,0, null);
    }

    public static void main(String[] args){
        new PlaneGameFrame().launchFrame();
    }

    @Override
    public void launchFrame() {
        super.launchFrame();
        addKeyListener(new KeyMonitor());

        for (int i=0;i<8;i++){
            Bullet b = new Bullet("images/bullet.png", 400, 400, 10);
            bulletList.add(b);
        }

        startTime = new Date();
    }

    class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
           plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.minuDiretion(e);
        }
    }
}
