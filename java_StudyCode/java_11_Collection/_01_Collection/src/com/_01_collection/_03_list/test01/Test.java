package com._01_collection._03_list.test01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            list.add("" + i);
        }

        System.out.println(list);

        list.add(1, "张三");
        System.out.println(list.get(4));
        list.remove(5);
        list.set(6, "七");

        System.out.println(list);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
    }
}
