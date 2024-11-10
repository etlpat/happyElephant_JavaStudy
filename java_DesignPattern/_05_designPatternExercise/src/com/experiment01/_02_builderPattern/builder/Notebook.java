package com.experiment01._02_builderPattern.builder;

// 具体建造者 -- 笔记本电脑

public class Notebook extends ComputerBuilder {
    @Override
    public void createCPU() {
        getComputer().setCPU("笔记本CPU");
    }

    @Override
    public void createRAM() {
        getComputer().setRAM("笔记本RAM");
    }

    @Override
    public void createHardDisk() {
        getComputer().setHardDisk("笔记本HardDisk");
    }

    @Override
    public void createHostMachine() {
        getComputer().setHostMachine("笔记本HostMachine");
    }

    @Override
    public void createDisplayer() {
        getComputer().setDisplayer("笔记本Displayer");
    }
}
