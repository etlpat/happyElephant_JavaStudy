package com.airplaneWar.game.mian;

import com.airplaneWar.game.obj.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GameStart extends JFrame {
    // state记录游戏状态的变量
    // 0-未开始、1-游戏中、2-暂停、3-游戏失败、4-游戏通关
    public static int state = 0;

    // 用于记录游戏得分
    public static int score = 0;

    // num记录游戏开始后，页面刷新次数
    int num = 1;
    // myBulletsNum记录我方子弹发射次数
    int myBulletsNum = 0;

    // 定义缓存的图片（缓冲以解决闪动问题）
    Image offScreenImage = null;

    // 背景成员，用于绘制游戏开始后的背景
    BackgroundObj bgObj1 = new BackgroundObj(GameUtils.getRandomBgImage(), 0, 0, 2);
    BackgroundObj bgObj2 = new BackgroundObj(GameUtils.getRandomBgImage(), 0, -768, 2);
    BackgroundObj bgObj3 = new BackgroundObj(GameUtils.getRandomBgImage(), 0, -384, 2);

    // 我方飞机成员
    MyPlaneObj myPlaneObj = new MyPlaneObj(GameUtils.myPlaneImg1, 120, 100,
            getWidth() / 2 - 120 / 2, 520, 0, this);

    // 小boss成员
    LittleBossObj littleBossObj = new LittleBossObj(GameUtils.littleBossImg, 200, 140,
            (512 - 200) / 2, -100, 5, this);

    // 大boss成员
    BigBossObj bigBossObj = new BigBossObj(GameUtils.bigBossImg, 200, 302,
            (512 - 200) / 2, -320, 5, this);


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
                    System.out.println("开始游戏");
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


    // 用于清除垃圾对象
    void throwGarbage() {
//        try {
        GameUtils.allGameObjList.removeAll(GameUtils.removeList);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(e);
//        }
        GameUtils.myBullet1ObjList.removeAll(GameUtils.removeList);
        GameUtils.myBullet2ObjList.removeAll(GameUtils.removeList);
        GameUtils.myBullet3ObjList.removeAll(GameUtils.removeList);
        GameUtils.myBullet4ObjList.removeAll(GameUtils.removeList);
        GameUtils.myBullet5ObjList.removeAll(GameUtils.removeList);
        GameUtils.enemySmallPlaneList.removeAll(GameUtils.removeList);
        GameUtils.enemyBigPlaneList.removeAll(GameUtils.removeList);
        GameUtils.enemyBigPlaneBulletList.removeAll(GameUtils.removeList);
        GameUtils.explodeObjList.removeAll(GameUtils.removeList);
        GameUtils.littleBossBulletList.removeAll(GameUtils.removeList);
        GameUtils.allGiftList.removeAll(GameUtils.removeList);
        GameUtils.gift1List.removeAll(GameUtils.removeList);
        GameUtils.gift2List.removeAll(GameUtils.removeList);
        GameUtils.gift3List.removeAll(GameUtils.removeList);
        GameUtils.giftSupplyPlaneArrayList.removeAll(GameUtils.removeList);
        GameUtils.bigBossBullet1List.removeAll(GameUtils.removeList);
        GameUtils.bigBossBullet2List.removeAll(GameUtils.removeList);
        GameUtils.removeList.clear();
    }


    // 方法：launch，用于实现游戏主体
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
        while (true) {

            // ①循环事件1：根据循环次数创建GameObj对象
            //每n次循环，为我方飞机创建一个子弹

            if (num % 15 == 0) {
//            if (num % 9 == 0) {
                myBulletsNum++;
                CreateGameObjs.createLotOfMyBullets(myPlaneObj, this, myBulletsNum);
            }
            //每n次循环，创建一个敌方小飞机
            if (num % 60 == 0) {
//            if (num % 9 == 0) {
                CreateGameObjs.createLotOfEnemySmallPlaneObj(this);
            }
            //每n次循环，创建一个敌方大飞机
            if (num % 70 == 0) {
//            if (num % 9 == 0) {
                CreateGameObjs.createLotOfEnemyBigPlaneObj(this);
            }
            //每n次循环，所有大飞机发生一次子弹
            if (num % 40 == 0) {
//            if (num % 5 == 0) {
                CreateGameObjs.createLotOfEnemyBigPlaneBulletObj(this);
            }
            // 第n次刷新，添加小boss
            if (num % 250 == 0 && GameUtils.littleBossFlag == false) {
//            if (num % 1 == 0) {
                CreateGameObjs.createLittleBoss(littleBossObj);
            }
            // 每n次刷新，生成小boss子弹
            if (num % 55 == 0 || num % 55 == 4 || num % 55 == 8) {
//            if (num % 1 == 0) {
                CreateGameObjs.createLotOfLittleBossBulletObj(littleBossObj, this);
            }
            // 每n次刷新，生成补给飞机
            if (num % 90 == 0) {
//            if (num % 1 == 0) {
                CreateGameObjs.createLotOfGiftSupplyPlaneObj(this);
            }
            // 第n次刷新，添加大boss
            if (num % 500 == 0 && GameUtils.bigBossFlag == false
                    && GameUtils.littleBossFlag == true// 大boss未生成过，且小boss已经被玩家击败
                    && !GameUtils.allGameObjList.contains(littleBossObj)) {
//            if (num % 1 == 0) {
                CreateGameObjs.createBigBoss(bigBossObj);
            }
            // 第n次刷新，添加大boss子弹1
            if (num % 50 == 0 || num % 50 == 10) {
//            if (num % 1 == 0) {
                CreateGameObjs.createLotOfBigBossBullet1Obj(bigBossObj, this);
            }
            // 第n次刷新，添加大boss子弹2
            if (num % 90 == 0) {
//            if (num % 1 == 0) {
                CreateGameObjs.createLotOfBigBossBullet2Obj(bigBossObj, this);
            }

            // ②循环事件2：重新绘制界面
            repaint();


            // ③循环事件3：清除无用的GameObj对象
            if (num % 50 == 0) {
                // 每n次刷新，将要删除的元素从全部中列表中移除
                throwGarbage();
                System.out.println("垃圾删除成功");
            } else {
                // 每1次循环，将垃圾从allGameObjList中清除（之后就不会再绘制）
                // 求差集：allGameObjList = allGameObjList - removeList
//                try {
                GameUtils.allGameObjList.removeAll(GameUtils.removeList);
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    System.out.println(e);
//                }
            }


            // ④循环实现4：使线程休眠一定时间
            try {
                // 线程休眠，单位：毫秒
                Thread.sleep(30);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("GameUtils.allGameObjList.size():" + GameUtils.allGameObjList.size());

        }
    }


    // 方法：根据游戏状态state，绘制对应的游戏中的元素
    @Override
    public void paint(Graphics g) {
        // (1)获取初始化变量
        // 若缓存图片为空，创建缓存图片
        if (offScreenImage == null) {
            offScreenImage = createImage(512, 768);
        }
        // 获取缓冲图片的画笔
        Graphics graphics = offScreenImage.getGraphics();
        graphics.fillRect(0, 0, 512, 768);

        // 获取随机背景界面
        Image randomBgImage = GameUtils.getRandomBgImage();


        // (2)进行游戏状态判断，并执行对应功能
        if (state == 0) {// 当游戏未开始
            // 为JFrame窗体设置背景图片
            graphics.drawImage(randomBgImage, 0, 0, null);

            // 添加开始界面图片（导入GameUtil方法中定义的图片）
            graphics.drawImage(GameUtils.bossImg1, 160, 70, null);
            graphics.drawImage(GameUtils.boomImg1, 215, 390, null);
            graphics.drawImage(GameUtils.myPlaneImg1, 190, 520, null);

            // 设置并添加开始界面文字
            graphics.setColor(Color.white);// 设置文字颜色
            graphics.setFont(new Font("楷书", Font.BOLD, 40));// 设置字体
            graphics.drawString("点击屏幕开始游戏", 95, 300);// 设置文本内容、位置


        } else if (state == 1) {// 该状态变为游戏开始

            // num表示游戏开始后的刷新次数
            num++;
            System.out.println(num);

            // 将爆炸集合explodeObjList中的所有元素加入allGameObjList中
            GameUtils.allGameObjList.addAll(GameUtils.explodeObjList);
            GameUtils.explodeObjList.clear();

            // 将补给集合的所有元素加入allGameObjList中
            GameUtils.allGameObjList.addAll(GameUtils.allGiftList);
            GameUtils.allGiftList.clear();

            // 遍历gameObj集合，绘制所有GameObj类型的元素
            for (GameObj gameObj : GameUtils.allGameObjList) {
                if (gameObj == null) {
                    GameUtils.allGameObjList.remove(gameObj);
                    continue;
                }
                gameObj.paintSelf(graphics);
            }

        } else if (state == 2) { // 该状态表示暂停
            // 绘制背景图
            graphics.drawImage(bgObj1.getImage(), 0, 0, null);
            // 在背景图上显示文字
            GameUtils.drawWord(graphics, "游戏暂停", Color.RED, 50, 155, 300);

        } else if (state == 3) { // 该状态表示游戏失败
            // 绘制背景图
            graphics.drawImage(bgObj1.getImage(), 0, 0, null);
            // 在背景图上显示文字
            GameUtils.drawWord(graphics, "游戏失败", Color.RED, 50, 155, 300);

        } else if (state == 4) { // 该状态表示游戏通关
            // 绘制背景图
            graphics.drawImage(bgObj1.getImage(), 0, 0, null);
            // 在背景图上显示文字
            GameUtils.drawWord(graphics, "游戏通关", Color.RED, 50, 155, 300);

        }

        // 像屏幕绘制分数
        GameUtils.drawWord(graphics, "得分:" + score, Color.blue, 30, 40, 100);

        // 将缓冲图片绘制到窗口
        g.drawImage(offScreenImage, 0, 0, null);
    }


    public static void main(String[] args) {
        GameStart gameStart = new GameStart();
        gameStart.launch();
    }
}
