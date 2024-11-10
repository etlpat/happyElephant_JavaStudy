package com.experiment04.test01.factory;

import com.experiment04.test01.product.MainWindow;
import com.experiment04.test01.product.PlayerList;

public interface PlayerFactory {
    public MainWindow createMainWindow();

    public PlayerList createPlayerList();
}
