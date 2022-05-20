/**
 * @author ChrStart
 * @date 2022/4/11 0011 - 19:45
 */

import javax.swing.*;

/* 深水炸弹 类 */
public class Bomb extends SeaObject{

    /* 构造方法 */
    public Bomb(int x, int y) {

        super(9, 12, x, y, 3);

    }

    // 重写移动
    public void move() {
        y += speed;
    }

    // 重写 getImage() 获取图片
    public ImageIcon getImage() {
        return Images.bomb;  // 返回深水炸弹图片
    }

    // 重写isOutOfBounds()检测深水炸弹越界
    public boolean isOutOfBounds() {
        return y >= World.HEIGHT;
    }

}













