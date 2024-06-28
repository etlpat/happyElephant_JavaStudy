package com.airplaneWar.game.gameMian;

import com.airplaneWar.game.obj.*;


// 该类用于提供创建游戏对象的静态方法（或者批量创建并存入列表）
public class CreateGameObjs {

    // 方法：用于批量创建我方飞机子弹（0~4级）
    // （将每级的子弹添加到myBulletObjList、allGameObjList集合中）
    public static void createLotOfMyBullets(MyPlaneObj myPlaneObj, GameStart gameStart, int cycleNum) {
        int speed = 12;

        // 利用switch-case语句，从上到下依次执行子弹效果
        // （这样能量的攻击方式可以兼容低能量的攻击方式，减少代码冗余）
        // 以下代码执行的优先级是0->4，因此需要从下到上分析这段代码
        switch (myPlaneObj.getEnergy()) {
            case 4:
                // 4能量：兼容3能量，并在侧前方交替发射4、5子弹
                // （4能量的子弹与3能量的子弹交替，3为左右左右，4为右左右左，组成完整的一排子弹）
                if (cycleNum % 2 == 1) {
                    GameUtils.myBullet4ObjList.add(new MyBullet4Obj(GameUtils.myBulletImg4, 53, 53,
                            myPlaneObj.getX() + myPlaneObj.getWidth() / 2 - 53 / 2, myPlaneObj.getY(), speed, gameStart));
                    GameUtils.allGameObjList.add(GameUtils.myBullet4ObjList.get(GameUtils.myBullet4ObjList.size() - 1));
                } else if (cycleNum % 2 == 0) {
                    GameUtils.myBullet5ObjList.add(new MyBullet5Obj(GameUtils.myBulletImg5, 53, 53,
                            myPlaneObj.getX() + myPlaneObj.getWidth() / 2 - 53 / 2, myPlaneObj.getY(), speed, gameStart));
                    GameUtils.allGameObjList.add(GameUtils.myBullet5ObjList.get(GameUtils.myBullet5ObjList.size() - 1));
                }

            case 3:
                // 3能量：兼容2能量，并在侧前方交替发射4、5子弹
                if (cycleNum % 2 == 0) {
                    GameUtils.myBullet4ObjList.add(new MyBullet4Obj(GameUtils.myBulletImg4, 53, 53,
                            myPlaneObj.getX() + myPlaneObj.getWidth() / 2 - 53 / 2, myPlaneObj.getY(), speed, gameStart));
                    GameUtils.allGameObjList.add(GameUtils.myBullet4ObjList.get(GameUtils.myBullet4ObjList.size() - 1));
                } else if (cycleNum % 2 == 1) {
                    GameUtils.myBullet5ObjList.add(new MyBullet5Obj(GameUtils.myBulletImg5, 53, 53,
                            myPlaneObj.getX() + myPlaneObj.getWidth() / 2 - 53 / 2, myPlaneObj.getY(), speed, gameStart));
                    GameUtils.allGameObjList.add(GameUtils.myBullet5ObjList.get(GameUtils.myBullet5ObjList.size() - 1));
                }

            case 2:
                // 2能量：兼容1能量，并在侧前方交替发射2、3子弹
                // （2能量的子弹与1能量的子弹交替，2为左右左右，1为右左右左，组成完整的一排子弹）
                if (cycleNum % 2 == 1) {
                    GameUtils.myBullet2ObjList.add(new MyBullet2Obj(GameUtils.myBulletImg2, 35, 68,
                            myPlaneObj.getX() + myPlaneObj.getWidth() / 2 - 35 / 2, myPlaneObj.getY() - 15, speed, gameStart));
                    GameUtils.allGameObjList.add(GameUtils.myBullet2ObjList.get(GameUtils.myBullet2ObjList.size() - 1));
                } else if (cycleNum % 2 == 0) {
                    GameUtils.myBullet3ObjList.add(new MyBullet3Obj(GameUtils.myBulletImg3, 35, 68,
                            myPlaneObj.getX() + myPlaneObj.getWidth() / 2 - 35 / 2, myPlaneObj.getY() - 15, speed, gameStart));
                    GameUtils.allGameObjList.add(GameUtils.myBullet3ObjList.get(GameUtils.myBullet3ObjList.size() - 1));
                }

            case 1:
                // 1能量：兼容0能量，并在侧前方交替发射2、3子弹
                if (cycleNum % 2 == 0) {
                    GameUtils.myBullet2ObjList.add(new MyBullet2Obj(GameUtils.myBulletImg2, 35, 68,
                            myPlaneObj.getX() + myPlaneObj.getWidth() / 2 - 35 / 2, myPlaneObj.getY() - 15, speed, gameStart));
                    GameUtils.allGameObjList.add(GameUtils.myBullet2ObjList.get(GameUtils.myBullet2ObjList.size() - 1));
                } else if (cycleNum % 2 == 1) {
                    GameUtils.myBullet3ObjList.add(new MyBullet3Obj(GameUtils.myBulletImg3, 35, 68,
                            myPlaneObj.getX() + myPlaneObj.getWidth() / 2 - 35 / 2, myPlaneObj.getY() - 15, speed, gameStart));
                    GameUtils.allGameObjList.add(GameUtils.myBullet3ObjList.get(GameUtils.myBullet3ObjList.size() - 1));
                }

            case 0:
                // 0能量：只有中间的弹道发射子弹
                // 为myBulletObjList列表中添加以当前飞机中轴为初始位置的子弹
                GameUtils.myBullet1ObjList.add(new MyBullet1Obj(GameUtils.myBulletImg1, 31, 68,
                        myPlaneObj.getX() + myPlaneObj.getWidth() / 2 - 31 / 2, myPlaneObj.getY() - 30, speed, gameStart));

                // 为allGameObjList列表中添加刚创建的子弹对象
                GameUtils.allGameObjList.add(GameUtils.myBullet1ObjList.get(GameUtils.myBullet1ObjList.size() - 1));
        }
    }


