/**
 * @author ChrStart
 * @date 2022/4/11 0011 - 19:44
 */

import javax.swing.*;

/* 水雷 类 */
public class Mine extends SeaObject{

    /* 构造方法 */
    public Mine(int x, int y) { // 水雷位置是变化的，依据水雷潜艇坐标得到水雷坐标

        super(11, 11, x, y, 1);

    }

    // 重写移动
    public void move() {
        y -= speed;
    }

    // 重写 getImage() 获取图片
    public ImageIcon getImage() {
        return Images.mine;  // 返回水雷图片
    }

    // 重写 isOutOfBounds() 检测水雷越界
    public boolean isOutOfBounds() {
        return y <= 150 - height;
    }

}































