package com.experiment04.test01.product;

import com.experiment04.test01.api.MediaPlayerApi;
import com.experiment04.test01.api.PlayerApi;

public class MediaPlayerList implements PlayerList {
    public static String info = new MediaPlayerList().getClass().toString();
    public PlayerApi playerApi = new MediaPlayerApi();

    @Override
    public void display() {
        System.out.println("显示MediaPlayerList");
    }

    @Override
    public void getMainWindowInfo() {
        System.out.println(playerApi.getMainWindowInfo());
    }
}
