/**
 * @author ChrStart
 * @create 2022-05-20 10:30
 */

/*
 * 炸弹类
 *
 */

public class Bomb {

    int width;
    int height;
    int x;
    int y;
    int speed;

    // 给炸弹添加构造方法
    Bomb(int x, int y) {

        width = 9;
        height = 12;

        this.x = x;
        this.y = y;

        speed = 1;

    }

    void move() {
        System.out.println("炸弹y向下移动");
    }

}
