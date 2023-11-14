package com._04_memberInnerClass;

// 非静态成员内部类

public class Outer {
    private String name;
    private int count;


    // 定义成员内部类
    public class Inner {
        private String name;
        private int num = 1145;

        public Inner(String name) {
            this.name = name;
        }

        public void innerFunc() {
            System.out.println("内部类name：" + name + "，innerFunc方法被调用");
        }

        public void testMemberInnerClass01() {
            // (1)成员内部类可以直接访问所有外部类成员
            System.out.println(count);
            outerFunc();

            // (2)内部类和外部类成员重名，访问遵循就近原则
            System.out.println(name);
            System.out.println(Outer.this.name);
        }
    }


    public void testMemberInnerClass02(String innerName) {
        Inner inner = new Inner(innerName);
        // (3)外部类中可以通过对象直接访问内部类的私有属性
        System.out.println(inner.name);
        System.out.println(inner.num);

        // (4)外部类中想要访问内部类的成员，必要通过对象
        inner.innerFunc();
        inner.testMemberInnerClass01();
    }


    public void outerFunc() {
        System.out.println("外部类name：" + name + "，outerFunc方法被调用");
    }

    // 新建并返回内部类对象的方法
    public Inner getInnerInstance(String name) {
        return new Inner(name);
    }


    // 构造器
    public Outer(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public Outer() {
    }

    // get、set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
