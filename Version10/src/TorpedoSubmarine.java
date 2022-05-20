/**
 * @author ChrStart
 * @date 2022/4/11 0011 - 19:42
 */

import javax.swing.*;

/* 鱼雷潜艇 类 */
public class TorpedoSubmarine extends SeaObject implements EnemyScore{

    /* 构造方法 */
    public TorpedoSubmarine() {

        super(63, 19);

    }

    // 重写移动
    public void move() {
        x += speed;
    }

    // 重写 getImage() 获取图片
    public ImageIcon getImage() {
        return Images.torpesubm;  // 返回鱼雷潜艇图片
    }

    //重写 getScore() 得分
    public int getScore() {
        return 40; // 打掉鱼雷潜艇，得40分
    }

}













