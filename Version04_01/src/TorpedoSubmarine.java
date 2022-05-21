/**
 * @author ChrStart
 * @create 2022-05-20 10:29
 */

/*
 * 鱼雷潜艇类
 *
 */

public class TorpedoSubmarine extends SeaObject {

    // 给鱼雷潜艇添加构造方法
    TorpedoSubmarine() {

        super(64,20);

    }

    // 重写 move() 移动
    @Override
    void move() {
        x += speed; // x+(向右)
    }

}
