package com.experiment01._02_builderPattern.director;

// 指挥者类

import com.experiment01._02_builderPattern.builder.ComputerBuilder;
import com.experiment01._02_builderPattern.product.Computer;

public class ComputerAssembleDirector {
    // 要组装的建造者对象
    ComputerBuilder computerBuilder;

    public ComputerAssembleDirector() {
    }

    public ComputerAssembleDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }


    // 组装并返回产品对象
    public Computer assemble() {
        // 按照顺序对产品组装
        computerBuilder.createCPU();
        computerBuilder.createRAM();
        computerBuilder.createHardDisk();
        computerBuilder.createHostMachine();
        computerBuilder.createDisplayer();

        // 返回组装好的产品
        return computerBuilder.getComputer();
    }


    public ComputerBuilder getComputerBuilder() {
        return computerBuilder;
    }

    public void setComputerBuilder(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }
}
