/**
 * @author ChrStart
 * @date 2022/4/11 0011 - 20:09
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* 游戏世界 类 */
public class World extends JPanel {

    // 世界的宽高不变，用常量
    public static final int WIDTH = 641;
    public static final int HEIGHT = 479;

    public static final int RUNNING = 0; // 运行状态
    public static final int PAUSE = 1; // 暂停状态
    public static final int GAME_OVER = 2; // 游戏结束状态

    private int state = RUNNING; // 当前状态(默认为运行状态)

    // 如下这一堆为窗口中显示的对象
    private final BattleShip battleShip = new BattleShip();
    private SeaObject[] submarines = {};
    private Mine[] mines = {};
    private Bomb[] bombs = {};

    // 生成三种潜艇
    private SeaObject nextSubmarine() {

        Random rand = new Random(); // 随机数对象

        int type = rand.nextInt(20); // 0到19之间

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

    // 潜艇入场
    public int subEnterIndex = 0;

    private void submarineEnterAction() {

        subEnterIndex++;

        if(subEnterIndex % 40 == 0) { // 每400毫秒走一次

            SeaObject obj = nextSubmarine(); // 获取潜艇对象

            submarines = Arrays.copyOf(submarines, submarines.length + 1); // 扩容

            submarines[submarines.length - 1] = obj;

        }

    }

    // 水雷入场
    public int mineEnterIndex = 0;

    private void mineEnterAction() {

        mineEnterIndex++;

        if(mineEnterIndex % 100 == 0) { // 每1000毫秒走一次

            for (int i = 0; i < submarines.length; i++) {

                if(submarines[i] instanceof MineSubmarine) {

                    MineSubmarine ms = (MineSubmarine) submarines[i];

                    Mine obj = ms.shootMine(); // 获取水雷对象

                    mines = Arrays.copyOf(mines, mines.length + 1); // 扩容

                    mines[mines.length - 1] = obj; // 将obj添加到mines最后一个元素上

                }

            }

        }

    }

    // 海洋对象移动
    private void moveAction() {

        for (int i = 0; i < submarines.length; i++) { // 潜艇移动
            submarines[i].move();
        }

        for (int i = 0; i < mines.length; i++) { // 水雷移动
            mines[i].move();
        }

        for (int i = 0; i < bombs.length; i++) { // 深水炸弹移动
            bombs[i].move();
        }
    }

    // 删除越界的海洋对象
    private void OutOfBoundsAction() { // 每10毫秒走一次

        for (int i = 0; i < submarines.length; i++) { // 遍历所有潜艇

            if(submarines[i].isOutOfBounds() || submarines[i].isDead()) { // 越界了

                submarines[i] = submarines[submarines.length - 1];

                submarines = Arrays.copyOf(submarines, submarines.length - 1);

            }

        }

        for (int i = 0; i < mines.length; i++) { // 遍历所有水雷

            if(mines[i].isOutOfBounds() || mines[i].isDead()) {

                mines[i] = mines[mines.length - 1];

                mines = Arrays.copyOf(mines, mines.length - 1);

            }

        }

        for (int i = 0; i < bombs.length; i++) {

            if(bombs[i].isOutOfBounds() || bombs[i].isDead()) {

                bombs[i] = bombs[bombs.length - 1];

                bombs = Arrays.copyOf(bombs, bombs.length - 1);

            }

        }

    }

    public int score = 0; // 玩家得分

    // 深水炸弹与潜艇碰撞
    private void bombBangAction() { // 每10毫秒走一次

        for (int i = 0; i < bombs.length; i++) {

            Bomb b = bombs[i];

            for (int j = 0; j < submarines.length; j++) {

                SeaObject s = submarines[j];

                if(b.isLive() && s.isLive() && s.isHit(b)) {

                    s.goDead(); //潜艇消失
                    b.goDead(); //炸弹消失

                    if(s instanceof EnemyScore) {
                        EnemyScore es = (EnemyScore) s;
                        score += es.getScore();
                    }

                    if(s instanceof EnemyLife) { // 若被撞对象为命
                        EnemyLife el = (EnemyLife) s; // 将被撞对象强转成得命接口
                        int life = el.getLife(); // 获取命数
                        battleShip.addLife(life); // 战舰增加命
                    }

                }

            }

        }

    }

    // 水雷与战舰碰撞
    private void mineBangAction() { // 每10毫秒走一次

        for (int i = 0; i < mines.length; i++) {

            Mine m = mines[i];

            if(m.isLive() && battleShip.isLive() && m.isHit(battleShip)) {

                m.goDead(); //水雷死

                battleShip.subtractLife(); // 战舰减命

            }

        }

    }

    // 检测游戏结束
    private void checkGameAction() { // 每10毫秒走一次

        if(battleShip.getLife() <= 0) { // 战舰命数 <= 0，则游戏结束

            state = GAME_OVER; // 将当前运行状态改为游戏结束状态

        }

    }

    // 启动程序的执行
    private void action() {

        KeyAdapter k = new KeyAdapter() { // 键盘侦听器

            public void keyPressed(KeyEvent e) {  // 按下键盘某键时触发

                if(e.getKeyCode() == KeyEvent.VK_P) {

                    if(state == RUNNING) {
                        state = PAUSE;
                    }
                    else if(state == PAUSE) {
                        state = RUNNING;
                    }

                }

                if(state != RUNNING) {
                    return; // 不是运行态，结束时间处理
                }

                if(e.getKeyCode() == KeyEvent.VK_SPACE) {

                    Bomb obj = battleShip.shootBomb();
                    bombs = Arrays.copyOf(bombs, bombs.length + 1);
                    bombs[bombs.length - 1] = obj;

                }

                if(e.getKeyCode() == KeyEvent.VK_LEFT) { // 战舰左移
                    battleShip.moveLeft();
                }

                if(e.getKeyCode() == KeyEvent.VK_RIGHT) { // 战舰右移
                    battleShip.moveRight();
                }

            }
        };

        this.addKeyListener(k); // 不用掌握

        Timer timer = new Timer(); // 定时器对象

        int interval = 10; // 定时间隔，以毫秒为单位

        timer.schedule(new TimerTask() {

            public void run() {

                // 当是运行态时，才画出来

                if(state == RUNNING) {

                    submarineEnterAction(); //三潜艇入场

                    mineEnterAction(); // 水雷入场

                    moveAction(); // 海洋对象移动

                    OutOfBoundsAction(); // 删除越界的海洋对象

                    bombBangAction(); // 深水炸弹与潜艇碰撞

                    mineBangAction(); // 水雷与战舰碰撞

                    checkGameAction(); // 检测游戏结束

                }

                repaint(); // 重新调用paint方法——不需要知道
            }

        }, interval, interval); // 日程表
    }

    // 画图片
    public void paint(Graphics g) {

        Images.sea.paintIcon(null, g, 0, 0);

        battleShip.paintImage(g);

        for (int i = 0; i < submarines.length; i++) {
            submarines[i].paintImage(g);
        }

        for (int i = 0; i < mines.length; i++) {
            mines[i].paintImage(g);
        }

        for (int i = 0; i < bombs.length; i++) {
            bombs[i].paintImage(g);
        }


        g.drawString("SCORE: " + score, 200, 50); // 画分

        g.drawString("LIFE: " + battleShip.getLife(), 400, 50); // 画命

        if(state == GAME_OVER) { // 游戏结束状态时
            Images.gameover.paintIcon(null, g, 0, 0); // 画游戏结束图
        }

    }
    
    public static void main(String[] args) {

        // 画游戏面板，复制代码即可

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






















