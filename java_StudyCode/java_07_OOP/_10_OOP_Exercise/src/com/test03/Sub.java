package com.test03;

public class Sub extends Base {
    String name = "Jack";

    public Sub() {
        System.out.println("Sub无参构造器");
    }

    public Sub(String name) {
        super(name);
    }

    public void func(){
        System.out.println(super.name);
        System.out.println(this.name);
    }
}
