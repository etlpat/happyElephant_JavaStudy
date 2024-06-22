package com.airplaneWar.game.obj;

import com.airplaneWar.game.gameMian.GameUtils;

import java.awt.*;

public class ExplodeObj extends GameObj {
    public static Image[] smallPlaneExplode = new Image[4];
    public static Image[] bigPlaneExplode = new Image[6];
    public static Image[] bigBossExplode = new Image[6];
    public Image[] myExplode = null;

    // 在类加载到方法区时创建爆炸图片数组
    static {
        // 小飞机爆炸图片数组
        smallPlaneExplode[0] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/enemy_down1.png");
        smallPlaneExplode[1] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/enemy_down2.png");
        smallPlaneExplode[2] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/enemy_down3.png");
        smallPlaneExplode[3] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/enemy_down4.png");

        // 大飞机爆炸图片数组
        bigPlaneExplode[0] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/boom01.png");
        bigPlaneExplode[1] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/boom02.png");
        bigPlaneExplode[2] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/boom03.png");
        bigPlaneExplode[3] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/boom04.png");
        bigPlaneExplode[4] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/boom05.png");
        bigPlaneExplode[5] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/boom06.png");

        // boss爆炸图片数组
        bigBossExplode[0] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/super_boss_down1.png");
        bigBossExplode[1] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/super_boss_down2.png");
        bigBossExplode[2] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/super_boss_down3.png");
        bigBossExplode[3] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/super_boss_down4.png");
        bigBossExplode[4] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/super_boss_down5.png");
        bigBossExplode[5] = Toolkit.getDefaultToolkit().getImage(GameUtils.absolutePathPrefix + "images/boom/super_boss_down6.png");
    }


    public ExplodeObj(int x, int y, String s) {
        super(x, y);

        // 获取指定的爆炸数组
        if (s == "smallPlaneExplode") {
            myExplode = smallPlaneExplode;
        } else if (s == "bigPlaneExplode") {
            myExplode = bigPlaneExplode;
        } else if (s == "bigBossExplode") {
            myExplode = bigBossExplode;
        }

        // 将图片设为首张图片
        if (myExplode != null) {
            image = myExplode[0];
        }
    }

    // index用于记录该类对象的爆炸波播放到的下标位置
    // 由于构造器中已经获取index=0的图片，因此这里从1开始
    int index = 1;
    int waitTime = 3;
    int thisWaitTime = 0;


    @Override
    public void paintSelf(Graphics g) {
        // 若myExplode为空，直接返回
        if (myExplode == null) {
            return;
        }

        if (x < -250 || y > 900 || y < -200 || x > 750) {
            speed = 0;
            GameUtils.removeList.add(this);
            return;
        }


        // 当爆炸数组播放完毕，删除该爆炸对象
        if (index >= myExplode.length) {
            setX(-300);
            setY(1000);
            GameUtils.removeList.add(this);
        } else {
            // 若未到达等待时间，仍播放该图片，等待时间自增
            if (thisWaitTime < waitTime) {
                thisWaitTime++;
            } else {
                // 若到达等待时间，清空等待时间，并播放下一张图片
                thisWaitTime = 0;
                image = myExplode[index];// 将爆炸图片设为下一张
                index++;
            }
        }

        super.paintSelf(g);
    }
}
