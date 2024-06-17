package com._06_Map;

// Map
//
// (1)集合有两大体系
//  1.Collection体系（单列集合）
//  2.Map体系（双列集合(键值对集合)）
//
//  Map集合格式：{key1=value1, key2=value2,...}
//  Map集合：键不能重复，值不做要求，键和值一一对应
//
//
// (2)Map体系的树：
//  Map<K,V>【接口】
//   ├─HashMap<K,V>【已经实现的类】
//   │  └─LinkedHashMap<K,V>
//   ├─TreeMap<K,V>【已经实现的类】
//   └─...
//
//
// (3)Map集合体系的特点
//  注意：Map系列集合的特点都是由键决定的，值只是附属品，不做要求
//   ·HashMap：(键)无序、(键)不重复、无索引【常用】
//   ·LinkedHashMap：有序(添加元素的顺序)、不重复、无索引
//   ·TreeMap：按照(键)大小默认升序排序、不重复、无索引
//  特点：
//   无序：元素添加和获取的顺序不一致
//   不重复：键不重复【若添加了两个相同键的元素，后加的值会覆盖先前的值】
//   无引索：由于无序，所以肯定无引索
//  注意：若为LinkedHashMap先后添加两个相同键的元素：键的位置还在第一次添加键的位置，但是旧值被新值覆盖
//
//
//
// (4)Map接口的常用方法
//  1.【增】
//      V put(K key, V value);// 存入键值对
//      void putAll(Map<? extends K,? extends V> m);// 存入多个键值对
//  2.【删】
//      V remove(Object key);// 删除键值对，并返回"值"
//  3.【改】
//  4.【查】
//      V get(Object key);// 获得键对应的值
//  5.【其它】
//      boolean containsKey(Object key);// 是否包含某个键
//      boolean containsValue(Object value);// 是否包含某个值
//      Set<K> keySet();// 获取Map全部的"键"（返回键的set集合）
//      Collection<V> values();// 获取Map全部的"值"（返回值的Collection集合）
//      int size();
//      void clear();
//      boolean isEmpty();
//      boolean equals(Object o);
//
//
//
// (5)Map集合体系的遍历方式
//  1.键找值
//      方法：先用keySet()方法，获取Map中键的set集合，之后遍历set集合来找值
//  2.直接遍历键值对
//      ...
//  3.lambda表达式
//      ...

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Map_ {
    public static void main(String[] args) {
        // (1)Map系列集合的特点：存放键值对，无序、不重复，无引索
        // 注意：泛型必须是引用类型
        Map<String, Integer> map = new HashMap<>();
        map.put("手表", 20000);
        map.put("西瓜", 20);
        map.put("母鸡", 20);
        map.put("剪刀", 17);
        map.put("剪刀", 666);// 元素不重复，新的值覆盖旧的值
        System.out.println(map);// {手表=20000, 母鸡=20, 西瓜=20, 剪刀=666}// 元素无序


        // (2)Map的常用方法
        System.out.println("\n\n==========================");
        Map<String, Double> foodMap = new HashMap<>();
        // 1.【增】
        foodMap.put("北京烤鸭", 200.0);
        foodMap.put("汉堡", 15.5);
        foodMap.put("炒青椒", 13.8);
        foodMap.put("驴打滚", 8.6);
        foodMap.put("汉堡", 23.4);// 不重复，新值覆盖旧值
        System.out.println(foodMap);// {北京烤鸭=200.0, 汉堡=23.4, 炒青椒=13.8, 驴打滚=8.6}
        // 2.【删】
        System.out.println(foodMap.remove("炒青椒"));// 13.8
        System.out.println(foodMap.remove("驴打滚"));// 8.6
        System.out.println(foodMap);// {北京烤鸭=200.0, 汉堡=23.4}
        // 3.【查】
        System.out.println(foodMap.get("汉堡"));// 23.4
        System.out.println(foodMap.get("北京烤鸭"));// 200.0
        // 3.【其它】
        System.out.println(foodMap.keySet());// [北京烤鸭, 汉堡]
        System.out.println(foodMap.values());// [200.0, 23.4]
        System.out.println(foodMap.size());// 2
        System.out.println(foodMap.containsKey("炒青椒"));// false
        System.out.println(foodMap.containsValue(23.4));// true
        foodMap.clear();
        System.out.println(foodMap.isEmpty());// true


        // (3)Map的遍历
        System.out.println("\n\n==========================");
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("张三", 18);
        map2.put("李四", 22);
        map2.put("王五", 37);
        // 1.键找值
        for (String key : map2.keySet()) {// 遍历keySet()返回的键的set集合
            System.out.print(key + "=" + map2.get(key) + " ");// 李四=22 张三=18 王五=37
        }
        System.out.println();
        // 2.lambda表达式
        map2.forEach((k, v) -> {
            System.out.print(k + "=" + v + " ");// 李四=22 张三=18 王五=37
        });
    }
}
