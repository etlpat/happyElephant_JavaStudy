package com._04_abstractFactoryPattern.test01;

// 案例：
//  产品族有：Windows、Unix、Linux族
//  产品等级（种类）分为：Text、Button
//  使用抽象工厂生成以上产品...

import com._04_abstractFactoryPattern.test01.factory.AbstractFactory;
import com._04_abstractFactoryPattern.test01.factory.LinuxFactory;
import com._04_abstractFactoryPattern.test01.factory.UnixFactory;
import com._04_abstractFactoryPattern.test01.factory.WindowsFactory;
import com._04_abstractFactoryPattern.test01.product.AbstractButton;
import com._04_abstractFactoryPattern.test01.product.AbstractText;


public class Test {
    public static void main(String[] args) {
        // 创建每个产品族的工厂
        AbstractFactory windowsFactory = new WindowsFactory();
        AbstractFactory linuxFactory = new LinuxFactory();
        AbstractFactory unixFactory = new UnixFactory();


        // 创建每个产品族中不同种类的对象
        // Windows工厂
        AbstractText windowsText = windowsFactory.createText();
        AbstractButton windowsButton = windowsFactory.createButton();

        System.out.println(windowsText.getClass().getSimpleName());
        System.out.println(windowsButton.getClass().getSimpleName());
        System.out.println("================");

        // Linux工厂
        AbstractText linuxText = linuxFactory.createText();
        AbstractButton linuxButton = linuxFactory.createButton();

        System.out.println(linuxText.getClass().getSimpleName());
        System.out.println(linuxButton.getClass().getSimpleName());
        System.out.println("================");

        // Unix工厂
        AbstractText unixText = unixFactory.createText();
        AbstractButton unixButton = unixFactory.createButton();

        System.out.println(unixText.getClass().getSimpleName());
        System.out.println(unixButton.getClass().getSimpleName());
    }
}
