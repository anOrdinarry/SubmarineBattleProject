/**
 * @author ChrStart
 * @date 2022/4/11 0011 - 19:41
 */

import javax.swing.*;

/* 侦查潜艇 类 */
public class ObserveSubmarine extends SeaObject implements EnemyScore {

    /* 构造方法 */
    public ObserveSubmarine() {

        super(63, 19);

    }

    // 重写移动
    public void move() {
        x += speed;
    }

    // 重写 getImage() 获取图片
    public ImageIcon getImage() {
        return Images.obsersubm;  // 返回侦查潜艇图片
    }

    // 重写 getScore() 得分
    public int getScore() {
        return 10; // 打掉侦查潜艇，得10分
    }

}




























