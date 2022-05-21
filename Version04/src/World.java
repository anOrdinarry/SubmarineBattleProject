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

        // 将 侦察艇数组、鱼雷艇数组、水雷艇数组 统一组合为 SeaObject 数组
        SeaObject[] submarines = new SeaObject[5];
        submarines[0] = new ObserveSubmarine(); // 向上造型
        submarines[1] = new ObserveSubmarine();
        submarines[2] = new TorpedoSubmarine();
        submarines[3] = new TorpedoSubmarine();
        submarines[4] = new MineSubmarine();

        for (int i = 0; i < submarines.length; i++) {

            System.out.println("第" + (i + 1) + "个潜艇: ");

            SeaObject s = submarines[i]; // 获取每一个潜艇

            System.out.println("初始的坐标: " + s.x + ", " + s.y); // 获取每个潜艇的初始坐标

            s.move(); // 移动

            System.out.println("移动后坐标: "+ s.x + ", " + s.y); // 移动后坐标

            System.out.println();
        }

        System.out.println("--------------------------");

        // 创建水雷数组
        Mine[] mines = new Mine[4];
        mines[0] = new Mine(100,200);
        mines[1] = new Mine(110,120);
        mines[2] = new Mine(130,140);
        mines[3] = new Mine(140,150);

        for (int i = 0; i < mines.length; i++) {

            System.out.println("第" + (i + 1) + "个水雷: ");

            Mine m = mines[i]; // 获取每一个水雷

            System.out.println("初始的坐标: " + m.x + ", " + m.y);

            m.move(); // 移动

            System.out.println("移动后坐标: " + m.x + ", " + m.y); // 移动后坐标

            System.out.println();
        }

        System.out.println("--------------------------");

        // 创建炸弹数组
        Bomb[] bombs = new Bomb[2];
        bombs[0] = new Bomb(120,130);
        bombs[1] = new Bomb(210,220);

        for (int i = 0; i < bombs.length; i++) {

            System.out.println("第" + (i + 1) + "个炸弹: ");

            Bomb b = bombs[i]; // 获取每一个炸弹

            System.out.println("初始的坐标: " + b.x + ", " + b.y);

            b.move(); // 移动

            System.out.println("移动后坐标: " + b.x + ", " + b.y); // 移动后坐标

            System.out.println();
        }

    }
}


















