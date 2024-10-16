package com.test8;

public class Test {
    public static void main(String[] args) {
        A a = new A("张三");
        a.show();// 外部类A，name=张三

        A.B b = a.new B("李四");
        b.show();// 成员内部类B，name=李四

        a.showC("王五");// 局部内部类C，name=王五
    }
}
