package com._01_designPatternBasic.test03_dependencyInversion;

public class CPU_AMD implements CPU {
    @Override
    public void run() {
        System.out.println("AMD型号CPU正在运行");
    }
}
