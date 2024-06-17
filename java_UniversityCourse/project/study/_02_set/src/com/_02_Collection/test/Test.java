package com._02_Collection.test;

// 案例：遍历展示集合中的电影对象

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Collection<Movie> moviesList = new ArrayList<>();
        moviesList.add(new Movie("三国演义", 25));
        moviesList.add(new Movie("肖申克的救赎", 36));
        moviesList.add(new Movie("水浒传", 66));

        // 迭代器遍历
        Iterator<Movie> it = moviesList.iterator();
        int i = 1;
        while (it.hasNext()) {
            System.out.println("第" + i + "部：" + it.next());
            i++;
        }
        System.out.println("===============================");

        // 增强for遍历
        i = 1;
        for (Movie movie : moviesList) {
            System.out.println("第" + i + "部：" + movie);
            i++;
        }

    }
}
