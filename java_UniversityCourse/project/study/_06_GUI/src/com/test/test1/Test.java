package com.test.test1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random rand = new Random();

        // 初始化Frame
        Frame frame = new Frame("窗口");
        frame.setLayout(null);
        frame.setBounds(100, 100, 600, 600);
        frame.setBackground(Color.cyan);
        frame.setVisible(true);

        // 初始化Panel
        Panel panel = new Panel();
        panel.setBounds(200, 0, 200, 200);
        panel.setBackground(Color.BLUE);
        frame.add(panel);

        //事件监听-关闭窗口
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 为panel添加按钮和事件监听
        panel.setLayout(new BorderLayout());
        Button button = new Button();
        button.setBackground(new Color(196, 85, 193));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setLocation(rand.nextInt(3) * 200, 0);
            }
        });
        panel.add(button);


        new Thread(new MyRunnable(panel,0, 600)).start();
    }
}
