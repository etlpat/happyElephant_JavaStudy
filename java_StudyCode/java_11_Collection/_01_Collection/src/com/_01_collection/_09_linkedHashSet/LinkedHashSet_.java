package com._01_collection._09_linkedHashSet;

import java.util.LinkedHashSet;


// LinkedHashSet
//
// 1.LinkedHashSet细节
//  ①【LinkedHashSet是HashSet的子类，因此具有HashSet的全部性质、功能】。
//  ②LinkedHashSet底层是LinkedHashMap，该结构为哈希表＋双向链表。
//  ③LinkedHashSet根据元素的hash值来决定元素的存储位置，
//      【同时使用双向链表维护元素次序，这使得元素看起来是以插入顺序保存的】。
//
//
// 2.LinkedHashSet底层结构
//  ①LinkedHashSet中维护了一个哈希表和双向链表。
//  ②每个结点有before和after属性，用于形成双向链表。
//  ③在添加元素时，先求hash值，得出索引，确定该元素在table的位置，
//      之后从前到后比对这条链的元素是否重复，若重复则不添加，
//      若该元素不重复，将其添加到哈希表，并链入双向链表。
//  ④因此，遍历LinkedHashSet的双向链表，得到的元素次序就能和插入的顺序一致。
//
//


public class LinkedHashSet_ {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();


        // 遍历顺序和添加顺序一致
        linkedHashSet.add("abc");
        linkedHashSet.add('A');
        linkedHashSet.add(12);
        linkedHashSet.add("hello world");
        linkedHashSet.add(true);
        System.out.println(linkedHashSet);


        // 不能添加重复元素
        System.out.println(linkedHashSet.add('A'));
        System.out.println(linkedHashSet.add(12));
        System.out.println(linkedHashSet);

    }
}
