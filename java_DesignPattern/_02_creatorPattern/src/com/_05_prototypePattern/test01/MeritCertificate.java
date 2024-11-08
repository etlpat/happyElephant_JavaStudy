package com._05_prototypePattern.test01;

// 三好学生奖状类（是原型模式）

// 原型模式
//  原型模式必须实现Cloneable接口，才能使用Object提供的clone()方法
public class MeritCertificate implements Cloneable {
    private String name = "defaultName";

    public MeritCertificate() {
    }


    // 原型模式，需要重写Object提供的clone方法
    // （Object的clone，默认为浅克隆）
    @Override
    protected MeritCertificate clone() throws CloneNotSupportedException {
        return (MeritCertificate) super.clone();
    }


    @Override
    public String toString() {
        return "MeritCertificate{" +
                "name='" + name + '\'' +
                '}';
    }

    public void show() {
        System.out.println("“三好学生”{" + name + "}获得该奖状~~");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
