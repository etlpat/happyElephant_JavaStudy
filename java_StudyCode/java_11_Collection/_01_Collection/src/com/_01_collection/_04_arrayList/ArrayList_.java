package com._01_collection._04_arrayList;

import java.util.ArrayList;

// ArrayList
//
// 1.ArrayList细节
//  ①ArrayList的元素可以为null，并且多个。
//  ②ArrayList底层是由【数组】来实现数据存储的。
//  ③ArrayList基本等同于Vector，区别在于ArrayList的执行效率高，但是线程不安全。
//
//
//
// 2.ArrayList源码分析
//  (1)ArrayList的【本质是数组】
//      ArrayList底层使用一个Object类型的数组elementData，用于存放集合数据。
//
//  (2)ArrayList的构造/扩容
//      ①使用无参构造器，则初始elementData容量为0，
//          第一次为ArrayList添加数据，elementData扩容为10，
//          之后每次扩容，elementData的容量变为原先的1.5倍（elementData += elementData/2）。
//
//      ②使用有参构造器，可以指定初始elementData的大小，
//          之后每次扩容，elementData的容量变为原先的1.5倍。
//
//


public class ArrayList_ {
    public static void main(String[] args) {
        // (1)ArrayList的元素，可以为null
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(null);
        arrayList1.add("hello");
        arrayList1.add(null);
        System.out.println(arrayList1);


        // (2)以下代码用于追源码
        ArrayList arrayList2 = new ArrayList(20);
        for (int i = 1; i <= 20; i++) {
            arrayList2.add("num" + i);
        }
        System.out.println(arrayList2);
        arrayList2.add("hello");
        arrayList2.add(null);
        System.out.println(arrayList2);
    }
}
