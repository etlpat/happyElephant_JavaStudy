package com.test07;

public class Test {
    public static void main(String[] args) {
        // 测试1
        MyList myList1 = new MyList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        MyIterator myIterator1 = myList1.myIterator();

        while (myIterator1.hasNext()) {
            System.out.print(myIterator1.next() + " ");
        }
        System.out.println();


        // 测试2
        MyList myList2 = new MyList(new String[]{"张三", "李四", "王五"});
        MyIterator myIterator2 = myList2.myIterator();

        while (myIterator2.hasNext()) {
            System.out.print(myIterator2.next() + " ");
        }
        System.out.println();
    }
}
