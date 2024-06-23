package com.airplaneWar.game.obj;

import com.airplaneWar.game.gameMian.CreateGameObjs;
import com.airplaneWar.game.gameMian.GameStart;
import com.airplaneWar.game.gameMian.GameUtils;

import java.awt.*;

public class EnemySmallPlaneObj extends GameObj {

    public EnemySmallPlaneObj(Image image, int width, int height, int x, int y, double speed, GameStart frame) {
        super(image, width, height, x, y, speed, frame);
    }


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y += speed;

        if (x < -250 || y > 900 || y < -200 || x > 750) {
            speed = 0;
            GameUtils.removeList.add(this);
            return;
        }

        // 实现小飞机横向追踪我方飞机
        int range = 45;// 用于记录x轴停止追踪的范围
        MyPlaneObj myPlaneObj = (MyPlaneObj) GameUtils.allGameObjList.get(GameUtils.myPlaneIndex);
        if (x + width / 2 <= myPlaneObj.getX() + myPlaneObj.getWidth() / 2 - range) {
            x += speed / 4;
        } else if (x + width / 2 >= myPlaneObj.getX() + myPlaneObj.getWidth() / 2 + range) {
            x -= speed / 4;
        }

        // 碰撞检测：是否与我方子弹发生碰撞
        // （由于敌方与我方飞机碰撞的事件已经在MyPlaneObj中实现，因此这里只实现与我方子弹的碰撞检测即可）
        if (GameUtils.myBullet1ObjList != null && GameUtils.myBullet1ObjList.size() > 0) {
            for (MyBullet1Obj bulletObj : GameUtils.myBullet1ObjList) {
                if (getGec().intersects(bulletObj.getGec())) {
                    // 我方飞机子弹消失
                    bulletObj.setX(-300);
                    bulletObj.setY(1000);
                    GameUtils.removeList.add(bulletObj);

                    // 敌方小飞机消失
                    // (1)产生爆炸效果
                    CreateGameObjs.createExplodeObj(x, y, "smallPlaneExplode");
                    // (2)小飞机消失
                    setX(-300);
                    setY(1000);
                    GameUtils.removeList.add(this);

                    // 得分增加
                    GameStart.score += 1;
                }
            }
        }

        // 碰撞检测：我方2级子弹
        if (GameUtils.myBullet2ObjList != null && GameUtils.myBullet2ObjList.size() > 0) {
            for (MyBullet2Obj bulletObj : GameUtils.myBullet2ObjList) {
                if (getGec().intersects(bulletObj.getGec())) {
                    // 我方飞机子弹消失
                    bulletObj.setX(-300);
                    bulletObj.setY(1000);
                    GameUtils.removeList.add(bulletObj);

                    // 敌方小飞机消失
                    CreateGameObjs.createExplodeObj(x, y, "smallPlaneExplode");
                    setX(-300);
                    setY(1000);
                    GameUtils.removeList.add(this);

                    // 得分增加
                    GameStart.score += 1;
                }
            }
        }

        // 碰撞检测：我方3级子弹
        if (GameUtils.myBullet3ObjList != null && GameUtils.myBullet3ObjList.size() > 0) {
            for (MyBullet3Obj bulletObj : GameUtils.myBullet3ObjList) {
                if (getGec().intersects(bulletObj.getGec())) {
                    // 我方飞机子弹消失
                    bulletObj.setX(-300);
                    bulletObj.setY(1000);
                    GameUtils.removeList.add(bulletObj);

                    // 敌方小飞机消失
                    CreateGameObjs.createExplodeObj(x, y, "smallPlaneExplode");
                    setX(-300);
                    setY(1000);
                    GameUtils.removeList.add(this);

                    // 得分增加
                    GameStart.score += 1;
                }
            }
        }

        // 碰撞检测：我方4级子弹
        if (GameUtils.myBullet4ObjList != null && GameUtils.myBullet4ObjList.size() > 0) {
            for (MyBullet4Obj bulletObj : GameUtils.myBullet4ObjList) {
                if (getGec().intersects(bulletObj.getGec())) {
                    // 我方飞机子弹消失
                    bulletObj.setX(-300);
                    bulletObj.setY(1000);
                    GameUtils.removeList.add(bulletObj);

                    // 敌方小飞机消失
                    CreateGameObjs.createExplodeObj(x, y, "smallPlaneExplode");
                    setX(-300);
                    setY(1000);
                    GameUtils.removeList.add(this);

                    // 得分增加
                    GameStart.score += 1;
                }
            }
        }

        // 碰撞检测：我方5级子弹
        if (GameUtils.myBullet5ObjList != null && GameUtils.myBullet5ObjList.size() > 0) {
            for (MyBullet5Obj bulletObj : GameUtils.myBullet5ObjList) {
                if (getGec().intersects(bulletObj.getGec())) {
                    // 我方飞机子弹消失
                    bulletObj.setX(-300);
                    bulletObj.setY(1000);
                    GameUtils.removeList.add(bulletObj);

                    // 敌方小飞机消失
                    CreateGameObjs.createExplodeObj(x, y, "smallPlaneExplode");
                    setX(-300);
                    setY(1000);
                    GameUtils.removeList.add(this);

                    // 得分增加
                    GameStart.score += 1;
                }
            }
        }

        // 碰撞检测：我方超级子弹
        if (GameUtils.mySuperBulletObjList != null && GameUtils.mySuperBulletObjList.size() > 0) {
            for (MySuperBulletObj bulletObj : GameUtils.mySuperBulletObjList) {
                if (getGec().intersects(bulletObj.getGec())) {
                    // 子弹HP-1
                    bulletObj.setHP(bulletObj.HP - 1);

                    // 敌方小飞机消失
                    CreateGameObjs.createExplodeObj(x, y, "smallPlaneExplode");
                    setX(-300);
                    setY(1000);
                    GameUtils.removeList.add(this);

                    // 得分增加
                    GameStart.score += 1;
                }
            }
        }

    }
}
