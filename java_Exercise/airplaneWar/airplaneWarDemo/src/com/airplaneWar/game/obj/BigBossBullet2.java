package com.airplaneWar.game.obj;

import com.airplaneWar.game.mian.GameStart;
import com.airplaneWar.game.mian.GameUtils;

import java.awt.*;

public class BigBossBullet2 extends GameObj {

    public BigBossBullet2(Image image, int width, int height, int x, int y, double speed, GameStart frame) {
        super(image, width, height, x, y, speed, frame);
    }


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);

        if (x < -250 || y > 900 || y < -200 || x > 750) {
            speed = 0;
            GameUtils.removeList.add(this);
            return;
        }

        y += speed;


        // 实现子弹跟踪我方飞机
        int range = 20;// 用于记录x轴停止追踪的范围
        MyPlaneObj myPlaneObj = (MyPlaneObj) GameUtils.allGameObjList.get(GameUtils.myPlaneIndex);
        if (x + width / 2 <= myPlaneObj.getX() + myPlaneObj.getWidth() / 2 - range) {
            x += speed / 3;
        } else if (x + width / 2 >= myPlaneObj.getX() + myPlaneObj.getWidth() / 2 + range) {
            x -= speed / 3;
        }
    }
}
