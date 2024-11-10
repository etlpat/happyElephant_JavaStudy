package com.experiment02._01_adapterPattern.adapter;

// 适配器类 -- 实现目标接口，聚合适配者对象

public class ConcreteCat implements Cat {
    // dog为适配者
    Dog dog;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }


    @Override
    public void cry() {
        System.out.print("猫学狗叫：");
        dog.wang();
    }

    @Override
    public void catchMouse() {
        System.out.println("抓老鼠~~");
    }
}
