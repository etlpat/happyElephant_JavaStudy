package com._03_decoratorPattern.test01.decorator;

// 抽象修饰者：没有任何修饰的具体构件

import com._03_decoratorPattern.test01.component.FastFood;

public class AbstractDecorator implements FastFood {
    // 抽象修饰者中，聚合具体构件
    private FastFood fastFood;

    public AbstractDecorator(FastFood fastFood) {
        this.fastFood = fastFood;
    }


    // cook()中直接调用具体构件的cook()方法
    @Override
    public void cook() {
        fastFood.cook();
    }


    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
