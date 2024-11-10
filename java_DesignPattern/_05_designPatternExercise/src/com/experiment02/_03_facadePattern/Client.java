package com.experiment02._03_facadePattern;

import com.experiment02._03_facadePattern.facade.Mainframe;

// 注意：每个硬件有10%的概率出错
//      Mainframe有34.39%的概率启动失败

public class Client {
    public static void main(String[] args) {
        // 创建外观类
        Mainframe mainframe = new Mainframe();


        // 执行30次开机，看看有多少次失败
        int allCount = 30;
        int count = 0;
        for (int i = 1; i <= allCount; i++) {
            System.out.println("############ 第" + i + "次运行 ############");
            if (mainframe.on()) {
                count++;
            }
        }
        System.out.println("==================================");
        System.out.println(allCount + "次中，成功了" + count + "次！");
    }
}
