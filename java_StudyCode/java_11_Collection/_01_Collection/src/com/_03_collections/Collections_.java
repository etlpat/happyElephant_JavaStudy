package com._03_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


// Collections
//
//
// 1.Collections工具类
//  ①Collections是一个操作Collection和Map等集合的【工具类】。
//  ②Collections中提供了一系列【静态方法】，用于对集合元素进行排序、查询、修改等操作。
//
//
// 2.Collections工具类常用方法
//  注意：以下均为static方法，可以通过类名直接调用。
//  (1)排序操作
//      ①void reverse(List<?> list);    对List进行逆序
//      ②void shuffle(List<?> list);    对List集合元素进行随机排序（shuffle英文：洗牌）
//      ③void sort(List<T> list);       对List集合元素进行升序排序
//      ④sort(List<T> list, Comparator<? super T> c);   根据Comparator比较器对象，对List进行排序
//      ⑤void swap(List<?> list, int i, int j); 将List集合中下标为i和j的元素进行交换
//  (2)查找、替换
//      ①T max(Collection<? extends T> coll);   返回集合元素中的最大值
//      ②T min(Collection<? extends T> coll);   返回集合元素中的最小值
//      ③T max(Collection<? extends T> coll, Comparator<? super T> comp);   根据Comparator指定的排序方式，返回集合中的最大值
//      ④T min(Collection<? extends T> coll, Comparator<? super T> comp);   根据Comparator指定的排序方式，返回集合中的最小值
//      ⑤int frequency(Collection<?> c, Object o);  返回指定元素在集合中出现的次数
//      ⑥void copy(List<? super T> dest, List<? extends T> src);    将src集合中的内容复制到dest中（若dest集合的元素个数（size）比src少，则抛异常）
//      ⑦boolean replaceAll(List<T> list, T oldVal, T newVal);      在List集合中，使用newVal替换所有的oldVal0
//
//
//


public class Collections_ {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println(arrayList);


        // (1)排序
        // reverse 逆序List中的元素
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        // shuffle 随机排序List中的元素
        Collections.shuffle(arrayList);
        System.out.println(arrayList);

        // sort 默认按照升序排序List中的元素
        Collections.sort(arrayList);
        System.out.println(arrayList);

        // sort 按照Comparator定义的排序规则，对元素进行排序
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(arrayList);

        // swap 交换List中指定下标的两个元素
        Collections.swap(arrayList, 1, 3);
        System.out.println(arrayList);


        // (2)查改
        // max 获取集合元素的最大值
        System.out.println(Collections.max(arrayList));

        // min 获取集合元素的最小值
        System.out.println(Collections.min(arrayList));

        // frequency 获取集合中某元素出现的次数
        System.out.println(Collections.frequency(arrayList, 2));

        // copy 将集合src中的内容拷贝到dest中（要求dest中的元素个数size>=src）
        ArrayList dest = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            dest.add(null);
        }
        Collections.copy(dest, arrayList);
        System.out.println(dest);


        // replaceAll 在集合中，使用newVal替换所有的oldVal
        Collections.replaceAll(arrayList, 1, 'a');
        System.out.println(arrayList);

    }
}