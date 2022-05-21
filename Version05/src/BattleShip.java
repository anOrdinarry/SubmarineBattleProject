/**
 * @author ChrStart
 * @create 2022-05-20 10:27
 */

/*
 * 战舰类 -- 战舰发射炸弹
 *
 */

public class BattleShip extends SeaObject {

    private int life; // 战舰生命数

    // 给战舰添加构造方法
    public BattleShip() {

        super(66,26,270,124,20);

        life = 5; // 设置战舰初始生命数

    }

    // 重写 move() 方法
    @Override
    public void move() {

    }

}
