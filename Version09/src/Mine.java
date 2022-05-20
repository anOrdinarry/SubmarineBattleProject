import javax.swing.*;

/**
 * @author ChrStart
 * @create 2022-05-20 10:30
 */

/*
 * 水雷类
 *
 */

public class Mine extends SeaObject {

    // 给水雷添加构造方法
    public Mine(int x, int y) {

        super(11,11, x, y,1);

    }

    public void move() {
        y -= speed;
    }

    @Override
    public ImageIcon getImage() {
        return Images.mine;
    }

    /** 重写isOutOfBounds()检测水雷越界 */
    public boolean isOutOfBounds() {
        return y <= 150 - height; // y <= 150 减去水雷的高，即为越界了(到水面)
    }

}























