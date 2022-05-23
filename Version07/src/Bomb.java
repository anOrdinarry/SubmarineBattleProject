import javax.swing.*;

/**
 * @author ChrStart
 * @create 2022-05-20 10:30
 */

/*
 * 炸弹类
 *
 */

public class Bomb extends SeaObject {

    // 给炸弹添加构造方法
    public Bomb(int x, int y) { // 炸弹的坐标不能写死，要依据战舰的坐标算出炸弹的坐标

        super(9,12, x, y, 3); // 传的是x, y里面的数

    }

    // 重写 move() 移动
    @Override
    public void move() {
        y += speed; // y+(向下)
    }

    // 重写 getImage() 获取图片
    @Override
    public ImageIcon getImage() {
        return Images.bomb;
    }

}
