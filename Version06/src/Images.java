import javax.swing.*;

/**
 * @author ChrStart
 * @create 2022-05-20 17:53
 */

/*
 * 图片类
 *
 */

public class Images {

    public static ImageIcon battleship; // 战舰

    public static ImageIcon obsersubm;  //侦察潜艇

    public static ImageIcon torpesubm;  //鱼雷潜艇

    public static ImageIcon minesubm;   //水雷潜艇

    public static ImageIcon mine;       //水雷

    public static ImageIcon bomb;       //炸弹

    public static ImageIcon sea;        //海洋图

    public static ImageIcon gameover;   //游戏结束图

    // 静态块，初始化静态资源 -> 这些图片
    static {

        battleship = new ImageIcon("images/battleship.png"); // 将 images 下的 battleship.png 图片，读到静态变量 battleship 中

        obsersubm = new ImageIcon("images/obsersubm.png");

        torpesubm = new ImageIcon("images/torpesubm.png");

        minesubm = new ImageIcon("images/minesubm.png");

        mine = new ImageIcon("images/mine.png");

        bomb = new ImageIcon("images/bomb.png");

        sea = new ImageIcon("images/sea.png");

        gameover = new ImageIcon("images/gameover.png");

    }

    // 读取图片
    // 运行此图片类，返回 8 则读取成功
    public static void main(String[] args) {

        System.out.println(battleship.getImageLoadStatus());

        System.out.println(obsersubm.getImageLoadStatus());

        System.out.println(torpesubm.getImageLoadStatus());

        System.out.println(minesubm.getImageLoadStatus());

        System.out.println(mine.getImageLoadStatus());

        System.out.println(bomb.getImageLoadStatus());

        System.out.println(sea.getImageLoadStatus());

        System.out.println(gameover.getImageLoadStatus());

    }

}
