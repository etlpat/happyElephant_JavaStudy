package com.airplaneWar.game.gameMian;

import com.airplaneWar.game.obj.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


// 该类用于创建、存放与游戏对象相关的静态成员（如图片、对象列表等...）
// 以及存放各种工具静态方法
public class GameUtils {

    // ======================================== 图片静态成员 ====================================================

    // 获取背景图片
    public static Image backgroundImg1 = Toolkit.getDefaultToolkit().getImage("images/bg/bg.jpg");
    public static Image backgroundImg2 = Toolkit.getDefaultToolkit().getImage("images/bg/bg0.jpg");
    public static Image backgroundImg3 = Toolkit.getDefaultToolkit().getImage("images/bg/bg1.jpg");
    public static Image backgroundImg4 = Toolkit.getDefaultToolkit().getImage("images/bg/bg2.jpg");

    // 获取我方飞机图片
    public static Image myPlaneImg1 = Toolkit.getDefaultToolkit().getImage("images/hero/hero_b_1.png");
    public static Image myPlaneImg2 = Toolkit.getDefaultToolkit().getImage("images/hero/hero_b_02.png");
    public static Image myPlaneImg3 = Toolkit.getDefaultToolkit().getImage("images/hero/hero_b_03.png");
    public static Image myPlaneImg4 = Toolkit.getDefaultToolkit().getImage("images/hero/hero_b_04.png");
    public static Image myPlaneImg5 = Toolkit.getDefaultToolkit().getImage("images/hero/hero2.png");

    // 获取我方子弹图片
    public static Image myBulletImg1 = Toolkit.getDefaultToolkit().getImage("images/bullet/bullet1.png");
    public static Image myBulletImg2 = Toolkit.getDefaultToolkit().getImage("images/bullet/bullet3l.png");
    public static Image myBulletImg3 = Toolkit.getDefaultToolkit().getImage("images/bullet/bullet3r.png");
    public static Image myBulletImg4 = Toolkit.getDefaultToolkit().getImage("images/bullet/bullet4l.png");
    public static Image myBulletImg5 = Toolkit.getDefaultToolkit().getImage("images/bullet/bullet4r.png");

    // 获取敌方小飞机图片
    public static Image enemySmallPlaneImg1 = Toolkit.getDefaultToolkit().getImage("images/enemy/enemy.png");

    // 获取敌方大飞机图片
    public static Image enemyBigPlaneImg1 = Toolkit.getDefaultToolkit().getImage("images/enemy/enemy22.png");

    // 获取敌方大飞机子弹图片
    public static Image enemyBigPlaneBulletImg1 = Toolkit.getDefaultToolkit().getImage("images/bullet/enemy_bullet2.png");

    // 获取小boss的图片
    public static Image littleBossImg = Toolkit.getDefaultToolkit().getImage("images/enemy/boss.png");

    // 获取小boss子弹图片
    public static Image littleBossBulletImg1 = Toolkit.getDefaultToolkit().getImage("images/bullet/10.png");

    // 获取爆炸图片
    public static Image boomImg1 = Toolkit.getDefaultToolkit().getImage("images/boom/boom01.png");

    // 获取补给的图片
    public static Image giftImg1 = Toolkit.getDefaultToolkit().getImage("images/hero/article1.png");
    public static Image giftImg2 = Toolkit.getDefaultToolkit().getImage("images/hero/hero_blood.png");
    public static Image giftImg3 = Toolkit.getDefaultToolkit().getImage("images/hero/supply.png");

    // 获取补给飞机图片
    public static Image giftSupplyPlaneImg1 = Toolkit.getDefaultToolkit().getImage("images/hero/bullet_supply.png");

    // 获取大boss图片
    public static Image bigBossImg = Toolkit.getDefaultToolkit().getImage("images/enemy/super_boss.png");

    // 获取大boss子弹图片
    public static Image bigBossBullet1Img = Toolkit.getDefaultToolkit().getImage("images/bullet/boss_bullet2.png");
    public static Image bigBossBullet2Img = Toolkit.getDefaultToolkit().getImage("images/bullet/boss_bullet.png");


    // ======================================== 列表静态成员 ====================================================

    // 用于存放所有游戏元素对象的集合[多态，父类集合存放子类对象，通用执行绘制方法]（该集合用于将游戏元素批量绘制到窗口）
    public static ArrayList<GameObj> allGameObjList = new ArrayList<>();

    // 创建要移除游戏的元素的集合（用于记录要被删除的元素，之后其它集合和该集合求差集，功能相当于垃圾桶）
    public static ArrayList<GameObj> removeList = new ArrayList<>();

    // 创建我方子弹对象集合
    public static ArrayList<MyBullet1Obj> myBullet1ObjList = new ArrayList<>();
    public static ArrayList<MyBullet2Obj> myBullet2ObjList = new ArrayList<>();
    public static ArrayList<MyBullet3Obj> myBullet3ObjList = new ArrayList<>();
    public static ArrayList<MyBullet4Obj> myBullet4ObjList = new ArrayList<>();
    public static ArrayList<MyBullet5Obj> myBullet5ObjList = new ArrayList<>();

    // 创建我方超级子弹集合
    public static ArrayList<MySuperBulletObj> mySuperBulletObjList = new ArrayList<>();

    // 创建敌方小飞机对象集合
    public static ArrayList<EnemySmallPlaneObj> enemySmallPlaneList = new ArrayList<>();

    // 创建敌方大飞机对象集合
    public static ArrayList<EnemyBigPlaneObj> enemyBigPlaneList = new ArrayList<>();

