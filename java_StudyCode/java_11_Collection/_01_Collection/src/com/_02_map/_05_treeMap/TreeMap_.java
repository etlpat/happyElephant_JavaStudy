package com._02_map._05_treeMap;

import java.util.Comparator;
import java.util.TreeMap;

// TreeMap
//  （由于之前学过的TreeSet，底层本质上就是TreeMap，因此这里TreeMap的剖析和前面大致相同）
//
//
// 1.TreeMap细节
//  ①TreeMap实现了Map接口，具有Map的全部性质和方法。
//  ②TreeMap的元素是按照key【排序】的，默认为升序。
//  ③TreeMap的排序规则，由构造器中的Comparator比较器对象决定（不传参默认升序），
//      若想自定义排序规则，需要向构造器中传入Comparator对象（匿名内部类即可），并重写它的compare方法。
//      （源码在进行数据比较时，会按照Comparator对象的compare方法，进行key数据的比较）
//
//

public class TreeMap_ {
    public static void main(String[] args) {
        // TreeMap默认按照升序排序
        TreeMap treeMap1 = new TreeMap();
        treeMap1.put('e', "hello");
        treeMap1.put('d', "hello");
        treeMap1.put('c', "hello");
        treeMap1.put('b', "hello");
        treeMap1.put('a', "hello");
        System.out.println(treeMap1);// 默认按key升序排序
        // {a=hello, b=hello, c=hello, d=hello, e=hello}


        // 使用Comparator对象，自定义TreeMap的排序规则
        TreeMap treeMap2 = new TreeMap(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);// 降序
//                return o1.length() - o2.length();// 按长度升序
            }
        });

        treeMap2.put("tom", "value1");
        treeMap2.put("alice", "value2");
        treeMap2.put("kristina", "value3");
        treeMap2.put("jack", "value4");
        treeMap2.put("bob", "value5");
        System.out.println(treeMap2);// 按照compare方法所定义的降序排序
        // {tom=value1, kristina=value3, jack=value4, bob=value5, alice=value2}

        // 若key相同，新值覆盖就值
        treeMap2.put("kristina", "助手");
        System.out.println(treeMap2);
    }
}
