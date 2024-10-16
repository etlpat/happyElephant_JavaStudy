package com._01_collection._03_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


// List
//
// 1.List特点
//  ①List是Collection接口的子接口。
//  ②List中的元素【有序、可重复】。
//  ③List中的元素，【支持索引，下标从0开始递增】。
//
//
// 2.List常用方法
//  注意：List可以使用从Collection中继承的所有方法，
//      在此基础上，由于List具有索引这一特性，又拓展出许多方法，如下：
//  ①void add(int index, E element); 在index位置插入元素
//  ②boolean addAll(int index, Collection<? extends E> c);   在index位置插入集合c中的全部元素
//  ③E remove(int index);    删除并返回指定下标的元素
//  ④E get(int index);   获取指定下标的元素
//  ⑤int indexOf(Object o);  获取指定元素首次出现的下标
//  ⑥int lastIndexOf(Object o);  获取指定元素末次出现的下标
//  ⑦E set(int index, E element);    设置指定下标的元素
//  ⑧List<E> subList(int fromIndex, int toIndex);    截取子集合（包前不包后）
//
//
// 3.遍历List的三种方式
//  ①通过iterator迭代器遍历
//  ②通过for-each循环遍历
//  ③通过元素下标，使用普通for循环遍历（List接口是有序集合，元素下标从0开始递增）
//


public class List_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add('A');
        list.add(1);
        list.add("hello");
        list.add(true);
        list.add('A');// List支持加入重复元素
        System.out.println(list);


        // (1)List列表的下标，是从0开始的
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));


        // (2)List接口新增的方法
        // add(int index, E element)
        list.add(2, "张三");
        System.out.println(list);

        // addAll(int index, Collection<? extends E> c)
        List l1 = new ArrayList();
        l1.add("123");
        l1.add("456");
        l1.add("789");
        list.addAll(4, l1);
        System.out.println(list);

        // remove(int index)
        list.remove(1);
        list.remove(list.size() - 2);
        System.out.println(list);

        // get(int index)
        System.out.println(list.get(1));

        // indexOf(Object o)
        // lastIndexOf(Object o)
        System.out.println(list.indexOf('A'));
        System.out.println(list.lastIndexOf('A'));

        // set(int index, E element)
        list.set(0, 'a');
        System.out.println(list);

        // subList(int fromIndex, int toIndex)
        System.out.println(list.subList(1, 3));

    }
}
