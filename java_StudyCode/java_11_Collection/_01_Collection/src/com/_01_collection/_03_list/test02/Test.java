package com._01_collection._03_list.test02;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("红楼梦", "曹雪芹", 100));
        books.add(new Book("西游记", "吴承恩", 10));
        books.add(new Book("天龙八部", "金庸", 999));
        books.add(new Book("水浒传", "施耐庵", 9));
        books.add(new Book("三国演义", "罗贯中", 80));
        books.add(new Book("西游记", "吴承恩", 10));

        System.out.println(books);


        // (1)按照价格从小到大排序(冒泡)
        for (int i = 0; i < books.size() - 1; i++) {// size个元素，排序size-1趟
            for (int j = 0; j < books.size() - i - 1; j++) {// 每趟，从0遍历到这趟最后一个的前一个位置
                if (books.get(j).getPrice() > books.get(j + 1).getPrice()) {
                    books.add(j, books.remove(j + 1));// 交换j和j+1位的元素（每趟把最大的换到最后）
                }
            }
        }
        System.out.println(books);


        // (2)使用三种方式遍历
        // 迭代器
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().getPrice() + " ");
        }
        System.out.println();

        // for-each
        for (Book book : books) {
            System.out.print(book.getPrice() + " ");
        }
        System.out.println();

        // 普通for
        for (int i = 0; i < books.size(); i++) {
            System.out.print(books.get(i).getPrice() + " ");
        }
        System.out.println();
    }
}
