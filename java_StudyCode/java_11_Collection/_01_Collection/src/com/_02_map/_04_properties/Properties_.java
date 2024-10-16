package com._02_map._04_properties;

import java.util.Properties;


// Properties
//
//
// 1.Properties特点
//  ①Properties是Hashtable的子类，具有Hashtable(Map)的全部性质、方法。
//  ②Properties还可用于从xxx.properties文件中，加载数据到Properties类对象，并进行读取和修改。
//      注意：xxx.properties文件经常作为配置文件
//


public class Properties_ {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.put("key1", "value1");
        properties.put("key2", "value2");
        properties.put("key3", "value3");
        System.out.println(properties);

        // Properties和Hashtable一样，key和value不能为null
//        properties.setProperty(null, "value");// 报错
//        properties.setProperty("key", null);// 报错
    }
}
