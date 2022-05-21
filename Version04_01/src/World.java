import javax.swing.*;

/**
 * @author ChrStart
 * @create 2022-05-20 10:48
 */

/*
 * 游戏世界类
 *
 */

public class World extends JPanel {
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        World world = new World();

        world.setFocusable(true);

        frame.add(world);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(641 + 16, 479 + 39); // 这里+16是win10系统特性，+39的原因看此Module下的图片 -> img1.png

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }

}








































