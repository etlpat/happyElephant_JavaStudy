package com._01_collection._08_hashSet.test01;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        // HashSet的add方法，返回添加是否成功
        System.out.println(hashSet.add(null));// true
        System.out.println(hashSet.add(null));// false（Set的元素不可重复）

        System.out.println(hashSet.add("abc"));// true
        System.out.println(hashSet.add("abc"));// false

        System.out.println(hashSet.add(new Dog("tom")));// true
        System.out.println(hashSet.add(new Dog("tom")));// true（虽然值相同，但是两个Dog是不同的对象）

        System.out.println(hashSet.add(new String("123")));// true
        System.out.println(hashSet.add(new String("123")));// false（? 对象不同，但是不可重复添加 -- 看源码解析）

        System.out.println(hashSet);
    }
}
