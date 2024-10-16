package com._01_collection._07_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


// Set
//
// 1.Set特点
//  ①Set是无序的(元素添加和取出的顺序不一致)，没有索引。
//  ②Set中不允许包含重复元素，最多包含一个null。
//      （若向Set中多次添加同一个元素，实际内存中只会保留一个）
//
//
// 2.Set接口的常用方法
//  Set是Collection的子接口，因此常用方法和Collection一样。
//  Set的遍历：iterator迭代器/for-each循环。
//
//
//


public class Set_ {
    public static void main(String[] args) {
        // 创建Set集合
        Set set = new HashSet();
        set.add(1);
        set.add("张三");
        set.add('A');
        set.add(true);
        set.add(null);
        System.out.println(set);


        // 测试为set添加重复元素
        set.add("张三");
        set.add(null);
        System.out.println(set);
        // 我们发现，重复的元素只会添加一次，即set不包含重复元素。
        // 即使是null，set中也最多存在1个


        // 迭代器遍历Set
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
        System.out.println();


        // for-each遍历Set
        for (Object obj : set) {
            System.out.print(obj + "  ");
        }
        System.out.println();
    }
}
