package com.experiment02._01_adapterPattern;

import com.experiment02._01_adapterPattern.adapter.ConcreteCat;
import com.experiment02._01_adapterPattern.adapter.ConcreteDog;

public class Client {
    public static void main(String[] args) {
        ConcreteCat cat = new ConcreteCat();
        ConcreteDog dog = new ConcreteDog();
        cat.setDog(dog);
        dog.setCat(cat);


        // 执行猫的方法
        cat.cry();
        cat.catchMouse();
        System.out.println("==============");


        // 执行狗的方法
        dog.wang();
        dog.action();
    }
}
