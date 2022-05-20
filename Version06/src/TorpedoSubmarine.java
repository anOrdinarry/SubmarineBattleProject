import javax.swing.*;

/**
 * @author ChrStart
 * @create 2022-05-20 10:29
 */

/*
 * 鱼雷潜艇类
 *
 */

public class TorpedoSubmarine extends SeaObject {

    // 给鱼雷潜艇添加构造方法
    public TorpedoSubmarine() {

        super(64,20);

    }

    public void move() {
        System.out.println("鱼雷潜艇x向右移动");
    }

    @Override
    public ImageIcon getImage() {
        return Images.torpesubm;
    }


}
