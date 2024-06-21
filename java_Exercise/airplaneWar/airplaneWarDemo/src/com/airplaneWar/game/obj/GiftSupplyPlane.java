package com.airplaneWar.game.obj;

import com.airplaneWar.game.mian.CreateGameObjs;
import com.airplaneWar.game.mian.GameStart;
import com.airplaneWar.game.mian.GameUtils;

import java.awt.*;

public class GiftSupplyPlane extends GameObj {

    public GiftSupplyPlane(Image image, int width, int height, int x, int y, double speed, GameStart frame) {
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

        // 碰撞检测：是否与我方子弹发生碰撞
        for (MyBullet1Obj bulletObj : GameUtils.myBullet1ObjList) {
            if (getGec().intersects(bulletObj.getGec())) {
                // 我方飞机子弹消失
                bulletObj.setX(-300);
                bulletObj.setY(1000);
                GameUtils.removeList.add(bulletObj);

                // 补给飞机消失
                // (1)产生爆炸效果
                CreateGameObjs.createExplodeObj(x, y, "bigPlaneExplode");
                // (2)产生随机补给
                CreateGameObjs.createRandomGift(x, y, 0);
                // (3)补给飞机消失
                setX(-300);
                setY(1000);
                GameUtils.removeList.add(this);
            }
        }

        // 碰撞检测：我方2级子弹
        for (MyBullet2Obj bulletObj : GameUtils.myBullet2ObjList) {
            if (getGec().intersects(bulletObj.getGec())) {
                // 我方飞机子弹消失
                bulletObj.setX(-300);
                bulletObj.setY(1000);
                GameUtils.removeList.add(bulletObj);

                // 补给飞机消失
                CreateGameObjs.createExplodeObj(x, y, "bigPlaneExplode");
                CreateGameObjs.createRandomGift(x, y, 0);
                setX(-300);
                setY(1000);
                GameUtils.removeList.add(this);
            }
        }

        // 碰撞检测：我方3级子弹
        for (MyBullet3Obj bulletObj : GameUtils.myBullet3ObjList) {
            if (getGec().intersects(bulletObj.getGec())) {
                // 我方飞机子弹消失
                bulletObj.setX(-300);
                bulletObj.setY(1000);
                GameUtils.removeList.add(bulletObj);

                // 补给飞机消失
                CreateGameObjs.createExplodeObj(x, y, "bigPlaneExplode");
                CreateGameObjs.createRandomGift(x, y, 0);
                setX(-300);
                setY(1000);
                GameUtils.removeList.add(this);
            }
        }

        // 碰撞检测：我方4级子弹
        for (MyBullet4Obj bulletObj : GameUtils.myBullet4ObjList) {
            if (getGec().intersects(bulletObj.getGec())) {
                // 我方飞机子弹消失
                bulletObj.setX(-300);
                bulletObj.setY(1000);
                GameUtils.removeList.add(bulletObj);

                // 补给飞机消失
                CreateGameObjs.createExplodeObj(x, y, "bigPlaneExplode");
                CreateGameObjs.createRandomGift(x, y, 0);
                setX(-300);
                setY(1000);
                GameUtils.removeList.add(this);
            }
        }

        // 碰撞检测：我方5级子弹
        for (MyBullet5Obj bulletObj : GameUtils.myBullet5ObjList) {
            if (getGec().intersects(bulletObj.getGec())) {
                // 我方飞机子弹消失
                bulletObj.setX(-300);
                bulletObj.setY(1000);
                GameUtils.removeList.add(bulletObj);

                // 补给飞机消失
                CreateGameObjs.createExplodeObj(x, y, "bigPlaneExplode");
                CreateGameObjs.createRandomGift(x, y, 0);
                setX(-300);
                setY(1000);
                GameUtils.removeList.add(this);
            }
        }

    }
}
