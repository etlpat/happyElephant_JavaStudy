package com._01_designPatternBasic.test03_dependencyInversion;

public class HardDisk_XiJie implements HardDisk {
    @Override
    public void run() {
        System.out.println("希捷型号硬盘正在运行");
    }
}
