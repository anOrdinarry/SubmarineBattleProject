/**
 * @author ChrStart
 * @create 2022-05-20 10:29
 */

/*
 * 水雷潜艇类 -- 水雷潜艇发射水雷
 *
 */

public class MineSubmarine extends SeaObject {

    // 给水雷潜艇添加构造方法
    public MineSubmarine() {

        super(63,19);

    }

    // 重写 move() 移动
    @Override
    public void move() {
        x += speed; // x+(向右)
    }

}
