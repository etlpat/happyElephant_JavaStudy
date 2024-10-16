package com._02_map._02_hashMap;

import java.util.HashMap;


// HashMap
//
//
// 1.HashMap特点
//  ①HashMap是Map接口的实现类，具有Map接口的全部性质、方法。
//      HashMap是Map接口使用频率最高的实现类。
//  ②HashMap是以键值对k-v来存储数据的；
//      key无序、不可重复、不支持索引的，而value可以重复；
//      每个key单向对应一个value。
//  ③HashMap的底层结构是哈希表（数组+链表+红黑树），
//      为了方便遍历，HashMap类内部也创建了Collection系列的集合：
//          EntrySet集合，用于存放全部结点entry的引用。
//          KeySet集合，用于存放全部键key的引用。
//          Values集合，用于存放全部值value的引用。
//      （以上规则均与Map接口相同）
//  ④HashMap没有实现线程同步，是线程不安全的。
//
//
//
// 2.HashMap底层源码
//  （由于之前的HashSet底层就是HashMap，因此这里的HashMap源码剖析和之前HashSet篇大致相同）
//  HashMap的添加/扩容：
//      ①HashMap底层维护了Node[]类型的数组table，即哈希表的数组部分。
//      ②HashMap中有属性（加载因子）loadFactor=0.75;
//          表示若HashMap的元素个数到达table表长的3/4时，哈希表进行扩容。
//      ③当向哈希表中添加存放了k-v的Node：
//          1) 通过key的hashCode，求出该键值对在table的索引。
//          2) 判断该索引处是否有元素，若没有，则直接添加。
//          3) 若该索引处有元素，则遍历这条链表/红黑树，逐一判断key值是否重复。
//          4) 若key不重复，则将该Node链到该链表的表尾。
//          5) 若key重复，使用新的value替换之前旧的value，结束该流程。
//      ④若以上添加元素的过程中，发现容量不够，则需要扩容。
//          1) Node<K,V>[]类型的table初始为null。
//          2) 首次添加元素，table大小扩容为16，临界值为16*3/4=12。
//          3) 之后，每次元素个数到达临界值，开始扩容，
//             每次扩容，table的容量变为原先的2倍，临界值始终为容量的3/4。
//      ⑤链表的树化：
//          若某条链表的元素个数>=8，且哈希表的长度>=64，此时会将该链表化为红黑树。
//  【注意：若想知道更详细的内容，就追源码。】
//
//
//


public class HashMap_ {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");

        hashMap.put("key2", "值2");
    }
}