    // 方法：添加我方超级子弹
    public static void createLotOfMySuperBullets(MyPlaneObj myPlaneObj) {
        // 将子弹添加到mySuperBulletObjList列表
        GameUtils.mySuperBulletObjList.add(new MySuperBulletObj(myPlaneObj.getX() + myPlaneObj.getWidth() / 2 - 273 / 2,
                myPlaneObj.getY() - 30, 10));

        // 将子弹添加到allGameObjList列表
        GameUtils.allGameObjList.add(GameUtils.mySuperBulletObjList.get(GameUtils.mySuperBulletObjList.size() - 1));
    }


    // 方法：用于批量创建敌方小飞机
    // （并将小飞机添加到enemySmallPlaneList、allGameObjList集合中）
    public static void createLotOfEnemySmallPlaneObj(GameStart gameStart) {
        // 将小飞机添加到enemySmallPlaneList中
        GameUtils.enemySmallPlaneList.add(new EnemySmallPlaneObj(GameUtils.enemySmallPlaneImg1, 102, 79,
                GameUtils.random.nextInt(gameStart.getWidth() - 102 + 1), 0, 7, gameStart));

        // 将小飞机添加到allGameObjList中，方便打印
        GameUtils.allGameObjList.add(GameUtils.enemySmallPlaneList.get(GameUtils.enemySmallPlaneList.size() - 1));
    }


    // 方法：用于批量创建敌方大飞机（并将大飞机添加到enemyBigPlaneList、allGameObjList集合中）
    public static void createLotOfEnemyBigPlaneObj(GameStart gameStart) {
        // 将大飞机添加到enemyBigPlaneList中
        GameUtils.enemyBigPlaneList.add(new EnemyBigPlaneObj(GameUtils.enemyBigPlaneImg1, 80, 120,
                GameUtils.random.nextInt(gameStart.getWidth() - 80 + 1), 0, 5, gameStart));

        // 将大飞机添加到allGameObjList中，方便打印
        GameUtils.allGameObjList.add(GameUtils.enemyBigPlaneList.get(GameUtils.enemyBigPlaneList.size() - 1));
    }


