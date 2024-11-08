package com._01_designPatternBasic.test03_dependencyInversion;

public class HardDisk_XiShu implements HardDisk {
    @Override
    public void run() {
        System.out.println("西数型号硬盘正在运行");
    }
}
