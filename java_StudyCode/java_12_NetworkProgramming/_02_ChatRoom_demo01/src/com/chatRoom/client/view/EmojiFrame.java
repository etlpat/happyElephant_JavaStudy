package com.chatRoom.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


// 存放表情包的文本框
public class EmojiFrame extends JFrame {

    int frameWidth = 320;// 设置本窗体的宽
    int frameHeight = 190;// 设置本窗体的高
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// 获取屏幕大小
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;


    // 摆放表情包的文本框
    public EmojiFrame(JTextPane textPane) {
        // 设置初始属性
        JPanel panel = (JPanel) getContentPane();
        setSize(frameWidth, frameHeight);
        setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);
        setTitle("表情包库");
        panel.setLayout(null);

        // 用双重循环来摆放图片
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 6; col++) {
                // 得到图片（使用循环对应行列数，表示图片编号）
                ImageIcon icon = new ImageIcon("images/face/e" + (6 * row + col + 1) + ".gif");
                // 将图片放在JLable里
                JLabel lblIcon = new JLabel(icon);
                lblIcon.setSize(50, 50);
                lblIcon.setLocation(0 + col * 50, 0 + row * 50);// 将图片设置到窗体中对应的位置（行/列）

                // 为每个图片框体添加鼠标点击事件
                // （将点击的图片添加到输入框中）
                lblIcon.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // 得到被点击的图片
                        JLabel jLabel = (JLabel) e.getSource();
                        Icon icon2 = jLabel.getIcon();
                        // 将该图片插入到输入框中
                        textPane.insertIcon(icon2);
                        // 关闭当前图片框
                        EmojiFrame.this.dispose();
                    }
                });
                panel.add(lblIcon);
            }
        }

        // 设置框体可以被看到
        setVisible(true);
    }


    public static void main(String[] args) {
        new EmojiFrame(new JTextPane());
    }
}
