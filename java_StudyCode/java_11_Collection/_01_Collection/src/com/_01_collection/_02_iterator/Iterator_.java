package com._01_collection._02_iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


// 迭代器
//
//
// 1.基本介绍
//  由于Collection接口继承了Iterable接口，因此Collection的所有实例都可以使用iterator迭代器对象。
//   ①iterator对象称为迭代器，用于遍历Collection集合中的元素。
//   ②实现了Collection接口的集合,都有一个【Iterator<T> iterator()】方法，
//      该方法可以返回一个iterator迭代器对象。
//   ③iterator仅用于遍历集合,iterator本身不存放对象。
//
//
//
// 2.迭代器iterator
//  (1)iterator介绍
//      迭代器iterator用于遍历Collection集合。
//      iterator初始指向集合的头节点（不包含数据）。
//
//  (2)iterator的方法
//      iterator.hasNext()方法：判断集合是否含有下一个元素。
//      iterator.next()方法：指向并返回下一个元素（若无下一个元素则报错）。
//
//  (3)使用iterator遍历集合
//      遍历代码：
//          while (iterator.hasNext()) {
//              System.out.println(iterator.next());
//          }
//      运行步骤：
//          〇获取集合的迭代器，迭代器对象初始指向集合的头节点（不存放数据）。
//          ①hasNext()判断是否具有下一个元素，若没有则停止遍历。
//          ②若有下一个元素，next()指向并返回下一个元素的值。
//          ③反复执行以上两步，直到遍历完集合的全部元素。
//
//
//
// 3.for-each循环遍历集合
//  for-each语法：
//      for (Object obj : collection){
//          System.out.println(obj);
//      }
//  注意：
//      for-each本质还是使用iterator迭代器来遍历集合。
//      for-each只能用于遍历数组或集合。
//
//


public class Iterator_ {
    public static void main(String[] args) {
        // 创建集合
        ArrayList arrayList = new ArrayList();
        arrayList.add("张三");
        arrayList.add(1);
        arrayList.add("A");
        arrayList.add("hello world");


        // (1)使用迭代器遍历集合
        // 获取集合的迭代器对象
        Iterator iterator = arrayList.iterator();
        // 使用迭代器遍历集合
        while (iterator.hasNext()) {// 若有下一个元素
            System.out.println(iterator.next());// 指向并返回下一个元素
        }
        System.out.println("=============");


        // (2)使用for-each遍历集合
        for (Object obj : arrayList) {
            System.out.println(obj);
        }

    }
}
