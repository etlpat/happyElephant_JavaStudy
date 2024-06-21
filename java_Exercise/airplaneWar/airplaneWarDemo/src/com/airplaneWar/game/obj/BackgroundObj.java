package com.airplaneWar.game.obj;

import java.awt.*;

// 背景图片类
public class BackgroundObj extends GameObj {

    public BackgroundObj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);

        y += speed;
        if (y >= 752) {
            y = -768;
        }
    }
}
