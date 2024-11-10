package com.experiment04.test01.api;

import com.experiment04.test01.product.RealMainWindow;
import com.experiment04.test01.product.RealPlayerList;

// 适配器类：实现PlayerApi，聚合RealMainWindow、RealPlayerList并调用其方法

public class RealPlayerApi implements PlayerApi {
    @Override
    public String getMainWindowInfo() {
        return RealMainWindow.info;
    }

    @Override
    public String getPlayerListInfo() {
        return RealPlayerList.info;
    }
}
