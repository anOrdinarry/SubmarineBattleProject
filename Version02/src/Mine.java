/**
 * @author ChrStart
 * @create 2022-05-20 10:30
 */

/*
 * 水雷类 -- 水雷潜艇发射水雷
 *
 */

public class Mine {

    int width; // 宽
    int height; // 高

    int x; // x坐标
    int y; // y坐标

    int speed; // 移动速度

    // 给水雷添加构造方法
    Mine(int x, int y) {

        width = 11;
        height = 11;

        // 水雷的坐标不能写死，要依据水雷潜艇的坐标算出水雷的坐标
        this.x = x;
        this.y = y;

        speed = 1;

    }

    void move() {
        System.out.println("水雷y向上移动");
    }

}



