    // 方法：用于批量创建敌方大飞机子弹
    public static void createLotOfEnemyBigPlaneBulletObj(GameStart gameStart) {
        // 若无大飞机，直接退出
        if (GameUtils.enemyBigPlaneList.size() <= 0) {
            return;
        }
        // 遍历每个大飞机，为其添加一个子弹
        for (EnemyBigPlaneObj bigPlane : GameUtils.enemyBigPlaneList) {
            // 大飞机出了界面，不发射子弹
            if (bigPlane.getY() >= 768) {
                continue;
            }

            // 将大飞机子弹添加到enemyBigPlaneBulletList中
            GameUtils.enemyBigPlaneBulletList.add(new EnemyBigPlaneBulletObj(GameUtils.enemyBigPlaneBulletImg1, 17, 18
                    , (bigPlane.getX() + bigPlane.getWidth() / 2 - 17 / 2),
                    bigPlane.getY() + bigPlane.getHeight(), 9, gameStart));

            // 将大飞机子弹添加到allGameObjList中
            GameUtils.allGameObjList.add(GameUtils.enemyBigPlaneBulletList.get(GameUtils.enemyBigPlaneBulletList.size() - 1));
        }
    }


    // 方法：用于创建敌方小boss，并添加到allGameObjList集合中
    public static void createLittleBoss(LittleBossObj littleBossObj) {
        GameUtils.littleBossFlag = true;// 表示生成过小boss
        GameUtils.allGameObjList.add(littleBossObj);

        // 获取敌方小boss，存入GameUtils中的静态对象中
        GameUtils.littleBossObj = littleBossObj;
    }


    // 方法：用于批量创建小boss子弹
    public static void createLotOfLittleBossBulletObj(LittleBossObj littleBossObj, GameStart gameStart) {
        // 若小boss不存在，直接退出
        if (GameUtils.littleBossFlag == false) {
            return;
        }
        // 若小boss不在场，直接退出
        if (!GameUtils.allGameObjList.contains(littleBossObj)
                || GameUtils.removeList.contains(littleBossObj)) {
            return;
        }

        // 将子弹添加到littleBossBulletList中
        GameUtils.littleBossBulletList.add(new LittleBossBulletObj(GameUtils.littleBossBulletImg1, 17, 35
                , (littleBossObj.getX() + littleBossObj.getWidth() / 2 - 17 / 2),
                littleBossObj.getY() + littleBossObj.getHeight() - 40, 12, gameStart));

        // 将子弹添加到allGameObjList中
        GameUtils.allGameObjList.add(GameUtils.littleBossBulletList.get(GameUtils.littleBossBulletList.size() - 1));
    }


    // 方法：用于创建爆炸效果对象，并将其添加到爆炸集合
    public static void createExplodeObj(int x, int y, String str) {
        GameUtils.explodeObjList.add(new ExplodeObj(x, y, str));
    }


    // 方法：用于创建补给品1（能量补给）
    public static void createGift1(int x, int y) {
        Gift1Obj gift1Obj = new Gift1Obj(GameUtils.giftImg1, 61, 58, x, y, 3);
        // 将补给添加到对应补给的列表（用于遍历实现碰撞）
        GameUtils.gift1List.add(gift1Obj);
        // 将补给添加到全部补给的列表（用于添加到allGiftList中）
        GameUtils.allGiftList.add(gift1Obj);
    }


    // 方法：用于创建补给品2（血量补给）
    public static void createGift2(int x, int y) {
        Gift2Obj gift2Obj = new Gift2Obj(GameUtils.giftImg2, 80, 45, x, y, 3);
        // 将补给添加到对应补给的列表（用于遍历实现碰撞）
        GameUtils.gift2List.add(gift2Obj);
        // 将补给添加到全部补给的列表（用于添加到allGiftList中）
        GameUtils.allGiftList.add(gift2Obj);
    }


    // 方法：用于创建补给品3（分数补给）
    public static void createGift3(int x, int y) {
        Gift3Obj gift3Obj = new Gift3Obj(GameUtils.giftImg3, 40, 41, x, y, 3);
        // 将补给添加到对应补给的列表（用于遍历实现碰撞）
        GameUtils.gift3List.add(gift3Obj);
        // 将补给添加到全部补给的列表（用于添加到allGiftList中）
        GameUtils.allGiftList.add(gift3Obj);
    }


