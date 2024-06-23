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

        // 当背景图片的y值>752，将该图片移到768位置
        // 这样用两张图片就可以实现背景的循环
        if (y >= 752) {
            y = -768;
        }
    }
}
