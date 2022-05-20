/**
 * @author ChrStart
 * @date 2022/4/11 0011 - 19:41
 */

import javax.swing.*;

/* 战舰 类 */
public class BattleShip extends SeaObject { // 继承海洋类

    int life; // 生命数

    /* 构造方法 */
    public BattleShip() {

        super(66, 26, 270, 124, 20);

        life = 5;

    }

    public void move() {

    }

    // 重写 getImage() 获取图片
    public ImageIcon getImage() {
        return Images.battleship;  // 返回战舰图片
    }

    // 生成深水炸弹对象——战舰发射深水炸弹
    public Bomb shootBomb() {
        return new Bomb(this.x, this.y); // 战舰的x,y 在战舰这个类里
    }

    // 战舰左移
    public void moveLeft() {
        x -= speed;
    }

    // 战舰右移
    public void moveRight() {
        x += speed;
    }

    public void addLife(int num) {
        life += num; // 命数增加
    }

    public int getLife() {
        return life;
    }

    // 战舰减命
    public void subtractLife() {
        life--;
    }

}
























