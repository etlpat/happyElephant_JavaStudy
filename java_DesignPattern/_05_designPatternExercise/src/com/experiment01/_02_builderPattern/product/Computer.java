package com.experiment01._02_builderPattern.product;

public class Computer {
    private String CPU;
    private String RAM;// 内存条
    private String hardDisk;// 硬盘
    private String hostMachine;// 主机
    private String displayer;// 显示器

    public Computer() {
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", hostMachine='" + hostMachine + '\'' +
                ", displayer='" + displayer + '\'' +
                '}';
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getHostMachine() {
        return hostMachine;
    }

    public void setHostMachine(String hostMachine) {
        this.hostMachine = hostMachine;
    }

    public String getDisplayer() {
        return displayer;
    }

    public void setDisplayer(String displayer) {
        this.displayer = displayer;
    }
}
