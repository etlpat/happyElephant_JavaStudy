package com._03_decoratorPattern.test01.decorator;

import com._03_decoratorPattern.test01.component.FastFood;

// 具体修饰者：添加火腿

public class DecoratorAddHamSausage extends AbstractDecorator {
    public DecoratorAddHamSausage(FastFood fastFood) {
        super(fastFood);
    }


    @Override
    public void cook() {
        super.cook();
        addHamSausage();
    }


    public void addHamSausage() {
        System.out.println("加火腿(*^_^*)");
    }
}
