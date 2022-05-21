/**
 * @author ChrStart
 * @create 2022-05-20 10:30
 */

/*
 * 水雷类
 *
 */

public class Mine extends SeaObject { // 水雷的坐标不能写死，要依据水雷潜艇的坐标算出水雷的坐标

    // 给水雷添加构造方法
    Mine(int x, int y) {

        super(11,11, x, y,1); // 传的是x, y里面的数

    }

    // 重写 move() 移动
    @Override
    void move() {
        y -= speed; // y-(向上)
    }

}
