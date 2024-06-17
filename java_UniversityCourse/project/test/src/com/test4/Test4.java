package com.test4;

public class Test4 {
    public static void main(String[] args) {
        Base base = new Sub();

        System.out.println(base.name);
        base.say();
        base.hello();
    }
}


class Base {
    String name = "BBB";

    public void say() {
        System.out.println("Base Say");
    }

    public void hello() {
        System.out.println(name);
        say();
    }
}


class Sub extends Base {
    String name = "SSS";

    @Override
    public void say() {
        super.say();
        System.out.println("Sub Say");
    }
}
