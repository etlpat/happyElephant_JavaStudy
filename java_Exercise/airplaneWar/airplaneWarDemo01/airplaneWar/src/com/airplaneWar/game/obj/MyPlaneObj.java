package com.airplaneWar.game.obj;

import com.airplaneWar.game.gameMian.CreateGameObjs;
import com.airplaneWar.game.gameMian.GameStart;
import com.airplaneWar.game.gameMian.GameUtils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// 我方飞机类
public class MyPlaneObj extends GameObj {
    int HP = 30;// 血量
    int initHP = HP;

    int energy = 0;// 能量（0-4，可以有5种状态）
    int overflowEnergy = 0;// 溢出能量：当普通能量满了，就增加到溢出能量中
    int lastEnergy = 0;// 用于记录上一轮的能量

    // 一级延时器，用于完整播放我方爆炸效果
    int endCount1 = 10;
    int thisEndCount1 = 0;

    // 延时器，用于延后失败状态切换时间
    int endCount2 = 20;
    int thisEndCount2 = 0;

    // 判断是否进入超级状态
    public boolean superStateFlag = false;


    public MyPlaneObj(Image image, int width, int height, int x, int y, double speed, GameStart frame) {
        super(image, width, height, x, y, speed, frame);
    }

    {
        // 代码块，用于在构造对象时添加功能
        // （为飞机的frame对象添加鼠标监听器）
        frame.addMouseMotionListener(new MouseAdapter() {
            // 设置该方法，使得飞机跟随鼠标移动
            @Override
            public void mouseMoved(MouseEvent e) {
                // （e为鼠标对象）
                // 飞机中轴的x坐标，变为鼠标的坐标
                // 飞机前1/4的坐标，变为鼠标的坐标
                x = e.getX() - width / 2;
                y = e.getY() - height / 4;
            }
        });


        // 添加键盘监听事件
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 当按下Z/z（键码值为90）
                // 变为超级形态（总能量-4，暂时变成超级子弹）
                if (e.getKeyCode() == 90) {
                    if (superStateFlag == false && energy == 4) {
                        // flag设为true
                        superStateFlag = true;

                        // 总能量-4
                        if (overflowEnergy >= 4) {
                            overflowEnergy -= 4;
                        } else {
                            energy -= (4 - overflowEnergy);
                            overflowEnergy = 0;
                        }
                    }
                }

                System.out.println(e.getKeyCode());
            }
        });
    }


    // 方法：飞机根据能量自动变换形态
    void changeModel() {

        // 当本次能量与上次能量不同，才改变外观
        if (energy != lastEnergy) {
            // ①改变我方飞机外观
            if (energy == 0) {
                image = GameUtils.myPlaneImg1;
                width = 120;
                height = 100;
            } else if (energy == 1) {
                image = GameUtils.myPlaneImg2;
                width = 122;
                height = 105;
            } else if (energy == 2) {
                image = GameUtils.myPlaneImg3;
                width = 122;
                height = 105;
            } else if (energy == 3) {
                image = GameUtils.myPlaneImg4;
                width = 122;
                height = 105;
            } else if (energy == 4) {
                image = GameUtils.myPlaneImg5;
                width = 129;
                height = 120;
                // 变为4形态，在周围产生爆炸效果
                int boomRange = -10;// boomRange表示爆炸圈围绕中心的距离（不能为0）
                CreateGameObjs.createExplodeObj(x + 20, y - 80 + height / boomRange, "bigPlaneExplode");
                CreateGameObjs.createExplodeObj(x + 20, y + 120 - height / boomRange, "bigPlaneExplode");
                CreateGameObjs.createExplodeObj(x - 70 + width / boomRange, y, "bigPlaneExplode");
                CreateGameObjs.createExplodeObj(x + 95 - width / boomRange, y, "bigPlaneExplode");
                CreateGameObjs.createExplodeObj(x - 45 + width / boomRange, y - 60 + height / boomRange, "bigPlaneExplode");
                CreateGameObjs.createExplodeObj(x - 45 + width * (boomRange - 1) / boomRange, y - 60 + height / boomRange, "bigPlaneExplode");
                CreateGameObjs.createExplodeObj(x - 45 + width / boomRange, y - 60 + height * (boomRange - 1) / boomRange, "bigPlaneExplode");
                CreateGameObjs.createExplodeObj(x - 45 + width * (boomRange - 1) / boomRange, y - 60 + height * (boomRange - 1) / boomRange, "bigPlaneExplode");
            }

            // ②重新记录上一轮的能量
            lastEnergy = energy;
        }
    }


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);

        if (HP <= 0) {
            // 若血量归0，我方飞机爆炸，游戏结束
            // (1)产生爆炸效果
            CreateGameObjs.createExplodeObj(x, y, "bigPlaneExplode");

            // (2)设置状态为3，表示游戏失败
            thisEndCount1++;
            if (thisEndCount1 >= endCount1) {
                if (thisEndCount2 < endCount2) {// 若延时器未到，先播放爆炸效果
                    for (int i = 0; i < 10; i++) {
                        CreateGameObjs.createExplodeObj(GameUtils.random.nextInt(512 - 94 + 10),
                                GameUtils.random.nextInt(768 - 120 + 30), "bigPlaneExplode");
                    }
                    thisEndCount2++;
                } else {
                    // 切换到状态3，游戏成功
                    GameStart.state = 3;
                }
            }

        } else {
            // 飞机随着能量变换形态
            changeModel();

            // 碰撞检测：
            //  介绍：用于检测发生碰撞后发生的事件
            //  语法：本对象.getGec().intersects(其它对象.getGec())
            //  功能：返回boolean值，表示是否发生碰撞
            //
            // 注意：
            //  1.碰撞是双向的，需要对双方都做出处理。
            //  2.但是，碰撞发生的事件只需在双方的其中一方实现即可。
            //
            // 本代码中：
            //  1.碰撞检测只在飞机类中实现（飞机中对飞机/子弹进行判断）
            //  2.检测的实现顺序是：我方飞机 -> 敌方飞机
            //      此时，在我方中实现了与敌方飞机的碰撞检测，在写敌方时就不需要再实现一次

            // 1.我方飞机和敌方小飞机碰撞
            for (EnemySmallPlaneObj smallPlane : GameUtils.enemySmallPlaneList) {
                // 若我方飞机和敌方飞机发生碰撞
                if (getGec().intersects(smallPlane.getGec())) {
                    // (1)产生爆炸效果
                    CreateGameObjs.createExplodeObj(x, y, "smallPlaneExplode");
                    // (2)敌方消失（移出屏幕，并加入移除集合）
                    smallPlane.setX(-300);
                    smallPlane.setY(1000);
                    GameUtils.removeList.add(smallPlane);
                    // (3)我方生命值减少
                    HP--;
                    // (4)分数增加
                    GameStart.score += 1;
                }
            }

            // 2.我方飞机和敌方大飞机碰撞
            for (EnemyBigPlaneObj bigPlane : GameUtils.enemyBigPlaneList) {
                // 若发生碰撞
                if (getGec().intersects(bigPlane.getGec())) {
                    // 注意：虽然敌方大飞机的生命为3，但是与我方碰撞后直接消失
                    // (1)产生爆炸效果
                    CreateGameObjs.createExplodeObj(x, y, "bigPlaneExplode");
                    // (2)敌方消失（移出屏幕，并加入移除集合）
                    bigPlane.setX(-300);
                    bigPlane.setY(1000);
                    GameUtils.removeList.add(bigPlane);
                    // (3)我方生命值减少
                    HP--;
                    // (4)分数增加
                    GameStart.score += 3;
                }
            }

            // 3.我方飞机和敌方大飞机子弹碰撞
            for (EnemyBigPlaneBulletObj bigPlaneBullet : GameUtils.enemyBigPlaneBulletList) {
                // 若发生碰撞
                if (getGec().intersects(bigPlaneBullet.getGec())) {
                    // 敌方子弹消失（移出屏幕，并加入移除集合）
                    bigPlaneBullet.setX(-300);
                    bigPlaneBullet.setY(1000);
                    GameUtils.removeList.add(bigPlaneBullet);
                    // 我方生命值减少
                    HP--;
                }
            }

            // 4.我方飞机和敌方小boss碰撞
            // 当敌方小boss存在，且在allGameObjList中，且未被放入removeList中，才能进行检测
            if (GameUtils.littleBossFlag == true
                    && GameUtils.littleBossObj != null
                    && GameUtils.allGameObjList.contains(GameUtils.littleBossObj)
                    && !GameUtils.removeList.contains(GameUtils.littleBossObj)) {

                if (getGec().intersects(GameUtils.littleBossObj.getGec())) {
                    // 发生碰撞，敌方boss血量归零
                    GameUtils.littleBossObj.setHP(0);
                    // 我方血量-999
                    HP -= 999;
                }
            }

            // 5.我方飞机与敌方小boss子弹碰撞
            for (LittleBossBulletObj bossBullet : GameUtils.littleBossBulletList) {
                if (getGec().intersects(bossBullet.getGec())) {
                    // 子弹消失
                    bossBullet.setX(-300);
                    bossBullet.setY(1000);
                    GameUtils.removeList.add(bossBullet);
                    // 我方生命值减少
                    HP--;
                }
            }

            // 6.我方飞机与补给gift1碰撞
            for (Gift1Obj giftObj : GameUtils.gift1List) {
                if (getGec().intersects(giftObj.getGec())) {
                    // 补给消失
                    giftObj.setX(-300);
                    giftObj.setY(1000);
                    GameUtils.removeList.add(giftObj);
                    // 我方能量增加
                    if (energy < 4) {// （若能量小于4，能量槽增加；若能量大于4，备用能量槽增加）
                        energy++;
                    } else {
                        overflowEnergy++;
                    }
                }
            }

            // 7.我方飞机与补给gift2碰撞
            for (Gift2Obj giftObj : GameUtils.gift2List) {
                if (getGec().intersects(giftObj.getGec())) {
                    // 补给消失
                    giftObj.setX(-300);
                    giftObj.setY(1000);
                    GameUtils.removeList.add(giftObj);
                    // 我方血量增加
                    HP += 3;
                }
            }

            // 8.我方飞机与补给gift3碰撞
            for (Gift3Obj giftObj : GameUtils.gift3List) {
                if (getGec().intersects(giftObj.getGec())) {
                    // 补给消失
                    giftObj.setX(-300);
                    giftObj.setY(1000);
                    GameUtils.removeList.add(giftObj);
                    // 分数增加
                    GameStart.score += 7;
                }
            }

            // 9.我方飞机与补给飞机碰撞
            for (GiftSupplyPlane giftSupplyPlane : GameUtils.giftSupplyPlaneArrayList) {
                if (getGec().intersects(giftSupplyPlane.getGec())) {
                    // 在前方生成补给
                    CreateGameObjs.createRandomGift(x + 20, y - 100, 0);
                    // 补给飞机爆炸、消失
                    CreateGameObjs.createExplodeObj(x, y, "bigPlaneExplode");
                    giftSupplyPlane.setX(-300);
                    giftSupplyPlane.setY(1000);
                    GameUtils.removeList.add(giftSupplyPlane);
                }
            }

            // 10.我方飞机和敌方大boss碰撞
            // 当敌方大boss存在，且在allGameObjList中，且未被放入removeList中，才能进行检测
            if (GameUtils.bigBossFlag == true
                    && GameUtils.bigBossObj != null
                    && GameUtils.allGameObjList.contains(GameUtils.bigBossObj)
                    && !GameUtils.removeList.contains(GameUtils.bigBossObj)) {

                if (getGec().intersects(GameUtils.bigBossObj.getGec())) {
                    // 我方血量归零
                    HP = 0;
                    //大boss爆炸并消失
                    CreateGameObjs.createExplodeObj(GameUtils.bigBossObj.getX(), GameUtils.bigBossObj.getY(), "bigBossExplode");
                    GameUtils.bigBossObj.setX(-300);
                    GameUtils.bigBossObj.setY(1000);
                }
            }

            // 11.我方飞机与敌方大boss子弹1碰撞
            for (BigBossBullet1 bossBullet : GameUtils.bigBossBullet1List) {
                if (getGec().intersects(bossBullet.getGec())) {
                    // 子弹消失
                    bossBullet.setX(-300);
                    bossBullet.setY(1000);
                    GameUtils.removeList.add(bossBullet);
                    // 我方生命值减少
                    HP--;
                }
            }

            // 12.我方飞机与敌方大boss子弹碰撞
            for (BigBossBullet2 bossBullet : GameUtils.bigBossBullet2List) {
                if (getGec().intersects(bossBullet.getGec())) {
                    // 子弹消失
                    bossBullet.setX(-300);
                    bossBullet.setY(1000);
                    GameUtils.removeList.add(bossBullet);
                    // 我方生命值减少
                    HP--;
                }
            }


            // 绘制血条
            GameUtils.drawLifeBar(g, Color.green, 80, 720, 255, 20, HP, initHP);
            // 绘制蓝条
            GameUtils.drawEnergyBar(g, Color.blue, Color.CYAN, 80, 680, 255, 20, energy, overflowEnergy);
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getOverflowEnergy() {
        return overflowEnergy;
    }

    public void setOverflowEnergy(int overflowEnergy) {
        this.overflowEnergy = overflowEnergy;
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

    public int getLastEnergy() {
        return lastEnergy;
    }

    public void setLastEnergy(int lastEnergy) {
        this.lastEnergy = lastEnergy;
    }

    public boolean isSuperStateFlag() {
        return superStateFlag;
    }

    public void setSuperStateFlag(boolean superStateFlag) {
        this.superStateFlag = superStateFlag;
    }
}


