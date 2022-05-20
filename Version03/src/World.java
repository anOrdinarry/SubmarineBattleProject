/**
 * @author ChrStart
 * @create 2022-05-20 10:48
 */

/*
 * 游戏世界类
 *
 */

public class World {
    public static void main(String[] args) {

        // 创建1个战舰对象
        BattleShip bs = new BattleShip();

        // 创建侦察潜艇数组
        ObserveSubmarine[] oses = new ObserveSubmarine[3];
        oses[0] = new ObserveSubmarine();
        oses[1] = new ObserveSubmarine();
        oses[2] = new ObserveSubmarine();

        for (int i = 0; i < oses.length; i++) {
            System.out.println(oses[i].x + ", " + oses[i].y); // 输出每个水雷潜艇的x和y坐标
            oses[i].move(); // 每个水雷潜艇移动
        }

        System.out.println("--------------------------");

        // 创建鱼雷潜艇数组
        TorpedoSubmarine[] tses = new TorpedoSubmarine[2];
        tses[0] = new TorpedoSubmarine();
        tses[1] = new TorpedoSubmarine();

        for (int i = 0; i < tses.length; i++) {
            System.out.println(tses[i].x + ", " + tses[i].y);
            tses[i].move();
        }

        System.out.println("--------------------------");

        // 创建水雷潜艇数组
        MineSubmarine[] mses = new MineSubmarine[3];
        mses[0] = new MineSubmarine();
        mses[1] = new MineSubmarine();
        mses[2] = new MineSubmarine();

        for (int i = 0; i < mses.length; i++) {
            System.out.println(mses[i].x + ", " + mses[i].y);
            mses[i].move();
        }

        System.out.println("--------------------------");

        // 创建水雷数组
        Mine[] mes = new Mine[2];
        mes[0] = new Mine(100,200);
        mes[1] = new Mine(200,400);

        for (int i = 0; i < mes.length; i++) {
            System.out.println(mes[i].x + ", " + mes[i].y);
            mes[i].move();
        }

        System.out.println("--------------------------");

        // 创建炸弹数组
        Bomb[] bbs = new Bomb[2];
        bbs[0] = new Bomb(120,130);
        bbs[1] = new Bomb(210,220);

        for (int i = 0; i < bbs.length; i++) {
            System.out.println(bbs[i].x + ", " + bbs[i].y);
            bbs[i].move();
        }


    }
}












