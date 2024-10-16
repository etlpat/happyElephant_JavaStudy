package com._01_collection._02_iterator.test01;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("小黑", 5));
        dogs.add(new Dog("小白", 8));
        dogs.add(new Dog("斑点", 3));

        System.out.println(dogs);
        System.out.println("===============");

        // 迭代器遍历列表
        Iterator<Dog> iterator = dogs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("===============");

        // for-each遍历
        for (Dog d : dogs) {
            System.out.println(d);
        }


    }
}
