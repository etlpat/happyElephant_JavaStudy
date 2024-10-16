package com._01_collection._01_collectionBasic;

import java.util.*;


// 集合基础
//
//
// 1.集合继承体系图
//  (1)Collection集合体系（单列集合）：
//                         Iterable(接口)
//                              ↑
//                |------→ Collection(接口) ←------|
//                |                               |
//      |-----→ List(接口) ←-----|          |-→ Set(接口) ←-|
//      |          ↑            |          |              |
//   ArrayList   LinkedList   Vector     HashSet       TreeSet
//                                         ↑
//                                    LinkedHashSet
//
//
//  (2)Map集合体系（双列集合——键值对）：
//        |--------→ Map(接口) ←--------|
//        |             ↑              |
//     HashMap      Hashtable      TreeMap
//        ↑             ↑
//   LinkedHashMap  Properties
//
//
//
// 2.Collect接口
//  ①Collect接口是单列集合的接口。
//  ②Collect的实现子类可以存放多个元素，每个元素可以是Object。
//  ③Collect接口没有直接的实现子类，它是通过子接口List和Set来实现的。
//  ④Collect的子接口，有些是有序的(List)，有些是无序的(Set)。
//  ⑤Collect的实现类，有些可以存放重复的元素(List)，有些不可以(Set)。
//
//
//
// 3.Collect接口的常用方法
//  注意：需要查看Collect接口的全部方法，可以直接查看源码
//      add：添加单个元素
//      remove：删除指定元素
//      contains：查找元素是否存在
//      size：获取元素个数
//      isEmpty：判断是否为空
//      clear：清空
//      addAll：添加多个元素
//      removeAll：删除多个元素
//      containsAll：查找多个元素是否存在
//
//
//
// 4.开发中如何选择集合实现类？
//  (1)单列集合：Collection接口
//      允许重复：List接口
//          增删多：LinkedList[双向链表]
//          查改多：ArrayList[可变数组]
//      不允许重复：Set接口
//          无序：HashSet[哈希表]
//          排序：TreeSet
//          插入和取出顺序一致：LinkedHashSet[哈希表+双向链表]
//  (2)双列集合（键值对）：Map接口
//      键无序：HashMap[哈希表]
//      键排序：TreeMap
//      键插入和取出顺序一致：LinkedHashMap[哈希表+双向链表]
//      读取文件：Properties
//
//


public class CollectionBasic {
    public static void main(String[] args) {
//        Collection
//        Map

        // 测试Collection接口的常用方法
        Collection collection = new ArrayList();

        // add
        collection.add("张三");
        collection.add("Alice");
        collection.add(123);// 数字自动装箱为Integer（Collect集合的元素都是对象）
        collection.add(true);
        System.out.println(collection);

        // remove
        collection.remove("Alice");// 按照指定对象删除
        System.out.println(collection);

        // contains
        System.out.println(collection.contains(123));
        System.out.println(collection.contains(234));

        // size
        System.out.println(collection.size());

        // isEmpty
        System.out.println(collection.isEmpty());

        // clear
        collection.clear();
        System.out.println(collection);

        // addAll
        Collection c1 = new ArrayList();
        c1.add('A');
        c1.add("你好");
        c1.add(233);
        collection.addAll(c1);
        System.out.println(collection);

        // containsAll
        Collection c2 = new ArrayList();
        c2.add('A');
        c2.add(233);
        System.out.println(collection.containsAll(c2));

        // removeAll
        collection.removeAll(c2);
        System.out.println(collection);

    }
}
