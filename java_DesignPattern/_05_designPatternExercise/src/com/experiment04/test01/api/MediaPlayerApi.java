package com.experiment04.test01.api;

import com.experiment04.test01.product.MediaMainWindow;
import com.experiment04.test01.product.MediaPlayerList;

// 适配器类：实现PlayerApi，聚合MediaMainWindow、MediaPlayerList并调用其方法

public class MediaPlayerApi implements PlayerApi {

    @Override
    public String getMainWindowInfo() {
        return MediaMainWindow.info;
    }

    @Override
    public String getPlayerListInfo() {
        return MediaPlayerList.info;
    }
}
