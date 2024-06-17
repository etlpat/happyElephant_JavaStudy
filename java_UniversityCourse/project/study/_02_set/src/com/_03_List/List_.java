package com._03_List;

// (1)Collection体系的树：
//  Collection<E>【接口】
//   ├─List<E>【接口】
//   │  ├─ArrayList<E>
//   │  └─LinkedList<E>
//   └─Set<E>【接口】
//      ├─HashSet<E>
//      │  └─LinkedHashSet<E>
//      └─TreeSet<E>
//
// 其中，List系列集合：添加元素是有序、可重复、有引索的
//  e.g.ArrayList、LinkedList：都是有序、可重复、有引索的
//
//
// (2)List接口中新增的方法
//  List泛型接口，继承了Collection接口的一切方法
//  List接口还新增了众多与【索引】相关的方法
//  1.【增】
//      void add(int index, E element);// 在指定位置插入元素
//  2.【删】
//      E remove(int index);// 删除并返回指定下标元素
//  3.【改】
//      E set(int index, E element);// 修改(替换)并返回指定下标元素
//  4.【查】
//      E get(int index);// 返回指向下标的元素
//      int indexOf(Object o);// 返回指定元素的下标（不存在则返回-1）
//  5.【其它】
//
//
// (3)List系列集合的遍历方式
//  1.通过索引遍历
//  2.集合的迭代器
//  3.加强for
//  4.lambda表达式
//
//
//
// (4)ArrayList和LinkedList
//  ArrayList：即用顺序表实现的List（增删效率低，查改效率高）
//            若顺序表满了，则默认扩容1.5倍；若一次存入n个元素，1.5倍放不下，则直接扩容n个空间
//  LinkedList：即通过【双向链表】实现的List（增删效率高，查改效率低）
//             java中使用链表，大多数都是用双向链表的
//             由于LinkedList是双向链表，因此对首尾元素的增删访问是极快的，于是Java为其添加了众多对首尾元素的操作
//  以上二者包含的方法基本相同，但是数据结构不同，实际根据不同的应用场景选择相应的结构。


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class List_ {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        System.out.println(list);// [张三, 李四, 王五, 赵六]


        // (1)List系列集合的新增方法（索引）
        // 【增】
        list.add(1, "小明");
        list.add(3, "小红");
        System.out.println(list);// [张三, 小明, 李四, 小红, 王五, 赵六]
        // 【删】
        System.out.println(list.remove(2));// 李四
        System.out.println(list.remove(0));// 张三
        System.out.println(list);// [小明, 小红, 王五, 赵六]
        // 【改】
        System.out.println(list.set(2, "小李"));// 王五
        System.out.println(list.set(3, "小王"));// 赵六
        System.out.println(list);// [小明, 小红, 小李, 小王]
        // 【查】
        System.out.println(list.get(1));// 小红
        System.out.println(list.indexOf("小李"));// 2


        // (2)List系列集合的遍历
        // 1.索引遍历
        System.out.println("\n\n===========================");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");// 小明 小红 小李 小王
        }
        System.out.println();
        // 2.迭代器遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");// 小明 小红 小李 小王
        }
        System.out.println();
        // 3.强化for遍历
        for (String str : list) {
            System.out.print(str + " ");// 小明 小红 小李 小王
        }
        System.out.println();
    }
}
