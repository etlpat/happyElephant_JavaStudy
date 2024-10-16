package com._01_collection._10_treeSet.test01;

// 问：下面代码是否有异常？为什么？

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {

        new TreeSet().add(new Person());

        // 爆出异常：Person cannot be cast to class java.lang.Comparable
        // 原因：没有为TreeSet传参Comparator，且Person也没有实现Comparator，
        //      因此元素间无法进行比较，没法排序（没法构建树），报错。
    }
}
