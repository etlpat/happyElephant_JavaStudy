package com.experiment01._01_abstractFactoryPattern;

import com.experiment01._01_abstractFactoryPattern.factory.AbstractFactory;
import com.experiment01._01_abstractFactoryPattern.factory.MacFactory;
import com.experiment01._01_abstractFactoryPattern.factory.PcFactory;
import com.experiment01._01_abstractFactoryPattern.product.AbstractCPU;
import com.experiment01._01_abstractFactoryPattern.product.AbstractRAM;

public class Client {
    public static void main(String[] args) {
        // (1)创建工厂类
        AbstractFactory macFactory = new MacFactory();
        AbstractFactory pcFactory = new PcFactory();


        // (2)测试mac工厂
        AbstractCPU macFactoryCPU = macFactory.createCPU();
        AbstractRAM macFactoryRAM = macFactory.createRAM();

        System.out.println(macFactoryCPU.getClass().getSimpleName());
        System.out.println(macFactoryRAM.getClass().getSimpleName());
        System.out.println("=================");


        // (3)测试pc工厂
        AbstractCPU pcFactoryCPU = pcFactory.createCPU();
        AbstractRAM pcFactoryRAM = pcFactory.createRAM();

        System.out.println(pcFactoryCPU.getClass().getSimpleName());
        System.out.println(pcFactoryRAM.getClass().getSimpleName());

    }
}
