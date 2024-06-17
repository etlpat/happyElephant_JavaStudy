package com.test.test1;

import java.awt.*;

public class MyRunnable implements Runnable {
    Panel panel;
    int start;
    int end;

    public MyRunnable(Panel panel, int start, int end) {
        this.panel = panel;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        while (true) {
            if (panel.getY() < end) {
                panel.setLocation(panel.getX(), panel.getY() + 20);
            } else {
                panel.setLocation(panel.getX(), start);
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
