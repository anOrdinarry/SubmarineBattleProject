/**
 * @author ChrStart
 * @create 2022-05-20 10:28
 */

/*
 * 侦查潜艇类
 *
 */

public class ObserveSubmarine extends SeaObject {

    // 给侦查潜艇添加构造方法
    ObserveSubmarine() {

        super(63,19);

    }

    // 重写 move() 移动
    @Override
    void move() {
        x += speed; // x+(向右)
    }


}
