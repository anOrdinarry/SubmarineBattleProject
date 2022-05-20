import javax.swing.*;

/**
 * @author ChrStart
 * @create 2022-05-20 10:30
 */

/*
 * 炸弹类
 *
 */

public class Bomb extends SeaObject {

    // 给炸弹添加构造方法
    public Bomb(int x, int y) {

        super(9,12, x, y, 3);

    }

    public void move() {
        y += speed;
    }

    @Override
    public ImageIcon getImage() {
        return Images.bomb;
    }

    /** 重写isOutOfBounds()检测深水炸弹越界 */
    public boolean isOutOfBounds() {
        return y >= World.HEIGHT; // y >= 窗口的高，即为越界了
    }

}























