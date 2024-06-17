package com._02_AWT._03_EventListening;

// 事件监听
//
// (1)事件监听器接口
//  ActionListener，是事件监听器【接口】，其中只有一个方法：actionPerformed
//  actionPerformed，表示当事件发生时，要运行的代码
//
//
// (2)为组件添加实现监听器
//  语法：（由于事件发生器接口只有一个接口，所以建议直接用匿名内部类）
//      组件对象.addActionListener(new ActionListener() {
//          @Override
//          public void actionPerformed(ActionEvent e) {
//              //实现事件的代码...
//          }
//      });
//
//


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventListeningTest {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setLayout(new BorderLayout());
        frame.setBounds(100, 100, 400, 400);
        frame.setBackground(new Color(196, 94, 94));
        frame.setVisible(true);

        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        button1.setBackground(new Color(16, 106, 145));
        button2.setBackground(new Color(15, 166, 50));
        frame.add(button1, BorderLayout.WEST);
        frame.add(button2, BorderLayout.EAST);

        // 为组件添加事件监听器
        button1.addActionListener(new ActionListener() {// 添加实现了事件监听接口的类对象
            @Override
            public void actionPerformed(ActionEvent e) {// 实现事件
                System.out.println("LLLLLLLLLL");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("RRRRRRRRRR");
            }
        });

        // 事件监听关闭弹窗
        frame.addWindowListener(new WindowAdapter() {// 创建适配器对象
            @Override
            public void windowClosing(WindowEvent e) {// 关闭弹窗
                System.exit(0);
            }
        });
    }
}
