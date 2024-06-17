package com._01_ArrayList;

// ArrayList类（集合）
//
// (1)构造器
//  ArrayList();
//      功能：构造一个初始容量为 10 的空列表，可自动扩容。
//  ArrayList(int initialCapacity)
//      功能：构造一个具有指定初始容量的空列表，可自动扩容。
//
//
//
// (2)常用方法
//  1.【增】
//  boolean add(E e);// 功能：将指定的元素添加到此列表的尾部。
//  void add(int index, E element);// 功能：将指定的元素插入此列表中的指定位置。
//
//  2.【删】
//  E remove(int index);// 移除此列表中指定位置上的元素。
//  boolean remove(Object o);// 移除此列表中首次出现的指定元素（如果存在）。
//
//  3.【改】
//  E set(int index, E element);// 用指定的元素替代此列表中指定位置上的元素。
//
//  4.【查】
//  E get(int index);// 返回此列表中指定位置上的元素。
//  int indexOf(Object o);// 返回此列表中首次出现的指定元素的索引，或如果此列表不包含元素，则返回 -1。
//
//  5.【其它】
//  int size();// 返回此列表中的元素数。
//  void clear();// 移除此列表中的所有元素。
//  boolean isEmpty();// 如果此列表中没有元素，则返回 true
//  Object[] toArray();// 按适当顺序（从第一个到最后一个元素）返回包含此列表中所有元素的数组。
//
//
//
// (3)ArrayList类型的特点
//  1.动态数组，大小可变，自动扩容
//  2.可存储任意类型的对象（基本类型或引用类型）
//  3.可定义为泛型ArrayList<类型>（如：ArrayList<String>，集合的元素只能是String）
//
//
//
// (4)注意事项
//  1.虽然ArrayList是集合类，但是其中的元素可以重复
//  2.ArrayList集合类是有序的，元素顺序就是add的顺序
//  3.综上两点，ArrayList虽说叫集合类，但是其【本质就是不限制元素类型的普通顺序表】
//  4.泛型不支持基本类型，<>中只能是引用类型


import java.util.ArrayList;

public class ArrayList_ {
    public static void main(String[] args) {
        // (1)ArrayList集合类型
        ArrayList arrayList = new ArrayList();

        // 1.增（非泛型ArrayList，可以添加任意类型元素）
        arrayList.add("张三");// 添加元素
        arrayList.add(12);
        arrayList.add('男');
        arrayList.add(1, "大学生");// 向指定下标添加元素
        arrayList.add("张三");// 元素可重复
        System.out.println("集合元素个数为：" + arrayList.size());// 5
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");// 张三 大学生 12 男 张三
        }
        System.out.println();

        // 2.删（remove删除并返回元素对象）
        System.out.println(arrayList.remove(2));// 12（删除指定下标对应的元素，并返回）
        System.out.println(arrayList.remove("张三"));// true（删除首个指定对象，返回boolean）
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");// 大学生 男 张三
        }
        System.out.println();

        // 3.改
        arrayList.set(0, "研究生");
        System.out.println(arrayList);// [研究生, 男, 张三]


        // (2)泛型ArrayList
        ArrayList<String> stringArrayList = new ArrayList<String>();// new后面的<>中类型可以省略
        stringArrayList.add("张三");
        stringArrayList.add("李四");
        //stringArrayList.add(12);// 报错
        System.out.println(stringArrayList);// [张三, 李四]
    }
}
