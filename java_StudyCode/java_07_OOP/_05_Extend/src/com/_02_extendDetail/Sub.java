package com._02_extendDetail;

/**
 * Sub:表示子类
 */

public class Sub extends Base {
    public Sub() {
        //super();// 子类构造器会默认调用父类的无参构造器
        System.out.println("Sub无参构造器调用...");
    }

    public Sub(int n1, int n2, int n3, int n4) {
        super(n1, n2, n3, n4);
        System.out.println("Sub有参构造器调用...");
    }

    // 同包的子类中可以直接访问父类public、protected、默认权限的成员
    // 若想访问父类private成员，只能通过方法间接访问

    public void f1() {
        n1 = 1;
        n2 = 2;
        n3 = 3;
        //n4 = 4;// 报错
        setN4(4);// 通过公共方法间接调用私有属性
    }

    public void f2() {
        func1();
        func2();
        func3();
        //func4();// 报错
        callFunc4();// 通过公共方法间接调用私有方法
    }
}
