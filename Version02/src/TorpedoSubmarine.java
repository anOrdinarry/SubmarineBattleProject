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

    int width;
    int height;
    int x;
    int y;
    int speed;

    // 给鱼雷潜艇添加构造方法
    TorpedoSubmarine() {

        width = 64;
        height = 20;

        x = - width;

        Random rand = new Random();
        y = rand.nextInt(479 - height - 150 + 1) + 150;

        speed = rand.nextInt(3) + 1;

    }

    void move() {
        System.out.println("鱼雷潜艇x向右移动");
    }


}
