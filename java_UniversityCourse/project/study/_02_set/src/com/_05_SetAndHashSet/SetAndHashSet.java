package com._05_SetAndHashSet;

// Set体系集合
//
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
//  其中，实现set接口的集合是【无序、不重复、无引索的】
//      1.无序：数据的添加顺序和获取顺序不一致（可能一致）【无序，但不是随机】
//      2.不重复：若添加多个相同元素，实际只保留一个
//      3.无索引：由于无序，所以肯定无索引
//  set的创建实现类：
//      1.HashSet：无序、不重复、无引索的
//      2.LinkedHashSet：有序、不重复、无引索的
//      3.TreeSet:按照大小默认升序排序、不重复、无引索的
//
//
// (2)Set中常用方法
//  由于Set不支持引索，因此Set接口的方法和Collection中的方法【完全一致】
//
//
//
// (3)HashSet
//  HashSet实现了set，HashSet的数据结构是哈希表（无序、不重复、无引索）
//  JDK_1.8前，Hash表：数组+链表； JDK_1.8后，Hash表：数组+链表+红黑树
//  HashSet并没有新增方法，它包含的方法即Set的方法，等于Collection的方法
//
//  【增】
//  boolean add(E e);
//  boolean addAll(Collection<? extends E> c);
//  【删】
//  boolean remove(Object o)
//  boolean removeAll(Collection<?> c);
//  【其它】
//  int size();
//  void clear();
//  boolean contains(Object o);
//  boolean isEmpty();
//  Iterator<E> iterator();// 获取迭代器


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetAndHashSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // (1)基本操作
        // 1.【增】
        set.add("张三");
        set.add("李四");
        set.add("王五");
        set.add("张三");// 【不重复】若位添加重复元素，集合仅保留一份数据
        System.out.println(set);// [李四, 张三, 王五]【无序】

        // 2.【删】
        set.remove("李四");
        System.out.println(set);

        // 3.【其它】
        System.out.println(set.size());// 2
        System.out.println(set.isEmpty());// false
        System.out.println(set.contains("张三"));// true
        set.clear();
        System.out.println(set.isEmpty());// true


        // (2)Set的遍历
        System.out.println("\n\n==================");
        Set<String> set2 = new HashSet<>();
        set2.add("123");
        set2.add("qwe");
        set2.add("asd");
        set2.add("zxc");

        // 1.迭代器遍历
        Iterator<String> it = set2.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");// 123 asd zxc qwe
        }
        System.out.println();

        // 2.增强for遍历
        for (String str : set2) {
            System.out.print(str + " ");// 123 asd zxc qwe
        }
        System.out.println();
    }
}
