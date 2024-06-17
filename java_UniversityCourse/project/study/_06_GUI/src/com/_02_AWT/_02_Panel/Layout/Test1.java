package com._02_AWT._02_Panel.Layout;

import java.awt.*;

public class Test1 {
    public static void main(String[] args) {
        Frame frame = new Frame("窗口test1");
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        Button button4 = new Button("button4");
        Button button5 = new Button("button5");
        Button button6 = new Button("button6");
        Button button7 = new Button("button7");
        Button button8 = new Button("button8");
        Button button9 = new Button("button9");
        Button button10 = new Button("button10");

        // 设置窗口属性
        frame.setBackground(new Color(102, 18, 183));
        frame.setBounds(100, 100, 400, 400);
        frame.setVisible(true);


        // 布局的嵌套
        // 1.frame分为上下两部分
        frame.setLayout(new GridLayout(2, 1));// 表格布局
        Panel panelUp = new Panel(new BorderLayout());// 东西南北中布局
        Panel panelDown = new Panel(new BorderLayout());
        frame.add(panelUp);
        frame.add(panelDown);
        // 2.frame的上半部分
        Panel panelUpCenter = new Panel(new GridLayout(2, 1));// 表格布局
        panelUp.add(button1, BorderLayout.WEST);
        panelUp.add(panelUpCenter, BorderLayout.CENTER);
        panelUpCenter.add(button2);
        panelUpCenter.add(button3);
        panelUp.add(button4, BorderLayout.EAST);
        // 3.frame的下半部分
        Panel panelDownCenter = new Panel(new GridLayout(2, 2));// 表格布局
        panelDown.add(button5, BorderLayout.WEST);
        panelDown.add(panelDownCenter, BorderLayout.CENTER);
        panelDownCenter.add(button6);
        panelDownCenter.add(button7);
        panelDownCenter.add(button8);
        panelDownCenter.add(button9);
        panelDown.add(button10, BorderLayout.EAST);
    }
}
