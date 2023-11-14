package com._05_super.superDetail;

public class C extends B {
    public int num = 3;

    public void func1() {
        System.out.println("C类的func1()...");
    }

    public void test1() {
        // 查找规则：就近原则
        func1();// C类的func1()...
        this.func1();// C类的func1()...
        super.func1();// B类的func1()...
    }

    public void test2() {
        func2();// B类的func2()...
        this.func2();// B类的func2()...
        super.func2();// B类的func2()...
    }

    public void test3() {
        func3();// A类的func3()...
        this.func3();// A类的func3()...
        super.func3();// A类的func3()...
    }

    public void test4() {
        // 报错，父类的私有权限子类无法访问
        // func4();
        // this.func4();
        // super.func4();
    }

    public void test5() {
        System.out.println(num);// 3
        System.out.println(this.num);// 3
        System.out.println(super.num);// 2

        System.out.println(a);// 11
        System.out.println(this.a);// 11
        System.out.println(super.a);// 11
    }

    public static void main(String[] args) {
        C c = new C();
        c.test1();
        c.test2();
        c.test3();
        c.test5();
    }
}
