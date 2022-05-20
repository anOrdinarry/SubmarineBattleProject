/**
 * @author ChrStart
 * @date 2022/4/13 0013 - 14:50
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/* 海洋 类 */
public abstract class SeaObject {

    // 对象状态
    public static final int LIVE = 0; // 活着的
    public static final int DEAD = 1; // 死了的

    protected int state = LIVE; // 当前状态，默认是活着的

    protected int  width; // 宽
    protected int height; // 高

    protected int x; // 横坐标
    protected int y; // 纵坐标

    protected int speed; // 速度

    /* 专门给侦查，鱼雷，水雷潜艇提供的 */
    // 三潜艇宽高不一样，则要传参
    public SeaObject(int width, int height) {

        this.width = width;
        this.height = height;

        // 构造方法是初始化赋值，后续再改，第一次赋值不动
        x = -width;

        // 窗口宽641，高479，y在150-460之间？
        Random rand = new Random();

        // 0-310 -> +150 -> 150-460
        y = rand.nextInt( World.HEIGHT - height - 150 + 1) + 150;

        speed = rand.nextInt(3) + 1; // 速度在1-3之间

    }

    /* 专门给战舰，深水炸弹，水雷提供的 */
    // 5个参数都不一样，都要传参
    public SeaObject(int width, int height, int x, int y, int speed) {

        this.width = width;
        this.height = height;

        this.x = x;
        this.y = y;

        this.speed = speed;

    }

    // 移动
    public abstract void move();

    // 获取对象的图片
    public abstract ImageIcon getImage();

    public boolean isLive() {
        return state == LIVE;
    }

    public boolean isDead() {
        return state == DEAD;
    }

    // 画对象
    public void paintImage(Graphics g) {

        if(isLive()) {
            this.getImage().paintIcon(null, g, this.x, this.y);
        }

    }

    // 检测潜艇越界
    public boolean isOutOfBounds() {
        return x > World.WIDTH;
    }

    // 碰撞检测
    public boolean isHit(SeaObject other) {

        int x1 = this.x - other.width;
        int x2 = this.x + this.width;

        int y1 = this.y - other.height;
        int y2 = this.y + this.height;

        int x = other.x;
        int y = other.y;

        return x >= x1 && x <= x2
               &&
               y >= y1 && y <= y2;
    }

    // 击中则消失
    public void goDead() {
         state = DEAD;
    }

}



























