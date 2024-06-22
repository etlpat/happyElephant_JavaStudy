package com.airplaneWar.game.obj;

import com.airplaneWar.game.gameMian.GameStart;
import com.airplaneWar.game.gameMian.GameUtils;

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
        int range = 20;// 追踪范围，当子弹进入该范围便停止追踪
        int traceNum = 3;// 追踪系数，该值越高，子弹追踪性能越强
        MyPlaneObj myPlaneObj = (MyPlaneObj) GameUtils.allGameObjList.get(GameUtils.myPlaneIndex);
        if (x + width / 2 <= myPlaneObj.getX() + myPlaneObj.getWidth() / 2 - range) {
            x += speed / traceNum;
        } else if (x + width / 2 >= myPlaneObj.getX() + myPlaneObj.getWidth() / 2 + range) {
            x -= speed / traceNum;
        }
    }
}
