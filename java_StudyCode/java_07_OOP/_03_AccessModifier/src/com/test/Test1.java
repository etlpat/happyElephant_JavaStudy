package com.test;

import com.accessModifier.AccessModifier;
//import com.accessModifier.Cat;// 报错(Cat类是不同包中的默认类)

public class Test1 {
    public static void main(String[] args) {
        AccessModifier am = new AccessModifier();

        // 只有public权限可在不同包中访问
        System.out.println(am.n1);
        //System.out.println(am.n2);// 报错
        //System.out.println(am.n3);// 报错
        //System.out.println(am.n4);// 报错


        // 不同包中只能调用public权限的类
        //Cat cat = new Cat();// 报错
    }
}