    // 用于创建随机补给
    public static boolean createRandomGift(int x, int y, int randomNothingNum) {
        // randomNothingNum参数用于指定随机到Gift为空的概况
        // （randomNothingNum为0时，一定会随机到补给）

        int r = GameUtils.random.nextInt(4 + randomNothingNum * 4);
        if (r == 0 || r == 1) {// 能量补给
            createGift1(x, y);
        } else if (r == 2) {// 血量补给
            createGift2(x, y);
        } else if (r == 3) {// 分数补给
            createGift3(x, y);
        } else {
            return false;
        }
        return true;
    }


    // 方法：用于批量创建补给飞机
    public static void createLotOfGiftSupplyPlaneObj(GameStart gameStart) {
        GameUtils.giftSupplyPlaneArrayList.add(new GiftSupplyPlane(GameUtils.giftSupplyPlaneImg1, 58, 88,
                GameUtils.random.nextInt(gameStart.getWidth() - 58 + 1), 0, 6, gameStart));

        GameUtils.allGameObjList.add(GameUtils.giftSupplyPlaneArrayList.get(GameUtils.giftSupplyPlaneArrayList.size() - 1));
    }


    // 方法：用于创建敌方大boss，并添加到allGameObjList集合中
    public static void createBigBoss(BigBossObj bigBossObj) {
        GameUtils.bigBossFlag = true;// 表示生成过大boss
        GameUtils.allGameObjList.add(bigBossObj);

        // 获取敌方大boss，存入GameUtils中的静态对象中
        GameUtils.bigBossObj = bigBossObj;
    }


    // 方法：用于批量创建大boss子弹1
    public static void createLotOfBigBossBullet1Obj(BigBossObj bigBossObj, GameStart gameStart) {
        // 若大boss不存在，直接退出/被击败
        if (GameUtils.bigBossFlag == false) {
            return;
        }
        if (!GameUtils.allGameObjList.contains(bigBossObj)
                || GameUtils.removeList.contains(bigBossObj)) {
            return;
        }

        // 将左侧子弹添加到bigBossBullet1List、allGameObjList集合中
        GameUtils.bigBossBullet1List.add(new BigBossBullet1(GameUtils.bigBossBullet1Img, 30, 50
                , bigBossObj.getX() + 15,
                bigBossObj.getY() + 165, 15, gameStart));
        GameUtils.allGameObjList.add(GameUtils.bigBossBullet1List.get(GameUtils.bigBossBullet1List.size() - 1));

        // 将右侧子弹添加到bigBossBullet1List、allGameObjList集合中
        GameUtils.bigBossBullet1List.add(new BigBossBullet1(GameUtils.bigBossBullet1Img, 30, 50
                , bigBossObj.getX() + bigBossObj.getWidth() - 40,
                bigBossObj.getY() + 165, 15, gameStart));
        GameUtils.allGameObjList.add(GameUtils.bigBossBullet1List.get(GameUtils.bigBossBullet1List.size() - 1));
    }


    // 方法：用于批量创建大boss子弹2
    public static void createLotOfBigBossBullet2Obj(BigBossObj bigBossObj, GameStart gameStart) {
        // 若大boss不存在，直接退出/被击败
        if (GameUtils.bigBossFlag == false) {
            return;
        }
        if (!GameUtils.allGameObjList.contains(bigBossObj)
                || GameUtils.removeList.contains(bigBossObj)) {
            return;
        }

        // 将子弹添加到bigBossBullet2List、allGameObjList集合中
        GameUtils.bigBossBullet2List.add(new BigBossBullet2(GameUtils.bigBossBullet2Img, 40, 126
                , (bigBossObj.getX() + bigBossObj.getWidth() / 2 - 40 / 2),
                bigBossObj.getY() + bigBossObj.getHeight() - 120, 10, gameStart));
        GameUtils.allGameObjList.add(GameUtils.bigBossBullet2List.get(GameUtils.bigBossBullet2List.size() - 1));
    }
}
