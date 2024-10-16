package com._01_collection._05_vector;

import java.util.Vector;


// Vector
//
// 1.Vector细节
//  ①Vector底层是由【数组】实现数据存储，与ArrayList类似。
//  ②Vector是线程同步的，即线程安全。Vector的方法带有synchronized。
//      （ArrayList线程不安全，因此当开发中需要线程同步安全时，应使用Vector）
//
//
// 2.Vector源码分析
//  (1)Vector与ArrayList类似，都是使用数组【Object[] elementData】存储数据。
//  (2)Vector的构造/扩容：
//      ①若使用无参构造器构造Vector，初始大小默认是10，满后，按照2倍扩容。
//      ②若使用有参构造器指定初始Vector大小，满后，按照2倍扩容。
//
//


public class Vector_ {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add(1);
        vector.add("西游戏");
        vector.add('A');
        System.out.println(vector);
    }
}
