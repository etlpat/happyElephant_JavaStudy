package com._02_map._03_hashtable;

import java.util.Hashtable;


// Hashtable
//
//
// 1.Hashtable特点
//  ①Hashtable是Map的实现类，具有Map接口的全部性质、方法。
//  ②Hashtable的使用方法基本上和HashMap一样。
//  ③Hashtable的【键和值均不能为null】，否则抛出NullPointerException空指针异常。
//  ④Hashtable是【线程安全】的（方法具有synchronized关键字），HashMap是线程不安全的。
//


public class Hashtable_ {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();

        hashtable.put("key1", "value1");
        hashtable.put("key2", "value2");
        hashtable.put("key3", "value3");
        System.out.println(hashtable);

        // Hashtable的key和value均不能为null
//        hashtable.put(null, "value");// 报错
//        hashtable.put("key", null);// 报错

    }
}
