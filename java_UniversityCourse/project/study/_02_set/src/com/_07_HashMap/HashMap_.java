package com._07_HashMap;

// 注意：HashMap、LinkedMap、TreeMap都没有自己的新增方法，它们的方法全部都是实现的Map的方法
// 因此，这里HashMap的方法，和Map中的方法完全一致
// HashMap；无序，不重复，无索引
// HashMap底层，本质还是哈希表，元素存放一个键和一个值（是将键和值合成一个元素存放）

import java.util.HashMap;

public class HashMap_ {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        // 【增】
        map.put("陕西", 12);
        map.put("黑龙江", 20);
        map.put("山西", 18);
        map.put("江苏", 16);
        System.out.println(map);// {黑龙江=20, 山西=18, 陕西=12, 江苏=16}
        // 【删】
        map.remove("江苏");
        System.out.println(map);// {黑龙江=20, 山西=18, 陕西=12}
        // 【查】
        System.out.println(map.get("山西"));// 18
        // 【其它】
        System.out.println(map.containsKey("黑龙江"));// true
        System.out.println(map.containsValue(12));// true
        System.out.println(map.keySet());// [黑龙江, 山西, 陕西]
        System.out.println(map.values());// [20, 18, 12]


        // 遍历HashSet
        for (String key : map.keySet()) {// 遍历包含键的set集合
            System.out.println("键：" + key + "，值：" + map.get(key));
        }
    }
}
