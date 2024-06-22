package com.airplaneWar.game.obj;

import com.airplaneWar.game.gameMian.GameStart;
import com.airplaneWar.game.gameMian.GameUtils;

import java.awt.*;

// 子弹类
public class MyBullet1Obj extends GameObj {

    public MyBullet1Obj(Image image, int width, int height, int x, int y, double speed, GameStart frame) {
        super(image, width, height, x, y, speed, frame);
    }


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        // 实现子弹的移动
        y -= speed;

        if (x < -250 || y > 900 || y < -200 || x > 750) {
            speed = 0;
            GameUtils.removeList.add(this);
            return;
        }
    }
}
