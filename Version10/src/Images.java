/**
 * @author ChrStart
 * @date 2022/4/15 0015 - 16:29
 */

import javax.swing.*;

/* 图片 类 */
public class Images {

    public static ImageIcon battleship; //战舰

    public static ImageIcon obsersubm;  //侦察潜艇

    public static ImageIcon torpesubm;  //鱼雷潜艇

    public static ImageIcon minesubm;   //水雷潜艇

    public static ImageIcon mine;       //水雷

    public static ImageIcon bomb;       //深水炸弹

    public static ImageIcon sea;        //海洋图

    public static ImageIcon gameover;   //游戏结束图

    static{

        battleship = new ImageIcon("images/battleship.png");

        obsersubm = new ImageIcon("images/obsersubm.png");

        torpesubm = new ImageIcon("images/torpesubm.png");

        minesubm = new ImageIcon("images/minesubm.png");

        mine = new ImageIcon("images/mine.png");

        bomb = new ImageIcon("images/bomb.png");

        sea = new ImageIcon("images/sea.png");

        gameover = new ImageIcon("images/gameover.png");

    }

    public static void main(String[] args){

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





















