/**
 * @author ChrStart
 * @create 2022-05-20 10:27
 */

/*
 * 战舰类
 *
 */

public class BattleShip {

    int width; // 宽
    int height; // 高

    int x; // x坐标
    int y; // y坐标

    int speed; // 移动速度

    int life; // 战舰生命数

    // 给战舰添加构造方法
    BattleShip() {

        width = 66;
        height = 26;

        x = 270;
        y = 124;

        speed = 20;

        life = 5;

    }

    void move() {
        System.out.println("战舰左右移动");
    }

}



















