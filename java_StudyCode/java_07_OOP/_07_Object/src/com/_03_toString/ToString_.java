// toString方法（属于Object类）
//
// (1)功能
//  返回该对象的字符串表示
//  注意：【当我们直接输出一个对象时，toString方法会被默认调用】
//
//
// (2)Object类的toString()
//  默认返回：全类名(包名.类名) + @ + 对象哈希码的16进制
//  源码：
//  public String toString() {
//      return getClass().getName() + "@" + Integer.toHexString(hashCode());
//  }
//
//  注意：子类对象一般会重写toString方法
//       重写为返回对象的属性信息




package com._03_toString;

public class ToString_ {
    public static void main(String[] args) {
        // (1)Object类的toString方法返回：全类名 + @ + 对象哈希码的16进制
        A a = new A();
        Object o = new Object();
        System.out.println(a.toString());// com._03_toString.A@1b6d3586
        System.out.println(o.toString());// java.lang.Object@4554617c


        // (2)Student类，重写toString为返回对象属性
        Student s = new Student("Van", 26, "男");
        System.out.println(s.toString());// Student{name='Van', age=26, sex='男'}

        // (3)当直接输出对象时，默认调用toString方法
        System.out.println(s);// Student{name='Van', age=26, sex='男'}
    }
}
