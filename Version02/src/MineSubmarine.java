import java.util.Random;

/**
 * @author ChrStart
 * @create 2022-05-20 10:29
 */

/*
 * 水雷潜艇类
 *
 */

public class MineSubmarine {

    int width;
    int height;
    int x;
    int y;
    int speed;

    // 给水雷潜艇添加构造方法
    MineSubmarine() {

        width = 63;
        height = 19;

        x = - width;

        Random rand = new Random();
        y = rand.nextInt(479 - height - 150 + 1) + 150;

        speed = rand.nextInt(3) + 1;

    }

    void move() {
        System.out.println("水雷潜艇x向右移动");
    }


}
