package com.test03;

/**
 * 案例3
 * 题目：问下列代码输出什么？
 * 注意：
 * 1.构造子类前，必定先构造父类。super(xxx)必须放在子类构造器第一行
 * 2.成员的访问遵循查找关系
 * 3.属性不会动态绑定，按作用域访问
 */

public class Test {
    public static void main(String[] args) {
        new Sub().func();
//        Base无参构造器
//        Sub无参构造器
//        Rose
//        Jack

        new Sub("John").func();
//        John
//        Jack
    }
}
