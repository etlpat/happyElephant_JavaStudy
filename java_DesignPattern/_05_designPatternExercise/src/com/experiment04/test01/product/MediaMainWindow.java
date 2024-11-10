package com.experiment04.test01.product;

import com.experiment04.test01.api.MediaPlayerApi;
import com.experiment04.test01.api.PlayerApi;

public class MediaMainWindow implements MainWindow {
    public static String info = new MediaMainWindow().getClass().toString();
    public PlayerApi playerApi = new MediaPlayerApi();

    @Override
    public void display() {
        System.out.println("显示MediaMainWindow");
    }

    @Override
    public void getPlayerListInfo() {
        System.out.println(playerApi.getPlayerListInfo());
    }
}
