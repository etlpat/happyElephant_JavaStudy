package com._05_staticMemberInnerClass;

public class Outer {
    private static String name = "张三";
    private int id;
    private static int count = 250;

    public Outer(int id) {
        this.id = id;
    }


    // 静态成员内部类
    public static class Inner {
        public String name;
        public int num;
        public static int staticId = 114514;

        public Inner(String name, int num) {
            this.name = name;
            this.num = num;
        }

        public void innerFunc1() {
            System.out.println("静态成员内部类name：" + name + " 的innerFunc1方法被调用");
        }

        public void innerFunc2() {
            System.out.println("静态成员内部类的innerFunc2方法被调用");

            // (1)静态成员内部类，只能调用外部类的静态成员
            // （可以调用外部类的全部静态成员，包括private）
            System.out.println(count);
            func2();

            // (2)静态成员内部类，无法调用外部类的非静态成员
            //System.out.println(id);// 报错
            //func1();// 报错

            // (3)若内部类、外部类成员重名，访问遵循就近原则
            System.out.println(name);
            System.out.println(Outer.name);
        }

        public static void innerFunc3() {
            System.out.println("静态方法innerFunc3被调用");
        }
    }


    // 测试静态成员内部类的方法
    public void testStaticMemberInnerClass() {
        Inner inner = new Inner("李四", 1);

        // (4)可以通过创建对象来调用静态成员内部类的成员
        System.out.println(inner.name);
        inner.innerFunc1();

        inner.innerFunc2();
    }

    // 创建并返回静态成员内部类的方法（建议设为静态方法）
    public static Inner getInnerInstance(String name, int num) {
        return new Inner(name, num);
    }

    public void func1() {
        System.out.println("外部类普通方法func1被调用");
    }

    public static void func2() {
        System.out.println("外部类静态方法func2被调用");
    }
}
