package com.airplaneWar.game.obj;

import com.airplaneWar.game.gameMian.GameStart;

import java.awt.*;

// 该类作为所所有其它Obj类的父类
public class GameObj {
    // 元素的图片
    Image image;

    // 元素的大小
    int width;
    int height;

    // 元素的位置
    int x;
    int y;

    // 元素的运动速度
    double speed;

    // 窗口类;
    GameStart frame;


    public GameObj() {
    }

    public GameObj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GameObj(int x, int y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObj(Image image, int x, int y, double speed) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObj(Image image, int width, int height, int x, int y, double speed) {
        this.image = image;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObj(Image image, int width, int height, int x, int y, double speed, GameStart frame) {
        this.image = image;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.frame = frame;
    }


    // 绘制元素自身
    public void paintSelf(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    // 绘制自身矩形方法，用于碰撞检测
    public Rectangle getGec() {
        return new Rectangle(x, y, width, height);
    }


    @Override
    public String toString() {
        return "GameObj{" +
                "image=" + image +
                ", width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                ", speed=" + speed +
                ", frame=" + frame +
                '}';
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GameStart getFrame() {
        return frame;
    }

    public void setFrame(GameStart frame) {
        this.frame = frame;
    }
}
