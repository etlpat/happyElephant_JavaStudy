package com.experiment04.test01.product;

import com.experiment04.test01.api.PlayerApi;
import com.experiment04.test01.api.RealPlayerApi;

public class RealPlayerList implements PlayerList {
    public static String info = new RealPlayerList().getClass().toString();
    PlayerApi playerApi = new RealPlayerApi();

    @Override
    public void display() {
        System.out.println("显示RealPlayerList");
    }

    @Override
    public void getMainWindowInfo() {
        System.out.println(playerApi.getMainWindowInfo());
    }
}
