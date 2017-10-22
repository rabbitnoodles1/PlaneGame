package net.sunsi.util;
import java.awt.*;

public class GameUtil {
    private GameUtil(){}
    public static Image getImage(String path){
        return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
    }
}
