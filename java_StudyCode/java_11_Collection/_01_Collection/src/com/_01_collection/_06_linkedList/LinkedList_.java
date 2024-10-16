package com._01_collection._06_linkedList;

import java.util.LinkedList;

// LinkedList
//
// 1.LinkedList细节
//  ①LinkedList底层实现了双向链表和双端队列特点。
//  ②LinkedList的元素可以为null。
//  ③LinkedList线程不安全，没有实现同步。
//
//
// 2.LinkedList底层结构
//  ①LinkedList的本质是一个【双向链表】。
//  ②LinkedList中维护了两个属性first和last分别指向了【首节点】和【尾节点】。
//  ③链表的每个节点，都是Node对象（Node是LinkedList的内部类），
//      每个节点中，由prev指向前一个节点，next指向下一个节点。
//  ④由于LinkedList是双向链表，因此增删效率高，查找效率低。
//
//


public class LinkedList_ {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10; i++) {
            linkedList.add((char) ('A' + i));
        }
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);
    }
}
