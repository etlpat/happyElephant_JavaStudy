package com._01_designPatternBasic.test03_dependencyInversion;

public class CPU_Intel implements CPU {
    @Override
    public void run() {
        System.out.println("英特尔型号CPU正在运行");
    }
}
