import java.util.Random;

/**
 * @author ChrStart
 * @create 2022-05-20 14:39
 */

/*
 * 海洋对象类
 *
 */

public class SeaObject {

    int width;
    int height;
    int x;
    int y;
    int speed;

    /* 专门为 三种潜艇 提供的 构造方法 */
    SeaObject(int width, int height) {

        this.width = width;
        this.height = height;

        x = - width;

        Random rand = new Random();
        y = rand.nextInt(479 - height - 150 + 1) + 150;

        speed = rand.nextInt(3) + 1;

    }

    /* 专门为 战舰、水雷、深水炸弹 提供的 构造方法 */
    SeaObject(int width, int height, int x, int y, int speed) {

        this.width = width;
        this.height = height;

        this.x = x;
        this.y = y;

        this.speed = speed;

    }

    void move() {
        System.out.println("海洋对象移动");
    }

}




























