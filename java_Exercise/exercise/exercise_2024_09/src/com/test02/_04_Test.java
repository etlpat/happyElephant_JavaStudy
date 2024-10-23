package com.test02;

public class _04_Test {
    public static void main(String[] args) {

    }
}

class C1 {
    // 若类不显式的定义构造器，系统会默认提供无参构造器的空实现
}

class C2 {
    // 若类中定义了构造器，系统就不会提供默认无参构造器
    public C2(String name) {
    }
}
