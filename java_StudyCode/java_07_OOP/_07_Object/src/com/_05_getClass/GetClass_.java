// getClass方法（属于Object类）
//
// (1)功能
//  返回对象的【运行类型】

package com._05_getClass;

public class GetClass_ {
    public static void main(String[] args) {
        // getClass()返回对象的运行类型
        Object obj1 = new Object();
        System.out.println(obj1.getClass());// class java.lang.Object

        Object obj2 = new String("abc");
        System.out.println(obj2.getClass());// class java.lang.String

        A a1 = new A();
        System.out.println(a1.getClass());// class com._05_getClass.A

        A a2 = new B();
        System.out.println(a2.getClass());// class com._05_getClass.B
    }
}
