package com.experiment02._03_facadePattern.facade;

import com.experiment02._03_facadePattern.subSystem.CPU;
import com.experiment02._03_facadePattern.subSystem.HardDisk;
import com.experiment02._03_facadePattern.subSystem.Memory;
import com.experiment02._03_facadePattern.subSystem.OS;

public class Mainframe {
    private Memory memory = new Memory();
    private CPU cpu = new CPU();
    private HardDisk hardDisk = new HardDisk();
    private OS os = new OS();


    // 调用全部组件运行
    public boolean on() {
        try {
            memory.check();
            cpu.run();
            hardDisk.read();
            os.load();

        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("硬件运行出错，强制停止开机");
            return false;
        }
        return true;
    }


    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }
}
