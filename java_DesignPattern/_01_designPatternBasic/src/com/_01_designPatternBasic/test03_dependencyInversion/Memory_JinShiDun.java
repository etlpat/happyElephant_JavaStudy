package com._01_designPatternBasic.test03_dependencyInversion;

public class Memory_JinShiDun implements Memory {
    @Override
    public void run() {
        System.out.println("金士顿型号内存条正在运行");
    }
}
