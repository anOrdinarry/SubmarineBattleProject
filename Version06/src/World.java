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

    private BattleShip ship = new BattleShip(); // 战舰

    // 潜艇(侦察潜艇、鱼雷潜艇、水雷潜艇)
    private SeaObject[] submarines = {
            new ObserveSubmarine(),
            new TorpedoSubmarine(),
            new MineSubmarine()
    };

    // 水雷
    private Mine[] mines = {
            new Mine(260,200)
    };

    // 炸弹
    private Bomb[] bombs = {
            new Bomb(200,190)
    };

    public void paint(Graphics g) {

        Images.sea.paintIcon(null,g,0,0); // 画海洋图

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

        frame.setSize(WIDTH + 16, HEIGHT + 39);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
}


















