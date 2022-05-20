/**
 * @author ChrStart
 * @create 2022-05-20 10:30
 */

/*
 * 水雷类
 *
 */

public class Mine {

    int width;
    int height;
    int x;
    int y;
    int speed;

    // 给水雷添加构造方法
    Mine(int x, int y) {

        width = 11;
        height = 11;

        this.x = x;
        this.y = y;

        speed = 1;

    }

    void move() {
        System.out.println("水雷y向上移动");
    }

}
