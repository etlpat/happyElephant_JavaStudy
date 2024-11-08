package com._03_decoratorPattern.test01;

// 案例：
//  快餐店有炒面、炒饭这些快餐,
//  可以额外附加鸡蛋、火腿、培根这些配菜
//  使用修饰者模式，实现快餐的制作，并为其修饰配菜


import com._03_decoratorPattern.test01.component.FriedNoodles;
import com._03_decoratorPattern.test01.component.ParchedRice;
import com._03_decoratorPattern.test01.decorator.AbstractDecorator;
import com._03_decoratorPattern.test01.decorator.DecoratorAddEgg;
import com._03_decoratorPattern.test01.decorator.DecoratorAddHamSausage;


public class Test {
    public static void main(String[] args) {
        // 抽象修饰者 == 没有任何修饰的具体构件
        AbstractDecorator abstractDecorator = new AbstractDecorator(new FriedNoodles());
        abstractDecorator.cook();
        System.out.println("====================");


        // 具体修饰者：修饰添加鸡蛋
        DecoratorAddEgg decoratorAddEgg = new DecoratorAddEgg(new ParchedRice());
        decoratorAddEgg.cook();
        System.out.println("====================");


        // 具体修饰者：修饰添加火腿
        DecoratorAddHamSausage decoratorAddHamSausage = new DecoratorAddHamSausage(new FriedNoodles());
        decoratorAddHamSausage.cook();
        System.out.println("====================");


        // 具体修饰者：即添加鸡蛋又添加火腿
        AbstractDecorator decorator = new DecoratorAddEgg(new DecoratorAddHamSausage(new ParchedRice()));
        decorator.cook();
    }
}
