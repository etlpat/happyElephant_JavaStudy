package com._02_AWT._01_Frame;

import java.awt.*;

public class MyFrame extends Frame {
    public MyFrame(String name, int width, int height, int x, int y, Color color) throws HeadlessException {
        setVisible(true);// 窗口可见性
        setSize(width, height);// 窗口大小
        setLocation(x, y);// 设置窗口弹出位置
        setBackground(color);// 设置窗口颜色
        setResizable(false);// 设置窗口大小不可变
    }
}
