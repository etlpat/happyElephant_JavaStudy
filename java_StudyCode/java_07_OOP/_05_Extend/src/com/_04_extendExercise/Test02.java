package com._04_extendExercise;

// 例题2：
//  1.编写Computer类，包含CPU、内存条(memoryBank)、硬盘(hardDisk)属性，getDetail方法用于返回类信息
//  2.编写PC子类，继承Computer类，添加特有属性：品牌(brand)，重写getDetail方法
//  3.编写NotePad子类，继承Computer类，添加特有属性：颜色(color)，重写getDetail方法
//  4.在主类中测试两个子类


public class Test02 {
    public static void main(String[] args) {
        // 通过构造器传参
        PC pc = new PC("c1", "m1", "h1", "b1");
        System.out.println(pc.getDetail());// CPU:c1, 内存条:m1, 硬盘:h1, 品牌:b1

        // 通过set方法传参
        NotePad notePad = new NotePad();
        notePad.setCPU("c2");
        notePad.setMemoryBank("m2");
        notePad.setHardDisk("h2");
        notePad.setColor("red");
        System.out.println(notePad.getDetail());// CPU:c2, 内存条:m2, 硬盘:h2, 颜色:red
    }
}


class Computer {
    private String CPU;
    private String memoryBank;// 内存条
    private String hardDisk;// 硬盘

    // 构造器
    public Computer() {
    }
    public Computer(String CPU, String memoryBank, String hardDisk) {
        setCPU(CPU);
        setMemoryBank(memoryBank);
        setHardDisk(hardDisk);
    }

    // get、set方法
    public String getCPU() {
        return CPU;
    }
    public void setCPU(String CPU) {
        this.CPU = CPU;
    }
    public String getMemoryBank() {
        return memoryBank;
    }
    public void setMemoryBank(String memoryBank) {
        this.memoryBank = memoryBank;
    }
    public String getHardDisk() {
        return hardDisk;
    }
    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getDetail() {
        return "CPU:" + CPU + ", 内存条:" + memoryBank + ", 硬盘:" + hardDisk;
    }
}


class PC extends Computer {
    public String brand;

    public PC() {
    }

    public PC(String CPU, String memoryBank, String hardDisk, String brand) {
        super(CPU, memoryBank, hardDisk);
        setBrand(brand);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDetail() {
        return super.getDetail() + ", 品牌:" + brand;
    }
}


class NotePad extends Computer {
    public String color;

    public NotePad() {
    }

    public NotePad(String CPU, String memoryBank, String hardDisk, String color) {
        super(CPU, memoryBank, hardDisk);
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDetail() {
        return super.getDetail() + ", 颜色:" + color;
    }
}