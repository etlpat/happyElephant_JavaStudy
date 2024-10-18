package com._01_genericBasic;

import java.util.ArrayList;


// 泛型基础
//
// 1.不使用泛型会遇到的问题
//  ①不能对集合元素的数据类型进行约束（不安全）。
//  ②若不用泛型，遍历集合时获取到的对象默认是Object类型，
//      需要类型转换才能使用。若集合中数据量较大，对效率有影响。
//
//
// 2.泛型的好处
//  ①编译时，检测添加元素的类型，提高了安全性。
//  ②减少了类型转换的次数，提高效率。
//      不使用泛型：Dog ——(加入)——> Object ——(取出)——> Dog
//      使用泛型：Dog ——(加入)——> Dog ——(取出)——> Dog
//  ③不再提示编译警告
//


public class GenericBasic {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<Dog>();

        dogs.add(new Dog("旺财", 18));
        dogs.add(new Dog("来福", 8));
        dogs.add(new Dog("黑狼", 5));


        // 向泛型约束的dogs添加其它类型的元素，会报错
//        dogs.add("张三");// 报错


        // ArrayList使用泛型，for-each获取到的元素可以直接为Dog类型，而不用Object类型
        for (Dog d : dogs) {
            System.out.println(d);
        }

    }
}
