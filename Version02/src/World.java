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

        // 创建4个侦察潜艇对象
        ObserveSubmarine os1 = new ObserveSubmarine();
        ObserveSubmarine os2 = new ObserveSubmarine();
        ObserveSubmarine os3 = new ObserveSubmarine();
        ObserveSubmarine os4 = new ObserveSubmarine();

        // 创建2个鱼雷潜艇对象
        TorpedoSubmarine ts1 = new TorpedoSubmarine();
        TorpedoSubmarine ts2 = new TorpedoSubmarine();

        // 创建2个水雷潜艇对象
        MineSubmarine ms1 = new MineSubmarine();
        MineSubmarine ms2 = new MineSubmarine();

        // 创建2个水雷对象
        Mine mes1 = new Mine(120, 110);
        Mine mes2 = new Mine(100, 130);

        // 创建2个炸弹对象
        Bomb bb1 = new Bomb(20, 30);
        Bomb bb2 = new Bomb(100, 200);

        System.out.println(bs.width + ", " + bs.height + ", " + bs.x + ", " + bs.y + ", " + bs.speed + ", " + bs.life);
        bs.move();

        System.out.println("--------------------------");

        System.out.println(os1.width + ", " + os1.height + ", " + os1.x + ", " + os1.y + ", " + os1.speed);
        System.out.println(os2.width + ", " + os2.height + ", " + os2.x + ", " + os2.y + ", " + os2.speed);
        os2.move();

        System.out.println("--------------------------");

        System.out.println(ts1.width + ", " + ts1.height + ", " + ts1.x + ", " + ts1.y + ", " + ts1.speed);
        System.out.println(ts2.width + ", " + ts2.height + ", " + ts2.x + ", " + ts2.y + ", " + ts2.speed);
        ts2.move();

        System.out.println("--------------------------");

        System.out.println(ms1.width + ", " + ms1.height + ", " + ms1.x + ", " + ms1.y + ", " + ms1.speed);
        ms1.move();

        System.out.println("--------------------------");

        System.out.println(mes2.width + ", " + mes2.height + ", " + mes2.x + ", " + mes2.y + ", " + mes2.speed);
        mes2.move();

        System.out.println("--------------------------");

        System.out.println(bb1.width + ", " + bb1.height + ", " + bb1.x + ", " + bb1.y + ", " + bb1.speed);
        bb1.move();

    }
}












