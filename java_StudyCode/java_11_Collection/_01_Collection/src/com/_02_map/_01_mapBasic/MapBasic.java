package com._02_map._01_mapBasic;

import java.util.*;


// Map接口
//
//
// 1.Map集合体系
//  Map集合（双列集合——键值对）：
//        |--------→ Map(接口) ←--------|
//        |             ↑              |
//     HashMap      Hashtable      TreeMap
//        ↑             ↑
//   LinkedHashMap  Properties
//
//
//
// 2.Map接口介绍
//  ①Map与Collection并列存在，Collection是单列集合，Map是双列集合。
//  ②Map中的数据以键值对的形式存在(key-value)，
//      其中，key和value可以是任何引用类型的数据（若是输入常量会自动装箱成对应的类对象），
//      之后会封装到HashMap$Node对象中。
//  ③Map的key是无序、不可重复、不支持索引的（和Collection系列的Set类似），
//      每个key都有value与之对应。
//  ④Map中的key不允许重复，value可以重复。
//  ⑤Map中的key可以为null，但只能存在一个key为null。
//      Map中的value可为空，且可有多个value为null。
//  ⑥key和value之间存在单向对应关系，即通过key总能找到对应的value。
//  ⑦实际使用，常拿String作为Map的key。
//  ⑧Map将每对键值对k-v存放在一个Node结点对象当中（Node是HashMap的内部类，因此也可写作HashMap$Node），
//      由于Node类实现了Entry接口，因此也可以说一对k-v就是一个Entry。
//
//
//
// 3.Map底层源码（以HashMap为例）
//  (1)Map结构：
//      Map的主体结构是哈希表（数组+链表+红黑树），其中使用Node结点存放键值对k-v。
//      注意：Map的主体结构是哈希表；下面的EntrySet、KeySet、Values，这些集合的元素全是引用，指向该哈希表中的数据（目的是为了方便的遍历Map）。
//  (2)EntrySet集合（属于Collection系列）：
//      由于Map的元素存放在哈希表（散列表）中，元素分散不易遍历，
//      因此，Map中定义了内部类EntrySet集合enterSet，用于存放Entry对象。
//      （Node实现Entry接口，EntrySet集合存放的Entry对象的运行类型均为Node）
//      【EntrySet集合，每个元素都是Entry引用，指向哈希表中的Node对象；该集合用于快速遍历Map的元素。】
//  (3)KeySet集合和Values集合（属于Collection系列）：
//      类似于EntrySet集合，Map还提供了KeySet和Values集合，分别存放哈希表中key和value的引用，方便单独遍历key和value。
//      其中，KeySet类型的keySet集合，用于存放全部键key的引用，
//          Values类型的values集合，用于存放全部值value的引用。
//
//
//
// 4.Map接口常用方法
//  ①V put(K key, V value); 添加键值对（若添加的k-v 键相同，值不同，则新值覆盖旧值）
//  ②V remove(Object key);  通过键，删除键值对
//  ③boolean remove(Object key, Object value);  删除键值对
//  ④V get(Object key);     通过键，获取值
//  ⑤int size();            获取元素个数
//  ⑥boolean isEmpty();     判断Map是否为空
//  ⑦void clear();          清空元素
//  ⑧boolean containsKey(Object key);   判断键是否存在
//  ⑨boolean containsValue(Object value);   判断值是否存在
//  ⑩Set<K> keySet();       获取存放全部键的keySet集合
//  ⑾Collection<V> values();获取存放全部值的values集合
//  ⑿Set<Map.Entry<K, V>> entrySet();   获取存放全部结点的entrySet集合
//
//
//
// 5.Map集合的遍历
//  注意：由于Map接口没有继承Iterable，因此不能使用迭代器对象iterator（map不能用迭代器/增强for遍历），
//      不过，Map中具有Collection系列的EntrySet、KeySet、Values集合，通过这些集合可以遍历Map。
//  (1)遍历keySet集合（可获取全部k、v）：
//      使用迭代器/增强for，可以遍历keySet集合，获取map的全部键key。
//      可以用map.get(key)的方式，获取键k对应的值v。
//  (2)遍历values集合（只可获取全部v）：
//      使用迭代器/增强for，可以遍历values集合，获取map的全部值value。
//  (3)遍历entrySet集合（可获取全部k-v）：
//      使用迭代器/增强for，可以遍历entrySet集合，获取map的全部结点entry。
//      entry.getKey()获取结点中的key；entry.getValue()获取结点中的value。
//
//


public class MapBasic {
    public static void main(String[] args) {
        // (1)map的常用方法
        Map map1 = new HashMap();

        // put
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        map1.put("key3", "value3");
        System.out.println(map1);
        map1.put("key1", "值1");// 若添加的键相同值不同，则新值覆盖旧值。
        System.out.println(map1);

        // remove
        map1.remove("key2");
        System.out.println(map1);

        // get
        System.out.println(map1.get("key1"));

        // size
        System.out.println(map1.size());

        // isEmpty
        System.out.println(map1.isEmpty());

        // containsKey/containsValue
        System.out.println(map1.containsKey("key1"));
        System.out.println(map1.containsKey("key2"));
        System.out.println(map1.containsValue("value2"));
        System.out.println(map1.containsValue("value3"));

        // keySet/values
        map1.put(null, null);
        System.out.println(map1.keySet());
        System.out.println(map1.values());

        // clear
        map1.clear();
        System.out.println(map1);


        // (2)map的遍历
        Map map2 = new HashMap();
        map2.put("key1", "value1");
        map2.put("key2", "value2");
        map2.put("key3", "value3");

        // ①通过keySet集合来遍历
        Set keySet = map2.keySet();

        // 迭代器
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.print(key + "-" + map2.get(key) + "  ");
        }
        System.out.println();

        // 增强for
        for (Object key : keySet) {
            System.out.print(key + "-" + map2.get(key) + "  ");
        }
        System.out.println();

        // ②通过values集合来遍历
        Collection values = map2.values();

        // 迭代器
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + "  ");
        }
        System.out.println();

        // 增强for
        for (Object value : values) {
            System.out.print(value + "  ");
        }
        System.out.println();

        // ③通过entrySet集合来遍历
        Set entrySet = map2.entrySet();

        // 迭代器
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator2.next();
            System.out.print(entry.getKey() + "-" + entry.getValue() + "  ");
        }
        System.out.println();

        // 增强for
        for (Object obj : entrySet) {
            Map.Entry entry = (Map.Entry) obj;
            System.out.print(entry.getKey() + "-" + entry.getValue() + "  ");
        }
        System.out.println();

    }
}