    // 创建敌方大飞机子弹对象集合
    public static ArrayList<EnemyBigPlaneBulletObj> enemyBigPlaneBulletList = new ArrayList<>();

    // 创建敌方小boss子弹集合
    public static ArrayList<LittleBossBulletObj> littleBossBulletList = new ArrayList<>();

    // 创建爆炸集合
    public static ArrayList<ExplodeObj> explodeObjList = new ArrayList<>();

    // 创建补给列表
    public static ArrayList<Gift1Obj> gift1List = new ArrayList<>();
    public static ArrayList<Gift2Obj> gift2List = new ArrayList<>();
    public static ArrayList<Gift3Obj> gift3List = new ArrayList<>();

    // 创建存放全部补给的列表
    public static ArrayList<GameObj> allGiftList = new ArrayList<>();

    // 创建补给飞机列表
    public static ArrayList<GiftSupplyPlane> giftSupplyPlaneArrayList = new ArrayList<>();

    // 创建大boss子弹列表
    public static ArrayList<BigBossBullet1> bigBossBullet1List = new ArrayList<>();
    public static ArrayList<BigBossBullet2> bigBossBullet2List = new ArrayList<>();


    // ======================================== 其它静态成员 ====================================================

    public static Random random = new Random();

    // 用于存放背景图片，实现随机生成背景图的map
    public static HashMap<String, Image> bgImageMap = null;

    // 随机背景图片编号，初始为null
    public static Integer randomBgImageIndex = null;

    // 获取我方飞机在allGameObjList中的引索
    public static int myPlaneIndex = -1;

    // 创建存放敌方小boss的对象
    public static LittleBossObj littleBossObj = null;

    // 表示敌方小boss是否生成过
    public static boolean littleBossFlag = false;

    // 表示大boss是否生成过
    public static boolean bigBossFlag = false;

    // 创建敌方大boss的静态对象
    public static BigBossObj bigBossObj = null;


    // ======================================== 代码块/工具方法 ====================================================

    // 静态代码块，用于为各个初始化遍历赋值
    static {
        // 为bgImageMap获取背景
        bgImageMap = new HashMap<>();
        bgImageMap.put("1", GameUtils.backgroundImg1);
        bgImageMap.put("2", GameUtils.backgroundImg2);
        bgImageMap.put("3", GameUtils.backgroundImg3);
        bgImageMap.put("4", GameUtils.backgroundImg4);
    }


    // 方法：获取随机背景图片（每局游戏随机1次）
    public static Image getRandomBgImage() {
        if (randomBgImageIndex == null) {
            randomBgImageIndex = random.nextInt(bgImageMap.size());
        }
        // 用随机数获取Map的键
        String randBgImgKey = randomBgImageIndex + 1 + "";
        return bgImageMap.get(randBgImgKey);
    }


    public static Color getBabackgroundColor() {
        if (getRandomBgImage().equals(GameUtils.backgroundImg1)) {
            return new Color(77, 228, 125, 232);
        } else if (getRandomBgImage().equals(GameUtils.backgroundImg2)) {
            return new Color(66, 181, 225, 232);
        } else if (getRandomBgImage().equals(GameUtils.backgroundImg3)) {
            return new Color(232, 87, 105, 232);
        } else if (getRandomBgImage().equals(GameUtils.backgroundImg4)) {
            return new Color(221, 220, 88, 232);
        }
        return new Color(255, 255, 255, 0);
    }

    // 该方法用于向屏幕绘制文字
    public static void drawWord(Graphics g, String word, Color color, int size, int x, int y) {
        g.setColor(color);
        g.setFont(new Font("楷书", Font.BOLD, size));
        g.drawString(word, x, y);
    }


    // 该方法用于向屏幕绘制飞机的血条
    public static void drawLifeBar(Graphics g, Color bloodCcolor, int x, int y, int width, int height, int HP, int initHP) {
        // 先画黑条（背景）
        g.setColor(Color.black);
        g.fillRect(x, y, width + 6, height);
        // 再画白条（渐变）
        // 渐变参数为1.2，表示白色的长度是血条的1.2倍
        double gradientParameter = 1.2;
        g.setColor(Color.white);
        g.fillRect(x + 3, y + 3, (int) ((width * HP / initHP) * gradientParameter) >= width ?
                width : (int) ((width * HP / initHP) * gradientParameter), height - 6);
        // 后画真实血条
        g.setColor(bloodCcolor);
        g.fillRect(x + 3, y + 3, width * HP / initHP > width ? width : width * HP / initHP, height - 6);
    }


    // 该方法用于向屏幕绘制飞机的能量条
    public static void drawEnergyBar(Graphics g, Color energyCcolor, Color overflowEnergyCcolor,
                                     int x, int y, int width, int height, int energy, int overflowEnergy) {
        int blockWidth = 30;
        // 先画黑条（背景）
        g.setColor(Color.black);
        g.fillRect(x, y, width + 6, height);
        // 再画普通能量条
        int energyWidth = energy * blockWidth;
        g.setColor(energyCcolor);
        g.fillRect(x + 3, y + 3, energyWidth, height - 6);
        // 最后绘制溢出能量条
        int overflowEnergyWidth = overflowEnergy * blockWidth;
        g.setColor(overflowEnergyCcolor);
        g.fillRect(x + 3 + energyWidth, y + 3, 6 + energyWidth + overflowEnergyWidth >= width
                ? width - energyWidth : overflowEnergyWidth, height - 6);
    }

}
