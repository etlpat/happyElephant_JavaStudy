package com.experiment04.test01;

// 抽象工厂+适配器

import com.experiment04.test01.factory.MediaPlayerFactory;
import com.experiment04.test01.factory.PlayerFactory;
import com.experiment04.test01.factory.RealPlayerFactory;
import com.experiment04.test01.product.MainWindow;
import com.experiment04.test01.product.PlayerList;

public class Client {
    public static void main(String[] args) {
        // (1)创建产品工厂
        PlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
        PlayerFactory realPlayerFactory = new RealPlayerFactory();


        // (2)创建Media族的产品
        MainWindow mainWindow = mediaPlayerFactory.createMainWindow();
        mainWindow.display();// 展示自身
        mainWindow.getPlayerListInfo();// 获取关联的PlayerList的信息
        System.out.println("===============================");


        PlayerList playerList = mediaPlayerFactory.createPlayerList();
        playerList.display();// 展示自身
        playerList.getMainWindowInfo();// 获取关联的MainWindow的信息
        System.out.println("===============================");


        // (3)创建Real族的产品
        MainWindow mainWindow1 = realPlayerFactory.createMainWindow();
        mainWindow1.display();
        mainWindow1.getPlayerListInfo();
        System.out.println("===============================");


        PlayerList playerList1 = realPlayerFactory.createPlayerList();
        playerList1.display();
        playerList1.getMainWindowInfo();

    }
}
