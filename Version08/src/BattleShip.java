import javax.swing.*;

/**
 * @author ChrStart
 * @create 2022-05-20 10:27
 */

/*
 * 战舰类
 *
 */

public class BattleShip extends SeaObject {

    private int life;

    // 给战舰添加构造方法
    public BattleShip() {

        super(66,26,270,124,20);

        life = 5;

    }

    public void move() {

    }

    @Override
    public ImageIcon getImage() {
        return Images.battleship;
    }

    public Bomb shoot() {
        return new Bomb(this.x, this.y);
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

}














