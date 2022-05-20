import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Random;

import java.util.Timer;
// timer.schedule(new TimerTask() 不导入此包, 这里会报错 ? ?

import java.util.TimerTask;

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

    private final BattleShip ship = new BattleShip(); // 战舰

    // 潜艇(侦察潜艇、鱼雷潜艇、水雷潜艇)
    private SeaObject[] submarines = {};

    // 水雷
    private Mine[] mines = {};

    // 炸弹
    private Bomb[] bombs = {};

    /* 随机生成潜艇 */
    public SeaObject nextSubmarine() {

        Random rand = new Random();

        int type = rand.nextInt(20);

        if(type < 10) {
            return new ObserveSubmarine();
        }
        else if(type < 15) {
            return new TorpedoSubmarine();
        }
        else {
            return new MineSubmarine();
        }

    }

    private int subEnterIndex = 0;

    /* 潜艇入场 */
    public void submarineEnterAction() { // 每10毫秒走一次

        subEnterIndex++;

        if(subEnterIndex % 40 == 0) { // 每400毫秒

            SeaObject obj = nextSubmarine();

            submarines = Arrays.copyOf(submarines,submarines.length + 1);

            submarines[submarines.length - 1] = obj;

        }

    }

    private int mineEnterIndex = 0;

    /* 雷(鱼雷、水雷)入场 */
    public void MineEnterAction() {

        mineEnterIndex++;

        if(mineEnterIndex % 100 == 0){

            for(int i = 0; i < submarines.length; i++) {

                if(submarines[i] instanceof MineSubmarine) {

                    MineSubmarine ms = (MineSubmarine) submarines[i];
                    Mine obj = ms.shootMine();
                    mines = Arrays.copyOf(mines, mines.length + 1);
                    mines[mines.length - 1] = obj;

                }
            }

        }

    }

    /* 海洋对象移动 */
    public void moveAction() {

        for(int i=0; i < submarines.length; i++) {
            submarines[i].move();
        }

        for(int i=0; i < mines.length; i++){
            mines[i].move();
        }

        for(int i=0; i < bombs.length; i++){
            bombs[i].move();
        }

    }

    /* 删除越界的对象 */
    public void outOfBoundsAction() {

        for (int i = 0; i < submarines.length; i++) {

            if (submarines[i].isOutOfBounds() || submarines[i].isDead()) {
                submarines[i] = submarines[submarines.length - 1];
                submarines = Arrays.copyOf(submarines, submarines.length - 1);
            }

        }

        for (int i = 0; i < mines.length; i++) {

            if (mines[i].isOutOfBounds() || mines[i].isDead()) {
                mines[i] = mines[mines.length - 1];
                mines = Arrays.copyOf(mines, mines.length - 1);
            }

        }

        for (int i = 0; i < bombs.length; i++) {

            if (bombs[i].isOutOfBounds() || bombs[i].isDead()) {
                bombs[i] = bombs[bombs.length - 1];
                bombs = Arrays.copyOf(bombs, bombs.length - 1);
            }

        }

    }

    private int score = 0; // 玩家得分

    // 深水炸弹与潜艇的碰撞
    public void bombBangAction() {

        for(int i=0; i < bombs.length; i++) {

            Bomb b = bombs[i];

            for(int j=0; j < submarines.length; j++) {

                SeaObject s = submarines[j];

                if(b.isLive() && s.isLive() && s.isHit(b)) {

                    b.goDead();
                    s.goDead();

                    if(s instanceof EnemyScore) {
                        EnemyScore es = (EnemyScore) s;
                        score += es.getScore();
                    }

                    if(s instanceof EnemyLife) {
                        EnemyLife ea = (EnemyLife) s;
                        int life = ea.getLife();
                        ship.addLife(life);
                    }

                }

            }

        }

    }

    /* 启动程序的运行 */
    public void action() {

        KeyAdapter k = new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_SPACE){

                    Bomb obj = ship.shoot(); // 深水炸弹入场

                    bombs = Arrays.copyOf(bombs,bombs.length+1);

                    bombs[bombs.length-1] = obj;

                }

                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    ship.moveLeft();
                }

                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    ship.moveRight();;
                }

            }
        };
        this.addKeyListener(k);

        Timer timer = new Timer();

        int interval = 10;

        timer.schedule(new TimerTask() {

            public void run() {

                submarineEnterAction(); // 潜艇(侦察、水雷、鱼雷)入场

                MineEnterAction();      // 水雷入场

                moveAction();           // 海洋对象移动

                outOfBoundsAction();    // 删除越界的对象

                bombBangAction();       // 深水炸弹与潜艇的碰撞

                repaint();

            }

        }, interval, interval);

    }

    public void paint(Graphics g) {

        Images.sea.paintIcon(null, g,0,0); // 画海洋图

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

        g.drawString("SCORE: " + score, 200, 50);

        g.drawString("LIFE: " + ship.getLife(), 400, 50);

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

        world.action();

    }
}


















