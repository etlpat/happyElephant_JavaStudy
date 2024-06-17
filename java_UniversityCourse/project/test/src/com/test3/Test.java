package com.test3;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("窗口");
        JButton jButton = new JButton("这是按钮");
        JPanel jPanel = new JPanel();// 桌布
        jFrame.add(jPanel);// 把桌布放窗口上
        jPanel.add(jButton);// 把按钮放桌布上


        // 设置窗口属性
        jFrame.setSize(400, 400);// 设置窗口大小
        jFrame.setLocationRelativeTo(null);// 居中
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// 关闭窗口退出程序
        jFrame.setVisible(true);// 可视


        // 给按钮添加事件监听器
        jButton.addActionListener(new ActionListener() {// 用匿名内部类实现事件监听器接口
            @Override// 只要点击鼠标，就会调用该函数
            public void actionPerformed(ActionEvent e) {
                System.out.println("123456");
            }
        });

    }
}
