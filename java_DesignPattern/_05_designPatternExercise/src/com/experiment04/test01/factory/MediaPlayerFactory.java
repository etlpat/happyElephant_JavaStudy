package com.experiment04.test01.factory;

import com.experiment04.test01.product.MainWindow;
import com.experiment04.test01.product.MediaMainWindow;
import com.experiment04.test01.product.MediaPlayerList;
import com.experiment04.test01.product.PlayerList;

public class MediaPlayerFactory implements PlayerFactory {
    @Override
    public MainWindow createMainWindow() {
        return new MediaMainWindow();
    }

    @Override
    public PlayerList createPlayerList() {
        return new MediaPlayerList();
    }
}
