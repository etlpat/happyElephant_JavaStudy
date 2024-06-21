package com.airplaneWar.game.obj;

import com.airplaneWar.game.mian.GameStart;
import com.airplaneWar.game.mian.GameUtils;

import java.awt.*;

public class EnemyBigPlaneBulletObj extends GameObj {

    public EnemyBigPlaneBulletObj(Image image, int width, int height, int x, int y, double speed, GameStart frame) {
        super(image, width, height, x, y, speed, frame);
    }


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y += speed;

        if (x < -250 || y > 900 || y < -200 || x > 750) {
            speed = 0;
            GameUtils.removeList.add(this);
        }
    }
}