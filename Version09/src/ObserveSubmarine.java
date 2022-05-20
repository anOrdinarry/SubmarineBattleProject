import javax.swing.*;

/**
 * @author ChrStart
 * @create 2022-05-20 10:28
 */

/*
 * 侦查潜艇类
 *
 */

public class ObserveSubmarine extends SeaObject {

    // 给侦查潜艇添加构造方法
    public ObserveSubmarine() {

        super(63,19);

    }

    public void move() {
        x += speed;
    }

    @Override
    public ImageIcon getImage() {
        return Images.obsersubm;
    }

    public int getScore() {
        return 10;
    }

}































