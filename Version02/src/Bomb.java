/**
 * @author ChrStart
 * @create 2022-05-20 10:30
 */

/*
 * 炸弹类 -- 战舰发射炸弹
 *
 */

public class Bomb {

    int width; // 宽
    int height; // 高

    int x; // x坐标
    int y; // y坐标

    int speed; // 移动速度

    // 给炸弹添加构造方法
    Bomb(int x, int y) {

        width = 9;
        height = 12;

        // 炸弹的坐标不能写死，要依据战舰的坐标算出炸弹的坐标
        this.x = x;
        this.y = y;

        speed = 3;

    }

    void move() {
        System.out.println("炸弹y向下移动");
    }

}


























