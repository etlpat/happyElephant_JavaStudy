package com.airplaneWar.game.obj;

import com.airplaneWar.game.mian.CreateGameObjs;
import com.airplaneWar.game.mian.GameStart;
import com.airplaneWar.game.mian.GameUtils;

import java.awt.*;

public class MySuperBulletObj extends GameObj {
    // 超级子弹设有血量，用来实现穿透效果
    int HP = 25;

    // 创建超级子弹的图片数组
    public static Image[] mySuperBullet = new Image[5];

    static {
        mySuperBullet[0] = Toolkit.getDefaultToolkit().getImage("images/bullet/ttt04.png");
        mySuperBullet[1] = Toolkit.getDefaultToolkit().getImage("images/bullet/ttt05.png");
        mySuperBullet[2] = Toolkit.getDefaultToolkit().getImage("images/bullet/ttt06.png");
        mySuperBullet[3] = Toolkit.getDefaultToolkit().getImage("images/bullet/ttt07.png");
        mySuperBullet[4] = Toolkit.getDefaultToolkit().getImage("images/bullet/ttt08.png");
    }

    {
        // image初始设为第0张图片
        image = mySuperBullet[0];
        width = 273;
        height = 202;
    }


    public MySuperBulletObj(int x, int y, double speed) {
        super(x, y, speed);
    }


    // 当前播放图片的下标
    int index = 1;// 由于初始图片为0，这里下标从1开始
    int direction = 1;
    int waitTime = 2;// 播放等待时间
    int thisWaitTime = 0;// 当前等待时间


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);

        // 若越界，将其删除
        if (x < -250 || y > 900 || y < -200 || x > 750) {
            speed = 0;
            GameUtils.removeList.add(this);
            return;
        }


        if (HP <= 0) {
            // 若血量小于0，子弹消失
            setX(-300);
            setY(1000);
            GameUtils.removeList.add(this);

        } else {
            y -= speed;

            // 若未到达等待时间，仍播放该图片，等待时间自增
            if (thisWaitTime < waitTime) {
                thisWaitTime++;
            } else {
                // 若到达等待时间，清空当前等待时间，并播放下一张图片
                thisWaitTime = 0;
                image = mySuperBullet[index];

                // 图片下标变化
                // ①调整下标的自增/自减方向
                if (direction == 1) {// direction==1，代表下标自增
                    if (index + direction >= mySuperBullet.length) {
                        direction = -1;
                    }
                } else if (direction == -1) {// direction==-1，代表下标自增
                    if (index + direction < 0) {
                        direction = 1;
                    }
                }
                // 图片变为下一张
                index += direction;
            }
        }
    }


    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public static Image[] getMySuperBullet() {
        return mySuperBullet;
    }

    public static void setMySuperBullet(Image[] mySuperBullet) {
        MySuperBulletObj.mySuperBullet = mySuperBullet;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getThisWaitTime() {
        return thisWaitTime;
    }

    public void setThisWaitTime(int thisWaitTime) {
        this.thisWaitTime = thisWaitTime;
    }
}
