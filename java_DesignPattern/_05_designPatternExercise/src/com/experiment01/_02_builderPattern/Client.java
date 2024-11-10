package com.experiment01._02_builderPattern;

import com.experiment01._02_builderPattern.builder.ComputerBuilder;
import com.experiment01._02_builderPattern.builder.Desktop;
import com.experiment01._02_builderPattern.builder.Notebook;
import com.experiment01._02_builderPattern.builder.Server;
import com.experiment01._02_builderPattern.director.ComputerAssembleDirector;
import com.experiment01._02_builderPattern.product.Computer;

public class Client {
    public static void main(String[] args) {
        // (1)创建指挥者对象
        ComputerAssembleDirector computerAssembleDirector = new ComputerAssembleDirector();


        // (2)指挥创建台式机
        computerAssembleDirector.setComputerBuilder(new Desktop());
        Computer computer1 = computerAssembleDirector.assemble();
        System.out.println(computer1);
        System.out.println("======================");


        // (3)指挥创建笔记本
        computerAssembleDirector.setComputerBuilder(new Notebook());
        Computer computer2 = computerAssembleDirector.assemble();
        System.out.println(computer2);
        System.out.println("======================");


        // (3)指挥创建服务器
        computerAssembleDirector.setComputerBuilder(new Server());
        Computer computer3 = computerAssembleDirector.assemble();
        System.out.println(computer3);
    }
}
