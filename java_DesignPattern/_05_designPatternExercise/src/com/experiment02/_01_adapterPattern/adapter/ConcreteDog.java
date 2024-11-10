package com.experiment02._01_adapterPattern.adapter;

// 适配器类 -- 实现目标接口，聚合适配者对象

public class ConcreteDog implements Dog {
    // cat为适配者
    Cat cat;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }


    @Override
    public void wang() {
        System.out.println("汪汪汪~~");
    }

    @Override
    public void action() {
        System.out.print("狗学猫行动：");
        cat.catchMouse();
    }
}
