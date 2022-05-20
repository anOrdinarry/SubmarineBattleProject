import javax.swing.*;

/**
 * @author ChrStart
 * @create 2022-05-20 10:29
 */

/*
 * 水雷潜艇类
 *
 */

public class MineSubmarine extends SeaObject {

    // 给水雷潜艇添加构造方法
    public MineSubmarine() {

        super(63,19);

    }

    public void move() {
        x += speed;
    }

    @Override
    public ImageIcon getImage() {
        return Images.minesubm;
    }

    /** 生成水雷对象 */
    public Mine shootMine() {

        int x = this.x + this.width; // x: 潜艇的x + 潜艇的宽

        int y = this.y - 5; // y: 潜艇的y - 5

        return new Mine(x,y);

    }

    public int getLife() {
        return 1;
    }

}






















