package com.experiment04.test01.factory;

import com.experiment04.test01.product.MainWindow;
import com.experiment04.test01.product.PlayerList;
import com.experiment04.test01.product.RealMainWindow;
import com.experiment04.test01.product.RealPlayerList;

public class RealPlayerFactory implements PlayerFactory {
    @Override
    public MainWindow createMainWindow() {
        return new RealMainWindow();
    }

    @Override
    public PlayerList createPlayerList() {
        return new RealPlayerList();
    }
}
