package com.test1;

// 案例：
//  在Frock类中声明私有静态属性currentNum，初始值为1000，作为衣服出场序列号的起始值
//  声明静态方法getNextNum，每调用一次，使currentNum自增1并返回
//  Frock中，添加非静态属性serialNumber，作为每个衣服对象的序列号，序列号的值为getNextNum的返回值
//  创建一些衣服对象，检验上述方法


public class Test1 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());

        Frock tmp;
        for (int i = 0; i < 3; i++) {
            tmp = new Frock();
            System.out.println((i + 1) + "号:" + tmp);
        }
    }
}
