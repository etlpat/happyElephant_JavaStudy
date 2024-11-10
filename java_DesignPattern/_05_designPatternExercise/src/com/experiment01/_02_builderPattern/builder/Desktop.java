package com.experiment01._02_builderPattern.builder;

// 具体建造者 -- 台式机

public class Desktop extends ComputerBuilder {
    @Override
    public void createCPU() {
        getComputer().setCPU("台式机/服务器CPU");
    }

    @Override
    public void createRAM() {
        getComputer().setRAM("台式机/服务器RAM");
    }

    @Override
    public void createHardDisk() {
        getComputer().setHardDisk("台式机/服务器HardDisk");
    }

    @Override
    public void createHostMachine() {
        getComputer().setHostMachine("台式机/服务器HostMachine");
    }

    @Override
    public void createDisplayer() {
        getComputer().setDisplayer("台式机Displayer");
    }
}
