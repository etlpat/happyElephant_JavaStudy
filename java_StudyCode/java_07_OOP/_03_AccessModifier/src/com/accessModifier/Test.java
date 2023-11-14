package com.accessModifier;

class Test {
    public static void main(String[] args) {
        AccessModifier am = new AccessModifier();

        // public、protected、默认权限都可在同包中的其他类中访问
        System.out.println(am.n1);
        System.out.println(am.n2);
        System.out.println(am.n3);
        //System.out.println(am.n4);// 报错，私有属性非本类不可使用


        // 同包可以调用public和默认权限的类
        Cat cat = new Cat();
    }
}