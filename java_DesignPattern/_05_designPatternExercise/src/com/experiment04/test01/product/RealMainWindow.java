package com.experiment04.test01.product;

import com.experiment04.test01.api.PlayerApi;
import com.experiment04.test01.api.RealPlayerApi;

public class RealMainWindow implements MainWindow {
    public static String info = new RealMainWindow().getClass().toString();
    PlayerApi playerApi = new RealPlayerApi();

    @Override
    public void display() {
        System.out.println("显示RealMainWindow");
    }

    @Override
    public void getPlayerListInfo() {
        System.out.println(playerApi.getPlayerListInfo());
    }
}
