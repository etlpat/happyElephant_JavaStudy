package com._02_AWT._02_Panel;

// 容器：Panel-面板
//
// (1)基本概念
//  Panel虽然也是容器，但是不能单独存在
//  Panel容器一般会添加到Frame窗口上（Panel看作Frame的组件）
//
// (2)Panel的布局管理
//  语法：public void setLayout(LayoutManager mgr);
//  三种布局：1.流式布局 2.东西南北中布局 3.表格布局


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PanelTest {
    public static void main(String[] args) {
        // (1)创建Frame窗口
        Frame frame = new Frame();
        // 方法:setBounds设置界限; 参数:(x坐标, y坐标, width宽度, height高度)
        frame.setBounds(300, 300, 500, 500);
        frame.setBackground(new Color(155, 34, 34));
        frame.setVisible(true);


        // (2)创建Panel面板
        Panel panel = new Panel();
        // 1.设置面板Panel属性
        panel.setBounds(30, 30, 50, 50);
        panel.setBackground(new Color(52, 137, 218));

        // 2.设置布局
        panel.setLayout(new FlowLayout());

        // 按钮组件
        Button button1 = new Button("button_1");
        Button button2 = new Button("button_1");
        Button button3 = new Button("button_1");


        // (3)将Panel作为组件添加到Frame窗口上
        frame.add(panel);


        // (4)添加事件监听，添加关闭窗口事件
        frame.addWindowListener(new WindowAdapter() {// 添加窗口适配器
            // （事件监听器WindowListener是接口，不可能将其全部实现，因此添加它对应的适配器（适配器就是将接口全部的方法进行空实现））
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);// 退出程序
            }
        });


    }
}
