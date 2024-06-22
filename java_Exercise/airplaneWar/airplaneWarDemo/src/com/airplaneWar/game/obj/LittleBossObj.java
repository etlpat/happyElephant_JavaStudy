package com.airplaneWar.game.obj;

import com.airplaneWar.game.gameMian.CreateGameObjs;
import com.airplaneWar.game.gameMian.GameStart;
import com.airplaneWar.game.gameMian.GameUtils;

import java.awt.*;

public class LittleBossObj extends GameObj {

    int HP = 200;
    int initHP = HP;

    public LittleBossObj(Image image, int width, int height, int x, int y, double speed, GameStart frame) {
        super(image, width, height, x, y, speed, frame);
    }

    int direction = 1;


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);

        // 若血量归零，敌方小boss爆炸并消失，然后出现补给
        if (HP <= 0) {
            // (1)产生爆炸效果
            int boomRange = 4;// boomRange表示爆炸圈围绕中心的距离（不能为0）
            CreateGameObjs.createExplodeObj(x + width / boomRange, y + height / boomRange, "bigPlaneExplode");
            CreateGameObjs.createExplodeObj(x + width * (boomRange - 1) / boomRange, y + height / boomRange, "bigPlaneExplode");
            CreateGameObjs.createExplodeObj(x + width / boomRange, y + height * (boomRange - 1) / boomRange, "bigPlaneExplode");
            CreateGameObjs.createExplodeObj(x + width * (boomRange - 1) / boomRange, y + height * (boomRange - 1) / boomRange, "bigPlaneExplode");
            CreateGameObjs.createExplodeObj(x + width / 2, y + height / 2, "bigPlaneExplode");

            // (2)出现补给
            CreateGameObjs.createGift1(x + width / 2, y + height * 3 / 4);

            // (3)大飞机消失
            setX(-300);
            setY(1000);
            GameUtils.removeList.add(this);

            // (4)得分增加
            GameStart.score += 15;

        } else {// 若血量不为0，boss左右移动

            if (y < 70) {
                y += speed / 2;
                HP = initHP; // y<70不掉血（除非碰撞）
            } else {
                // 若direction = 1，从左向右移动，反之，移动方向相反
                // 若飞机将要触碰墙壁，方向改变
                if (direction == 1) {
                    if (x + width + speed > 512) {
                        direction = -1;
                    }
                } else if (direction == -1) {
                    if (x - speed < 0) {
                        direction = 1;
                    }
                }
                x += direction * speed;
            }


            // 碰撞检测：是否与我方1级子弹发生碰撞
            for (MyBullet1Obj bulletObj : GameUtils.myBullet1ObjList) {
                if (getGec().intersects(bulletObj.getGec())) {
                    // 我方飞机子弹消失
                    bulletObj.setX(-300);
                    bulletObj.setY(1000);
                    GameUtils.removeList.add(bulletObj);

                    // 小boss生命减少
                    HP--;
                }
            }

            // 碰撞检测：我方2级子弹
            for (MyBullet2Obj bulletObj : GameUtils.myBullet2ObjList) {
                if (getGec().intersects(bulletObj.getGec())) {
                    bulletObj.setX(-300);
                    bulletObj.setY(1000);
                    GameUtils.removeList.add(bulletObj);
                    HP--;
                }
            }

            // 碰撞检测：我方3级子弹
            for (MyBullet3Obj bulletObj : GameUtils.myBullet3ObjList) {
                if (getGec().intersects(bulletObj.getGec())) {
                    bulletObj.setX(-300);
                    bulletObj.setY(1000);
                    GameUtils.removeList.add(bulletObj);
                    HP--;
                }
            }

            // 碰撞检测：我方4级子弹
            for (MyBullet4Obj bulletObj : GameUtils.myBullet4ObjList) {
                if (getGec().intersects(bulletObj.getGec())) {
                    bulletObj.setX(-300);
                    bulletObj.setY(1000);
                    GameUtils.removeList.add(bulletObj);
                    HP--;
                }
            }

            // 碰撞检测：我方5级子弹
            for (MyBullet5Obj bulletObj : GameUtils.myBullet5ObjList) {
                if (getGec().intersects(bulletObj.getGec())) {
                    bulletObj.setX(-300);
                    bulletObj.setY(1000);
                    GameUtils.removeList.add(bulletObj);
                    HP--;
                }
            }

            // 碰撞检测：我方超级子弹
            for (MySuperBulletObj bulletObj : GameUtils.mySuperBulletObjList) {
                if (getGec().intersects(bulletObj.getGec())) {
                    // 若子弹血量>=飞机血量
                    if (bulletObj.getHP() >= HP) {
                        bulletObj.setHP(bulletObj.getHP() - HP);
                        HP = 0;
                    } else {// 若飞机血量>子弹血量
                        HP -= bulletObj.getHP();
                        bulletObj.setHP(0);
                    }
                }
            }

            // 绘制血条
            GameUtils.drawLifeBar(g, Color.red, 195, 81, 200, 20, HP, initHP);
        }
    }


    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getInitHP() {
        return initHP;
    }

    public void setInitHP(int initHP) {
        this.initHP = initHP;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
