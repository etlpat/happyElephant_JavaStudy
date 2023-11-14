package com._02_localInnerClass.test01;

// Java允许外部类中创建的局部内部类对象，直接访问局部内部类的private成员
// 这可以理解为：内部类是外部类的成员，因此外部类中可以通过对象直接访问内部类的private属性
// 注意：这是一种特例，实际上该内部类对象在底层中是直接创建在内部类中的，因此可以直接访问其private属性
// 然而，这种做法并不推荐，因为它破坏了类的封装性，使得代码难以理解和维护


public class Outer {
    private String name;

    public Outer(String name) {
        this.name = name;
    }

    public void func() {

        class Inner {
            private String name;
            private int count = 100;

            public Inner(String name) {
                this.name = name;
            }
        }

        Inner inner = new Inner("内部inner");

        // 外部类中创建的内部类对象，允许直接访问内部类的私有属性
        System.out.println(inner.name);// 内部inner
        System.out.println(inner.count);// 100
    }
}
