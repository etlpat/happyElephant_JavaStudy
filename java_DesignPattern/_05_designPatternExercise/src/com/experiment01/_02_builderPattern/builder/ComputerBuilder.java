package com.experiment01._02_builderPattern.builder;

import com.experiment01._02_builderPattern.product.Computer;

// 抽象建造者

public abstract class ComputerBuilder {
    // 要构建的产品
    private Computer computer = new Computer();

    // 创建CPU
    public abstract void createCPU();

    // 创建内存条
    public abstract void createRAM();

    // 创建硬盘
    public abstract void createHardDisk();

    // 创建主机
    public abstract void createHostMachine();

    // 创建显示器
    public abstract void createDisplayer();


    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
