package com._02_AWT._01_Frame;

import java.awt.*;

// Frame：容器-窗口
// 用MyFrame继承Frame窗口

public class FrameTest {
    public static void main(String[] args) {
        // (1)Frame窗口基础使用
        // 1.创建窗口容器
        Frame frame = new Frame("Frame窗口");

        // 2.设置窗口属性
        frame.setVisible(true);// 窗口可见性
        frame.setSize(400,400);// 窗口大小
        frame.setBackground(new Color(50, 201, 189));// 设置窗口颜色
        frame.setLocation(800, 400);// 设置窗口弹出位置（初始在[0,0]，即左上角）
        //frame.setResizable(false);// 设置窗口大小不可变


        // (2)继承MyFrame对象
        new MyFrame("左上", 200, 200, 200, 200, Color.red);
        new MyFrame("右上", 200, 200, 200, 400, Color.green);
        new MyFrame("左下", 200, 200, 400, 200, Color.blue);
        new MyFrame("左上", 200, 200, 400, 400, Color.yellow);
    }
}
