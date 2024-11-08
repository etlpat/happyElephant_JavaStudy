package com._01_designPatternBasic.test03_dependencyInversion;

public class Computer {
    private CPU cpu;
    private Memory memory;
    private HardDisk hardDisk;

    public Computer(CPU cpu, Memory memory, HardDisk hardDisk) {
        this.cpu = cpu;
        this.memory = memory;
        this.hardDisk = hardDisk;
    }

    public Computer() {
    }

    public void display() {
        cpu.run();
        memory.run();
        hardDisk.run();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu +
                ", memory=" + memory +
                ", hardDisk=" + hardDisk +
                '}';
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }
}
