import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.TimerTask;

import java.util.Timer; // timer.schedule(new TimerTask() 不导入此包, 这里会报错 ? ?

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

    private BattleShip ship = new BattleShip(); // 战舰 -- 就一个

    // 潜艇(侦察潜艇、鱼雷潜艇、水雷潜艇)数组
    private SeaObject[] submarines = {};

    // 水雷数组
    private Mine[] mines = {};

    // 炸弹数组
    private Bomb[] bombs = {};

    /** 随机生成潜艇 */
    public SeaObject nextSubmarine(){

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

    /** 潜艇入场 */
    public void submarineEnterAction() { // 每10毫秒走一次

        subEnterIndex++;

        if(subEnterIndex % 40 == 0) { // 每400毫秒

            SeaObject obj = nextSubmarine();

            submarines = Arrays.copyOf(submarines,submarines.length + 1);

            submarines[submarines.length - 1] = obj;

        }

    }

    private int mineEnterIndex = 0;

    /** 雷(鱼雷、水雷)入场 */
    public void MineEnterAction() {

        mineEnterIndex++;

        if(mineEnterIndex % 100 == 0){
            //如下代码暂时搁置-----第9天
        }

    }

    /** 海洋对象移动 */
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

    /** 启动程序的运行 */
    public void action() {

        Timer timer = new Timer();

        int interval = 10;

        timer.schedule(new TimerTask() {

            public void run() {

                submarineEnterAction(); // 潜艇(侦察、水雷、鱼雷)入场

                MineEnterAction();      // 水雷入场

                repaint();

            }

        }, interval, interval);

    }

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

        world.action(); // 启动程序的执行

    }
}


















