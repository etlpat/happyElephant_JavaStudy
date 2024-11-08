package com._01_designPatternBasic.test03_dependencyInversion;

// 案例:组装电脑
//      现要组装一台电脑,需要配件cpu,硬盘,内存条。只有这些配置都有了,计算机才能正常的运行。
//          选择cpu有很多选择,如Intel,AMD等,
//          硬盘可以选择希捷,西数等,
//          内存条可以选择金士顿,海盗船等。


public class Test {
    public static void main(String[] args) {
        Computer computer1 = new Computer(new CPU_AMD(), new Memory_HaiDaoChuan(), new HardDisk_XiShu());
        computer1.display();

        System.out.println("=======================");

        Computer computer2 = new Computer(new CPU_Intel(), new Memory_JinShiDun(), new HardDisk_XiJie());
        computer2.display();
    }
}
