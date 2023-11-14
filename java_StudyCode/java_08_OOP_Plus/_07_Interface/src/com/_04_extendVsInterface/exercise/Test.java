package com._04_extendVsInterface.exercise;

// 若Test继承的B类和实现A接口中存在同名变量x，两个x的优先级相同。
// Test不能直接调用x，否则无法区分是哪个x，会报错

public class Test extends B implements A {
    public void pX() {
        //System.out.println(x);// 报错，B和A中都有x变量，编译器不能分辨调用哪一个x
        System.out.println(A.x);
        System.out.println(super.x);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.pX();
//        0
//        1

        //System.out.println(test.x);// 报错
    }
}
