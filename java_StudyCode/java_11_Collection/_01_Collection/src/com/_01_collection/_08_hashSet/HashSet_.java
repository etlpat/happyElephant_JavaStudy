package com._01_collection._08_hashSet;

import java.util.HashSet;


// HashSet
//
// 1.HashSet细节
//  ①HashSet实现了Set接口，具有Set集合的全部性质。
//      （HashSet的元素无序、不可重复，不支持索引）
//      （HashSet可以存放null，但是只能有1个）
//  ②HashSet本质是HashMap，查看源码可知。
//  ③HashSet添加元素时，通过equals()判断元素是否重复。
//      因此，HashSet元素是否重复，取决于程序员如何编写对象的equals()方法。
//
//
// 2.HashSet底层结构
//  ①HashSet底层是HashMap。（哈希表：数组+链表+红黑树）
//  ②添加一个元素时，先得到该元素的Hash值，并将其转化为索引值。
//  ③找到存储数据的表table，看这个索引的位置是否已经存放链表。
//  ④若没有，则直接插入。
//  ⑤若有，遍历该链表，使用equals逐一比较，若全都不同，则将该元素添加到链尾。
//      若遇到相同的元素，则放弃添加。
//  ⑥注意：若某条链表的元素个数>=一定值(默认8)，且哈希表整体的大小>=一定值(默认64)，
//      则会将该条链表化为红黑树。
//


public class HashSet_ {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        hashSet.add("john");
        hashSet.add("bob");
        hashSet.add("alice");

        System.out.println(hashSet);

    }
}
