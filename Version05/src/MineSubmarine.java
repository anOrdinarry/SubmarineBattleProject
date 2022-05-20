/**
 * @author ChrStart
 * @create 2022-05-20 10:29
 */

/*
 * 水雷潜艇类
 *
 */

public class MineSubmarine extends SeaObject {

    // 给水雷潜艇添加构造方法
    public MineSubmarine() {

        super(63,19);

    }

    public void move() {
        x += speed;
    }


}
