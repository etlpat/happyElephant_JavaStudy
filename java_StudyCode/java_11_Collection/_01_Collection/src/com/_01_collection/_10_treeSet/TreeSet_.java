package com._01_collection._10_treeSet;

import java.util.Comparator;
import java.util.TreeSet;


// TreeSet
//
//
// 1.TreeSet细节
//  ①TreeSet实现了Set接口，具有Set集合的全部性质、方法。
//  ②【TreeSet的底层是TreeMap】，看源码可知。
//  ③TreeSet集合的元素是【排序】的，默认排序规则为升序。
//  ④TreeSet的排序规则，由构造器中的Comparator比较器对象决定（不传参默认升序），
//      若想自定义排序规则，需要向构造器中传入Comparator对象，并重写它的compare方法。
//      （源码在进行数据比较时，会按照Comparator对象的compare方法，进行数据的比较）
//
//


public class TreeSet_ {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();

        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("bob");
        treeSet.add("alice");

        System.out.println(treeSet);


        // 向TreeSet的构造器，传入比较器对象，
        // 这样，TreeSet就会按照比较器对象中指定的排序规则对元素进行排序。
        TreeSet treeSet1 = new TreeSet(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -1 * o1.compareTo(o2);
            }
        });

        treeSet1.add("jack");
        treeSet1.add("tom");
        treeSet1.add("bob");
        treeSet1.add("alice");

        System.out.println(treeSet1);

    }
}
