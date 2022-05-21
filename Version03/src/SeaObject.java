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

    int width; // 宽
    int height; // 高

    int x; // x坐标
    int y; // y坐标

    int speed; // 移动速度

    /* 专门为 三种潜艇 提供的 构造方法 */
    // 三种潜艇的宽和高不一样，所以数据不能写死，需要传参写活
    // 三种潜艇的x, y, speed是一样的，所以数据可以写死，不需要传参
    SeaObject(int width, int height) {

        this.width = width;
        this.height = height;

        x = - width; // 负的潜艇的宽

        Random rand = new Random(); // 随机数对象

        // 窗口宽641，高479，y在150-460之间？
        // 0-310 -> +150 -> 150-460
        // rand.nextInt(3): [0,3), 左闭区间右开区间！！！
        y = rand.nextInt(479 - height - 150 + 1) + 150;

        speed = rand.nextInt(3) + 1; // 1~3之间的随机数

    }

    /* 专门为 战舰、水雷、炸弹 提供的 构造方法 */
    // 战舰、水雷、炸弹三者的宽, 高, x, y, speed都是不一样的，
    // 所以数据不能写死，需要传参写活
    SeaObject(int width, int height, int x, int y, int speed) {

        this.width = width;
        this.height = height;

        this.x = x;
        this.y = y;

        this.speed = speed;

    }

    /* 移动 */
    void move() {
        System.out.println("海洋对象移动");
    }

}




























