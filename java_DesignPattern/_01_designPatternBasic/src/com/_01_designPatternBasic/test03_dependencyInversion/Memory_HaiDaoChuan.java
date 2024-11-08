package com._01_designPatternBasic.test03_dependencyInversion;

public class Memory_HaiDaoChuan implements Memory {
    @Override
    public void run() {
        System.out.println("海盗船型号内存条正在运行");
    }
}
