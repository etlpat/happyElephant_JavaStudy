package com._04_LinkedList;

// LinkedList
//
// (1)对首尾元素(结点)操作的方法
//  由于LinkedList是双向链表，因此它对首尾元素的增删以及访问是极快的，于是Java为其添加了众多对首尾元素的操作
//  1.【增】
//  void addFirst(E e);// 添加首元结点
//  void addLast(E e);// 添加尾结点
//  2.【删】
//  E removeFirst();// 删除首元结点
//  E removeLast();// 删除尾结点
//  3.【改】
//  4.【查】
//  E getFirst();// 获取首元结点元素
//  E getLast();// 获取尾结点元素
//
//  由于LinkedList对首尾元素操作方便，因此常用来实现栈/队列
//
//
// (2)注意事项：
//  LinkedList支持索引
//  虽然LinkedList是链表，但是由于其实现了List接口，LinkedList支持通过索引操作元素


import java.util.LinkedList;


public class LinkedList_ {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("张三");
        linkedList.add("李四");
        linkedList.add("王五");
        System.out.println(linkedList);// [张三, 李四, 王五]


        // (1).LinkedList支持索引
        linkedList.add(1, "小红");
        linkedList.add(3, "小芳");
        linkedList.remove(2);
        System.out.println(linkedList.get(2));// 小芳
        System.out.println(linkedList);// [张三, 小红, 小芳, 王五]


        // (2).LinkedList的操作首元结点/尾结点的方法
        // 【增】
        linkedList.addFirst("乌龟");
        linkedList.addLast("狮子");
        System.out.println(linkedList);// [乌龟, 张三, 小红, 小芳, 王五, 狮子]
        // 【查】
        System.out.println(linkedList.getFirst());// 乌龟
        System.out.println(linkedList.getLast());// 狮子
        // 【删】
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);// [张三, 小红, 小芳, 王五]
    }
}
