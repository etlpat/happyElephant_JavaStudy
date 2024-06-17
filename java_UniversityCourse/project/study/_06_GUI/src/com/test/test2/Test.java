package com.test.test2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Button button = new Button();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("1234");
            }
        });
        frame.add(button, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.pack();
    }
}
