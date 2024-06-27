package com.airplaneWar.game.gameMian;

import com.airplaneWar.Main;
import com.airplaneWar.game.obj.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


// 该类用于创建游戏的主体方法
public class GameStart extends JFrame {
    // state属性，记录游戏状态的变量（0-未开始、1-游戏中、2-暂停、3-游戏失败、4-游戏通关）
    public static int state = 0;

    // score属性，用于记录游戏得分
    public static int score = 0;

    // isDispose属性，用于决定是否关闭整个窗口
    public boolean isDispose = false;

    // num记录游戏开始后，页面的刷新的次数
    public static int num = 1;
    // myBulletsNum记录我方(0~4级)子弹发射次数
    int myBulletsNum = 0;
    // myMaxSuperBulletsNum记录我方一次技能射击最多超级子弹的次数
    int myMaxSuperBulletsNum = 12;
    // mySuperBulletsNum记录当前射击超级子弹的次数
    int mySuperBulletsNum = 0;

    // 定义缓存的图片（缓冲以解决闪动问题）
    Image offScreenImage = null;
    // 定义双缓存画笔对象
    Graphics graphics = null;

    // 背景成员，用于绘制游戏开始后的背景
    BackgroundObj bgObj1 = new BackgroundObj(GameUtils.getRandomBgImage(), 0, 0, 2);
    BackgroundObj bgObj2 = new BackgroundObj(GameUtils.getRandomBgImage(), 0, -768, 2);
    BackgroundObj bgObj3 = new BackgroundObj(GameUtils.getRandomBgImage(), 0, -384, 2);

    // 我方飞机成员
    MyPlaneObj myPlaneObj = new MyPlaneObj(GameUtils.myPlaneImg1, 120, 100,
            getWidth() / 2 - 120 / 2, 520, 0, this);

    // 小boss成员
    LittleBossObj littleBossObj = new LittleBossObj(GameUtils.littleBossImg, 200, 140,
            (512 - 200) / 2, -141, 5, this);

    // 大boss成员
    BigBossObj bigBossObj = new BigBossObj(GameUtils.bigBossImg, 200, 302,
            (512 - 200) / 2, -303, 5, this);


