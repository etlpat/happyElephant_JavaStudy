package com._03_anonymousInnerClass;

// 例2：基于类的匿名内部类
// 本质：匿名内部类Outer02$1继承Base类


public class Outer02 {

    public void method01() {
        // (1)创建并实例化匿名内部类
        //  b1编译类型为Base，运行类型为匿名内部类Outer02$1
        Base b1 = new Base("张三") {
        };

        b1.work();// work方法被调用
        System.out.println(b1.getClass());// class com._03_anonymousInnerClass.Outer02$1
        System.out.println("================");


        // (2)创建并实例化匿名内部类
        //  匿名内部类Outer02$2继承Base类，并重写其方法
        Base b2 = new Base("李四") {
            @Override
            public void work() {
                System.out.println(getName() + " 在上班");
            }
        };

        b2.work();// 李四 在上班
        System.out.println(b2.getClass());// class com._03_anonymousInnerClass.Outer02$2
    }


    public void method02() {
        // (3)创建并实例化匿名内部类
        //  匿名内部类Outer02$3继承抽象类AbstractBase，必须重写全部抽象方法才能实例化
        AbstractBase ab = new AbstractBase("王五") {
            @Override
            public void work() {
                System.out.println(getName() + " 在工作");
            }
        };

        ab.work();// 王五 在工作
        System.out.println(ab.getClass());// class com._03_anonymousInnerClass.Outer02$3
    }
}


// 父类
class Base {
    private String name;

    public Base() {
    }

    public Base(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void work() {
        System.out.println("work方法被调用");
    }
}


// 抽象父类
abstract class AbstractBase {
    private String name;

    public AbstractBase() {
    }

    public AbstractBase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void work();
}