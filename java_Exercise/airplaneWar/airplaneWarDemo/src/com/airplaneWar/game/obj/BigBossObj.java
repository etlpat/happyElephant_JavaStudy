package com.airplaneWar.game.obj;

import com.airplaneWar.game.mian.CreateGameObjs;
import com.airplaneWar.game.mian.GameStart;
import com.airplaneWar.game.mian.GameUtils;

import java.awt.*;

public class BigBossObj extends GameObj {
    // 一级延时器，用于完整播放我方爆炸效果
    int endCount1 = 20;
    int thisEndCount1 = 0;

    // 二级延时器，用于延后失败状态切换时间
    int endCount2 = 20;
    int thisEndCount2 = 0;

    // 血量
    int HP = 99999999;
    int initHP = HP;

    // direction用于表示boss移动的方向
    int directionX = -1;
    int directionY = -1;


    public BigBossObj(Image image, int width, int height, int x, int y, double speed, GameStart frame) {
        super(image, width, height, x, y, speed, frame);
    }


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);

        // 若血量归零，敌方大boss爆炸并消失
        if (HP <= 0) {
            // (1)爆炸
            CreateGameObjs.createExplodeObj(x, y, "bigBossExplode");

            // (2)消失
            setX(-300);
            setY(1000);

            // (3)设置状态为4，表示游戏成功
            thisEndCount1++;
            if (thisEndCount1 >= endCount1) {
                if (thisEndCount2 < endCount2) {// 若延时器未到，先播放爆炸效果
                    for (int i = 0; i < 10; i++) {
                        CreateGameObjs.createExplodeObj(GameUtils.random.nextInt(512 - 94 + 10),
                                GameUtils.random.nextInt(768 - 120 + 30), "bigPlaneExplode");
                    }
                    thisEndCount2++;
                } else {
                    // 得分增加
                    GameStart.score += 35;
                    // 切换到状态4，游戏成功
                    GameStart.state = 4;
                }
            }

        } else {// 若血量不为0，boss左右移动

            // 若y不到40，持续向下移动
            if (y < 40) {
                y += speed / 2;
            } else {

                // 控制大boss在x方向的运动
                if (directionX == 1) {
                    if (x + width + speed > 512) {
                        directionX = -1;
                    }
                } else if (directionX == -1) {
                    if (x - speed < 0) {
                        directionX = 1;
                    }
                }
                x += directionX * speed;

                // 控制大boss在Y方向的运行
                if (directionY == 1) {
                    if (y + speed > 100) {
                        directionY = -1;
                    }
                } else if (directionY == -1) {
                    if (y - speed < 40) {
                        directionY = 1;
                    }
                }
                y += directionY * speed / 3;
            }


            // 碰撞检测：是否与我方1级子弹发生碰撞
            for (MyBullet1Obj bulletObj : GameUtils.myBullet1ObjList) {
                if (getGec().intersects(bulletObj.getGec())) {
                    // 我方飞机子弹消失
                    bulletObj.setX(-300);
                    bulletObj.setY(1000);
                    GameUtils.removeList.add(bulletObj);

                    // 大boss生命减少
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
        }

        // 绘制血条
        GameUtils.drawLifeBar(g, Color.orange, 195, 81, 255, 20, HP, initHP);
    }


    public int getEndCount1() {
        return endCount1;
    }

    public void setEndCount1(int endCount1) {
        this.endCount1 = endCount1;
    }

    public int getThisEndCount1() {
        return thisEndCount1;
    }

    public void setThisEndCount1(int thisEndCount1) {
        this.thisEndCount1 = thisEndCount1;
    }

    public int getEndCount2() {
        return endCount2;
    }

    public void setEndCount2(int endCount2) {
        this.endCount2 = endCount2;
    }

    public int getThisEndCount2() {
        return thisEndCount2;
    }

    public void setThisEndCount2(int thisEndCount2) {
        this.thisEndCount2 = thisEndCount2;
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

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }
}
