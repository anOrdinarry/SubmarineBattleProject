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

    // 重写 move() 移动
    @Override
    public void move() {
        x += speed; // x+(向右)
    }

    // 重写 getImage() 获取图片
    @Override
    public ImageIcon getImage() {
        return Images.torpesubm;
    }

}
