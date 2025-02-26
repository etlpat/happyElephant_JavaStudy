package com.chatRoom.Util;

import com.chatRoom.client.view.ClientChat;

// 抖动类，用于使窗体抖动
public class ShakeUtil extends Thread {
    ClientChat clientChat;

    public ShakeUtil(ClientChat clientChat) {
        this.clientChat = clientChat;
    }

    @Override
    public void run() {
        int SleepTime = 25;// 休眠时间
        int shakeLocation = 30;// 抖动距离
        int shakeTimes = 5;// 抖动循环次数
        try {
            // 如下循环，使得窗体做下右上左的抖动
            for (int i = 0; i < shakeTimes; i++) {
                clientChat.setLocation(clientChat.getX() + shakeLocation, clientChat.getY());
                Thread.sleep(SleepTime);
                clientChat.setLocation(clientChat.getX(), clientChat.getY() + shakeLocation);
                Thread.sleep(SleepTime);
                clientChat.setLocation(clientChat.getX() - shakeLocation, clientChat.getY());
                Thread.sleep(SleepTime);
                clientChat.setLocation(clientChat.getX(), clientChat.getY() - shakeLocation);
                Thread.sleep(SleepTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
