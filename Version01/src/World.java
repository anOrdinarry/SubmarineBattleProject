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

        // 创建各个对象，给属性赋值，调用方法测试

        // 创建1个战舰对象
        BattleShip bs = new BattleShip();
        bs.width = 50;
        bs.height = 30;
        bs.x = 100;
        bs.y = 200;
        bs.speed = 20;
        bs.life = 5;
        System.out.println(bs.width + ", " + bs.height + ", " + bs.x + ", " + bs.y + ", " + bs.speed + ", "+ bs.life);
        bs.move();

        System.out.println("--------------------------");

        // 创建2个侦察潜艇对象
        ObserveSubmarine os1 = new ObserveSubmarine();
        os1.width = 30;
        os1.height = 40;
        os1.x = 200;
        os1.y = 400;
        os1.speed = 3;
        System.out.println(os1.width + ", " + os1.height + ", " + os1.x + ", " + os1.y + ", " + os1.speed);
        os1.move();

        System.out.println("--------------------------");

        ObserveSubmarine os2 = new ObserveSubmarine();
        os2.width = 20;
        os2.height = 30;
        os2.x = 100;
        os2.y = 200;
        os2.speed = 2;
        System.out.println(os2.width + ", " + os2.height + ", " + os2.x + ", " + os2.y + ", " + os2.speed);
        os2.move();

        System.out.println("--------------------------");

        // 创建2个鱼雷潜艇对象
        TorpedoSubmarine ts1 = new TorpedoSubmarine();
        TorpedoSubmarine ts2 = new TorpedoSubmarine();

        // 创建2个水雷潜艇对象
        MineSubmarine ms1 = new MineSubmarine();
        MineSubmarine ms2 = new MineSubmarine();

        // 创建2个水雷对象
        Mine mes1 = new Mine();
        Mine mes2 = new Mine();

        // 创建2个炸弹对象
        Bomb bb1 = new Bomb();
        Bomb bb2 = new Bomb();

    }

}


























