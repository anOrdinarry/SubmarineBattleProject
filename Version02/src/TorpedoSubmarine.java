import java.util.Random;

/**
 * @author ChrStart
 * @create 2022-05-20 10:29
 */

/*
 * 鱼雷潜艇类
 *
 */

public class TorpedoSubmarine {

    int width; // 宽
    int height; // 高

    int x; // x坐标
    int y; // y坐标

    int speed; // 移动速度

    // 给鱼雷潜艇添加构造方法
    TorpedoSubmarine() {

        width = 64;
        height = 20;

        x = - width; // 负的潜艇的宽

        Random rand = new Random(); // 随机数对象

        // 窗口宽641，高479，y在150-460之间？
        // 0-310 -> +150 -> 150-460
        // rand.nextInt(3): [0,3), 左闭区间右开区间！！！
        y = rand.nextInt(479 - height - 150 + 1) + 150;

        speed = rand.nextInt(3) + 1; // 1~3之间的随机数

    }

    void move() {
        System.out.println("鱼雷潜艇x向右移动");
    }

}




























