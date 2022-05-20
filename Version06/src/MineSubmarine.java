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
        System.out.println("水雷潜艇x向右移动");
    }

    @Override
    public ImageIcon getImage() {
        return Images.minesubm;
    }


}
