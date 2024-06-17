package com._02_Collection;

// Collection集合体系
//
// (1)集合有两大体系
//  1.Collection体系（单列集合）
//  2.Map体系（双列(键值对)集合）
//
// (2)Collection体系的树：
//  Collection<E>【接口】
//   ├─List<E>【接口】
//   │  ├─ArrayList<E>
//   │  └─LinkedList<E>
//   └─Set<E>【接口】
//      ├─HashSet<E>
//      │  └─LinkedHashSet<E>
//      └─TreeSet<E>
//
// (3)Collection集合特点
//  ①Collection集合都具有Collection接口的方法，并且都是泛型类(若不定义成泛型，则可传入不同类型的元素)
//  ②List系列集合：添加元素是有序、可重复、有引索的
//      e.g.ArrayList、LinkedList：有序、可重复、有引索的
//  ③Set系列集合：添加元素是无序、不重复、无引索的
//      e.g.HashSet：无序、不重复、无引索的
//          LinkedHashSet：有序、不重复、无引索的
//          TreeSet:按照大小默认升序排序、不重复、无引索的
//
//
//
// (4)Collection的常用方法
//  Collection接口，是所有子集合的父接口，Collection中定义的增删查改操作，所有实现它的集合都能使用
//  1.【增】
//      boolean add(E e);// 添加一个元素
//      boolean addAll(Collection<? extends E> c);// 添加多个元素
//  2.【删】
//      boolean remove(Object o);// 删除一个元素
//      boolean removeAll(Collection<?> c)// 删除多个元素（求差集）
//  3.【改】
//  4.【查】
//  5.【其它】
//      Iterator<E> iterator();// 获取迭代器对象
//      int size();// 集合中元素个数
//      void clear();// 清空所有元素
//      boolean isEmpty();// 判断集合是否为空
//      Object[] toArray()// 返回包含集合元素的Object数组
//      boolean contains(Object o);// 集合中是否包含某元素？
//      boolean equals(Object o);// 判断两个集合是否相等
//
//
// (5)Collection的遍历方式
//  1.迭代器
//      迭代器：用来遍历集合的专用方式（数组没有迭代器）
//      获取集合的迭代器对象：Iterator i = 集合对象.iterator();
//    Iterator的方法：
//      boolean hasNext();// 如果仍有元素可以迭代，则返回 true
//      E next();// 指向并返回迭代的下一个元素
//    迭代器的运行原理：
//      刚开始new迭代器，迭代器指向头结点(不存放元素)，之后每次next操作，迭代器会指向下一个元素，并将其返回。直到hasNext()==false（当前为最后一个元素）
//
//  2.增强for循环
//      增强for循环，即可遍历集合，又可遍历数组
//      注意：增强for循环遍历集合，底层上还是用迭代器遍历
//      语法：for(元素类型 变量名: 数组或集合){...}
//      功能：将集合/数组中的元素，在循环过程中从前到后依次赋给循环变量
//
//  3.lambda表达式
//


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Collection_ {
    public static void main(String[] args) {
        // (1)Collection接口的方法
        Collection<String> collection = new ArrayList<>();
        Collection<String> c2 = new ArrayList<>();
        // 增
        collection.add("张三");
        collection.add("李四");
        collection.add("王五");
        System.out.println(collection);// [张三, 李四, 王五]
        c2.add("赵六");
        c2.addAll(collection);
        System.out.println(c2);// [赵六, 张三, 李四, 王五]

        // 删
        collection.remove("李四");
        System.out.println(collection);// [张三, 王五]
        c2.removeAll(collection);
        System.out.println(c2);// [赵六, 李四]
        // 其它
        System.out.println(collection.size());// 2
        System.out.println(collection.isEmpty());// false
        System.out.println(collection.contains("张三"));// true
        Object[] arr = collection.toArray();
        for (int i = 0; i < collection.size(); i++) {
            System.out.print(arr[i] + " ");// 张三 王五
        }
        collection.clear();
        System.out.println("\n" + collection.isEmpty());// true
        System.out.println("\n\n======================================");


        // (2)Collection的遍历方式
        Collection<String> c = new ArrayList<>();
        c.add("qwe");
        c.add("asd");
        c.add("zxc");
        c.add("123");
        // 1.迭代器
        Iterator<String> iterator = c.iterator();
        while (iterator.hasNext()) {// 若有下一个，则打印下一个
            System.out.print(iterator.next() + " ");// qwe asd zxc 123
        }
        System.out.println();
        // 2.增强for循环
        for (String str : c) {// 遍历集合（本质上还是用迭代器遍历）
            System.out.print(str + " ");// qwe asd zxc 123
        }
        System.out.println();
        char[] chArr = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i'};
        for (char a : chArr) {
            System.out.print(a + " ");// q w e r t y u i
        }
        System.out.println();
    }
}

