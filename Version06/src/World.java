import javax.swing.*;
import java.awt.*;

/**
 * @author ChrStart
 * @create 2022-05-20 10:48
 */

/*
 * 游戏世界类
 *
 */

public class World extends JPanel {

    public static final int WIDTH = 641; // 窗口的宽
    public static final int HEIGHT = 479; // 窗口的高

    /* 如下这一堆为窗口中所显示的对象 */

    // 战舰 -- 就一个
    private BattleShip ship = new BattleShip();

    // 潜艇(侦察潜艇、鱼雷潜艇、水雷潜艇)数组
    private SeaObject[] submarines = {
            new ObserveSubmarine(),
            new TorpedoSubmarine(),
            new MineSubmarine()
    };

    // 水雷数组
    private Mine[] mines = {
            new Mine(260,200)
    };

    // 炸弹数组
    private Bomb[] bombs = {
            new Bomb(200,190)
    };

    // 重写 JPanel类 中的 paint()方法，往窗口中画东西
    // g: 画笔
    // 想画东西要重写 paint()方法
    public void paint(Graphics g) { // 在画窗口时系统自动调用

        Images.sea.paintIcon(null, g, 0, 0); // 画海洋图 -- CV即可

        ship.paintImage(g);

        for(int i=0; i < submarines.length; i++) {
            submarines[i].paintImage(g);
        }

        for(int i=0; i < mines.length; i++) {
            mines[i].paintImage(g);
        }

        for(int i=0; i < bombs.length; i++) {
            bombs[i].paintImage(g);
        }

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        World world = new World();

        world.setFocusable(true);

        frame.add(world);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(WIDTH + 16, HEIGHT + 39); // 这里+16是win10系统特性，+39的原因看 Version04_01 下的图片 -> img1.png

        frame.setLocationRelativeTo(null);

        frame.setVisible(true); // 自动调用 paint()方法

    }

}


















