/**
 * @author ChrStart
 * @create 2022-05-20 10:27
 */

/*
 * 战舰类
 *
 */

public class BattleShip {

    int width;
    int height;
    int x;
    int y;
    int speed;

    int life;

    // 给战舰添加构造方法
    BattleShip() {

        width = 66;
        height = 26;
        x = 270;
        y = 124;
        speed = 2;
        life = 5;

    }

    void move() {
        System.out.println("战舰左右移动");
    }

}
