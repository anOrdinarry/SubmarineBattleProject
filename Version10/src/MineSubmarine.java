/**
 * @author ChrStart
 * @date 2022/4/11 0011 - 19:43
 */

import javax.swing.*;

/* 水雷潜艇 类 */
public class MineSubmarine extends SeaObject implements EnemyLife{

    /* 构造方法 */
    public MineSubmarine() {

        super(63, 19);

    }

    // 重写移动
    public void move() {
        x += speed;
    }

    // 重写 getImage() 获取图片
    public ImageIcon getImage() {
        return Images.minesubm;  // 返回水雷潜艇图片
    }

    // 生成水雷对象
    public Mine shootMine() {

        int x = this.x + this.width;
        int y = this.y - 5;

        return new Mine(x,y);

    }

    // 重写 getLife() 得命
    public int getLife() {
        return 1; // 打掉水雷潜艇，战舰得1条命
    }

}



