    // 方法：设置JFrame窗口的配置信息
    public void setJFrameConfig() {
        // 设置窗口可见
        setVisible(true);
        // 设置窗口大小
        setSize(512, 768);
        // 设置窗口位置
        setLocationRelativeTo(null);
        // 设置窗口标题
        setTitle("airplane war");
        // 设置关闭窗口时结束进程
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加鼠标点击事件
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 当状态为0（游戏未开始），并点击鼠标左键
                if (state == 0 && e.getButton() == 1) {
                    state = 1;// 状态变为1（游戏开始）
                    System.out.println("游戏开始");


                } else if (state == 3 && e.getButton() == 1
                        || state == 4 && e.getButton() == 1) {// 当状态为3（失败）或4（通关）
                    isDispose = true;
                }
            }
        });

        // 添加键盘监听事件
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 当按下空格（键码值为32）
                if (e.getKeyCode() == 32) {
                    // 若为状态1（游戏中），变为状态2（暂停）
                    // 反之，操作相反
                    if (state == 1) {
                        state = 2;
                    } else if (state == 2) {
                        state = 1;
                    }
                }
            }
        });
    }


    // 方法：用于清除所有列表中的垃圾对象
    void throwGarbage() {
        GameUtils.allGameObjList.removeAll(GameUtils.removeList);
        GameUtils.myBullet1ObjList.removeAll(GameUtils.removeList);
        GameUtils.myBullet2ObjList.removeAll(GameUtils.removeList);
        GameUtils.myBullet3ObjList.removeAll(GameUtils.removeList);
        GameUtils.myBullet4ObjList.removeAll(GameUtils.removeList);
        GameUtils.myBullet5ObjList.removeAll(GameUtils.removeList);
        GameUtils.mySuperBulletObjList.removeAll(GameUtils.removeList);
        GameUtils.enemySmallPlaneList.removeAll(GameUtils.removeList);
        GameUtils.enemyBigPlaneList.removeAll(GameUtils.removeList);
        GameUtils.enemyBigPlaneBulletList.removeAll(GameUtils.removeList);
        GameUtils.littleBossBulletList.removeAll(GameUtils.removeList);
        GameUtils.explodeObjList.removeAll(GameUtils.removeList);
        GameUtils.gift1List.removeAll(GameUtils.removeList);
        GameUtils.gift2List.removeAll(GameUtils.removeList);
        GameUtils.gift3List.removeAll(GameUtils.removeList);
        GameUtils.allGiftList.removeAll(GameUtils.removeList);
        GameUtils.giftSupplyPlaneArrayList.removeAll(GameUtils.removeList);
        GameUtils.bigBossBullet1List.removeAll(GameUtils.removeList);
        GameUtils.bigBossBullet2List.removeAll(GameUtils.removeList);
        // 清除完所有列表中的垃圾对象后，即可清空removeList列表
        GameUtils.removeList.clear();
    }


    // 方法：launch，用于实现游戏主体
    //      调用该方法，即可开启游戏
    public void launch() {

        // (1)设置JFrameConfig配置信息
        this.setJFrameConfig();


        // (2)将所有要绘制的GameObj对象，放入allGameObjList集合中
        GameUtils.allGameObjList.add(bgObj3);// 添加背景
        GameUtils.allGameObjList.add(bgObj1);
        GameUtils.allGameObjList.add(bgObj2);
        GameUtils.allGameObjList.add(myPlaneObj);// 添加我方飞机
        GameUtils.myPlaneIndex = GameUtils.allGameObjList.size() - 1;// 获取我方飞机引索


        // (3)建立循环，用于重复刷新、绘制界面
        //    每次循环，调用repaint()方法，重复绘制本次页面
        while (true) {
            // 当游戏失败或成功，点击窗口退出游戏
            if (isDispose) {
                // 若isDispose属性为true，关闭窗口
                dispose();
                break;
            }

            // 当状态不为2（暂停），才需要重新绘制界面
            if (state != 2) {

                // ①循环事件1：在循环中创建游戏对象（根据取余，来决定创建对象的频率）
                //每n次循环，为我方飞机创建一个子弹
                if (myPlaneObj.superStateFlag == false) {
                    // 当处于普通状态，我方飞机射击普通子弹
                    if (num % 10 == 0) {
                        myBulletsNum++;
                        CreateGameObjs.createLotOfMyBullets(myPlaneObj, this, myBulletsNum);
                    }
                } else {
                    // 当处于超级状态，我方飞机射击超级子弹
                    if (mySuperBulletsNum < myMaxSuperBulletsNum) {
                        // 当目前超级子弹射击的个数未到达最大值，射击超级子弹
                        if (num % 25 == 0) {
                            CreateGameObjs.createLotOfMySuperBullets(myPlaneObj);
                            mySuperBulletsNum++;
                        }
                    } else {
                        // 当射击超级子弹个数到达上限，退出超级状态
                        myPlaneObj.superStateFlag = false;
                        mySuperBulletsNum = 0;
                    }
                }
                //每n次循环，创建一个敌方小飞机
                if (num % 25 == 0) {
                    CreateGameObjs.createLotOfEnemySmallPlaneObj(this);
                }
                //每n次循环，创建一个敌方大飞机
                if (num % 55 == 0) {
                    CreateGameObjs.createLotOfEnemyBigPlaneObj(this);
                }
                //每n次循环，所有大飞机发生一次子弹
                if (num % 45 == 0) {
                    CreateGameObjs.createLotOfEnemyBigPlaneBulletObj(this);
                }
                // 第n次刷新，添加小boss
                if (num % 500 == 0 && GameUtils.littleBossFlag == false) {
                    CreateGameObjs.createLittleBoss(littleBossObj);
                }
                // 每n次刷新，生成小boss子弹
                if (num % 55 == 0 || num % 55 == 5 || num % 55 == 10) {
                    CreateGameObjs.createLotOfLittleBossBulletObj(littleBossObj, this);
                }
                // 每n次刷新，生成补给飞机
                if (num % 80 == 0) {
                    CreateGameObjs.createLotOfGiftSupplyPlaneObj(this);
                }
                // 第n次刷新，添加大boss
                if (num % 800 == 0 && GameUtils.bigBossFlag == false
                        && GameUtils.littleBossFlag == true// 大boss未生成过，且小boss已经被玩家击败
                        && !GameUtils.allGameObjList.contains(littleBossObj)) {
                    CreateGameObjs.createBigBoss(bigBossObj);
                }
                // 第n次刷新，添加大boss子弹1
                if (num % 70 == 0 || num % 70 == 10) {
                    CreateGameObjs.createLotOfBigBossBullet1Obj(bigBossObj, this);
                }
                // 第n次刷新，添加大boss子弹2
                if (num % 90 == 0) {
                    CreateGameObjs.createLotOfBigBossBullet2Obj(bigBossObj, this);
                }


                // ②循环事件2：重新绘制界面
                repaint();


                // ③循环事件3：清除无用的GameObj对象
                if (num % 30 == 0) {
                    // 每n次刷新，将要删除的元素从【全部】列表中移除
                    throwGarbage();
                    System.out.println("垃圾删除成功");
                } else {
                    // 每1次循环，将垃圾从allGameObjList中清除（之后就不会再绘制）
                    // 求差集：allGameObjList = allGameObjList - removeList
                    GameUtils.allGameObjList.removeAll(GameUtils.removeList);
                }


                // 输出所以列表中的元素个数（监视代码性能）
                System.out.println("allGameObjList.size()=" + GameUtils.allGameObjList.size() +
                        "; (" +
                        GameUtils.myBullet1ObjList.size() + "," +
                        GameUtils.myBullet2ObjList.size() + "," +
                        GameUtils.myBullet3ObjList.size() + "," +
                        GameUtils.myBullet4ObjList.size() + "," +
                        GameUtils.myBullet5ObjList.size() + "," +
                        GameUtils.mySuperBulletObjList.size() + "," +
                        GameUtils.enemySmallPlaneList.size() + "," +
                        GameUtils.enemyBigPlaneList.size() + "," +
                        GameUtils.enemyBigPlaneBulletList.size() + "," +
                        GameUtils.littleBossBulletList.size() + "," +
                        GameUtils.explodeObjList.size() + "," +
                        GameUtils.gift1List.size() + "," +
                        GameUtils.gift2List.size() + "," +
                        GameUtils.gift3List.size() + "," +
                        GameUtils.allGiftList.size() + "," +
                        GameUtils.giftSupplyPlaneArrayList.size() + "," +
                        GameUtils.bigBossBullet1List.size() + "," +
                        GameUtils.bigBossBullet2List.size() +
                        ",[all:" + GameUtils.allGameObjList.size() +
                        "],[remove:" + GameUtils.removeList.size() + "])"
                );
            }

            // ④循环事件4：使线程休眠一定时间
            try {
                // 线程休眠，单位：毫秒
                Thread.sleep(30);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("游戏结束");
        // 将Main中的flag设置为false
        Main.flag = false;
    }


    // 方法：根据状态绘制游戏画面
    //      根据游戏状态state，进行各状态对应的操作
    //      launch中的repaint()方法，就是调用该方法
    @Override
    public void paint(Graphics g) {
        // (1)创建缓存图片、双缓存画笔对象，用于向屏幕绘制图片
        //  （1局游戏只创建1次）
        if (offScreenImage == null) {
            // 若缓存图片为空，创建缓存图片（用于缓存双缓存画笔对象绘制的图像）
            offScreenImage = createImage(512, 768);
        }
        if (graphics == null) {
            // 若双缓存画笔对象为空，获取缓存图片对应的双缓存画笔（向屏幕绘制图片，解决闪动问题）
            graphics = offScreenImage.getGraphics();
            graphics.fillRect(0, 0, 512, 768);
        }


        // (2)进行游戏状态判断，并执行对应功能
        if (state == 0) {// 当游戏未开始
            // 获取随机背景界面
            Image randomBgImage = GameUtils.getRandomBgImage();
            // 为JFrame窗体设置背景图片
            graphics.drawImage(randomBgImage, 0, 0, null);

            // 添加开始界面图片（导入GameUtil方法中定义的图片）
            graphics.drawImage(GameUtils.littleBossImg, 160, 70, null);
            graphics.drawImage(GameUtils.boomImg1, 215, 390, null);
            graphics.drawImage(GameUtils.myPlaneImg1, 190, 520, null);

            // 设置并添加开始界面文字
            GameUtils.drawWord(graphics, "点击屏幕开始游戏", Color.white, 40, 95, 300);


        } else if (state == 1) {// 该状态变为游戏开始

            // num表示游戏开始后的刷新次数
            num++;

            // 将爆炸集合explodeObjList中的所有元素加入allGameObjList中
            GameUtils.allGameObjList.addAll(GameUtils.explodeObjList);
            GameUtils.explodeObjList.clear();// 清空爆炸集合

            // 将补给集合的所有元素加入allGameObjList中
            GameUtils.allGameObjList.addAll(GameUtils.allGiftList);
            GameUtils.allGiftList.clear();// 清空补给集合

            // 遍历gameObj集合，绘制所有GameObj类型的元素
            if (GameUtils.allGameObjList != null && GameUtils.allGameObjList.size() > 0) {
                for (GameObj gameObj : GameUtils.allGameObjList) {
                    if (gameObj == null) {
                        GameUtils.allGameObjList.remove(gameObj);
                        continue;
                    }
                    gameObj.paintSelf(graphics);
                }
            }


        } else if (state == 3) { // 该状态表示游戏失败
            // 绘制背景图
            graphics.drawImage(bgObj1.getImage(), 0, 0, null);
            // 在背景图上显示文字
            GameUtils.drawWord(graphics, "游戏失败", Color.RED, 50, 155, 300);
            GameUtils.drawWord(graphics, "点击屏幕以结束", Color.RED, 40, 110, 385);


        } else if (state == 4) { // 该状态表示游戏通关
            // 绘制背景图
            graphics.drawImage(bgObj1.getImage(), 0, 0, null);
            // 在背景图上显示文字
            GameUtils.drawWord(graphics, "游戏通关", Color.RED, 50, 155, 300);
            GameUtils.drawWord(graphics, "点击屏幕以结束", Color.RED, 40, 110, 385);
        }

        // 像屏幕绘制分数
        GameUtils.drawWord(graphics, "距离:" + num + "米", Color.blue, 25, 40, 60);
        GameUtils.drawWord(graphics, "得分:" + score, Color.blue, 30, 40, 100);

        // 将缓冲图片绘制到窗口
        g.drawImage(offScreenImage, 0, 0, null);
    }


    public static void main(String[] args) {
        GameStart gameStart = new GameStart();
        gameStart.launch();
    }
}
