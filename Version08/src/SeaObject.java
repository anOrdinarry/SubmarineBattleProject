import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author ChrStart
 * @create 2022-05-20 14:39
 */

/*
 * 海洋对象类
 *
 */

public abstract class SeaObject {

    public static final int LIVE = 0;
    public static final int DEAD = 1;

    protected int state = LIVE; // 当前状态

    protected int width;
    protected int height;

    protected int x;
    protected int y;

    protected int speed;

    /* 专门为 三种潜艇 提供的 构造方法 */
    public SeaObject(int width, int height) {

        this.width = width;
        this.height = height;

        x = - width;

        Random rand = new Random();
        y = rand.nextInt(World.HEIGHT - height - 150 + 1) + 150;

        speed = rand.nextInt(3) + 1;

    }

    /* 专门为 战舰、水雷、深水炸弹 提供的 构造方法 */
    public SeaObject(int width, int height, int x, int y, int speed) {

        this.width = width;
        this.height = height;

        this.x = x;
        this.y = y;

        this.speed = speed;

    }

    public abstract void move();

    public abstract ImageIcon getImage();

    public boolean isLive() {
        return state == LIVE;
    }

    public boolean isDead() {
        return state == DEAD;
    }

    public void paintImage(Graphics g) {

        if(isLive()) {
            this.getImage().paintIcon(null,g,x,y);
        }

    }

    /** 检测潜艇越界 */
    public boolean isOutOfBounds() {
        return x >= World.WIDTH;  // x >= 窗口宽，即为越界了
    }

}




























