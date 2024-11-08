package com._03_decoratorPattern.test01.decorator;

import com._03_decoratorPattern.test01.component.FastFood;

// 具体修饰者：添加鸡蛋

public class DecoratorAddEgg extends AbstractDecorator {
    public DecoratorAddEgg(FastFood fastFood) {
        super(fastFood);
    }


    @Override
    public void cook() {
        super.cook();
        addEgg();
    }


    public void addEgg() {
        System.out.println("加鸡蛋(*^_^*)");
    }
}
