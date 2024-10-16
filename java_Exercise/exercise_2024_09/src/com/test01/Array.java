package com.test01;


import java.util.Arrays;
import java.util.Random;


public class Array {
    public static void main(String[] args) {

        // (1)创建数组
        int[] arr1 = new int[10];
        // 注意：数组也是对象，被创建在堆区中。
        //  【堆区中数据初始均为“0”】：
        //      若为数字，初始为0；
        //      若为字符，初始为0对于的Ascii；
        //      若为boolean，初始为false；
        //      若为对象（字符串），初始为null；

        // 为数组元素赋值
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i + 1;
        }

        // 遍历数组
        System.out.print("{");
        for (int i = 0; i < arr1.length - 1; i++) {
            System.out.print(arr1[i] + ", ");
        }
        System.out.println(arr1[arr1.length - 1] + "}");


        // (2)for-each循环遍历数组
        // 注意：【for-each只能遍历数组和实现Iterable接口的对象】
        for (int tmp : arr1) {// 每次循环拿出数组中的下一个元素（迭代器）
            System.out.print(tmp + " ");
        }
        System.out.println();


        // (3)打印数组的值
        System.out.println(Arrays.toString(arr1));


        // (4)数组的创建和初始化
        int[] arr2 = {2, 4, 6, 8, 10};// 创建的同时初始化
        for (int tmp : arr2) {
            System.out.print(tmp + " ");
        }
        System.out.println();


        // (5)数组元素排序
        Random random = new Random();// 获取随机数对象
        int[] arr3 = new int[200];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = random.nextInt(101);// 为数组赋[0,101)的随机int值
        }
        System.out.println(Arrays.toString(arr3));
        // 方法：Arrays.sort(arr);对数组进行排序
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));


        // (6)二维数组
        // 注意：java没有多维数组，只有一维数组。二维数组的本质是数组的数组（对象数组）。
        //      二维数组的每个元素是一个引用，指向每行数组（对象）
        int[][] arr4 = new int[3][5];
        int tmp = 0;
        for (int i = 0; i < arr4.length; i++) {// 遍历二维数组（每个元素是一行）
            for (int j = 0; j < arr4[i].length; j++) {// 遍历每行数组的每列
                arr4[i][j] = ++tmp;
            }
        }

        // 打印二维数组中的值
        System.out.print("{");
        for (int i = 0; i < arr4.length; i++) {
            System.out.print("{");
            for (int j = 0; j < arr4[i].length - 1; j++) {
                System.out.print(arr4[i][j] + ", ");
            }
            System.out.print(arr4[i][arr4[i].length - 1] + "}");
            if (i != arr4.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");

        // 快速打印二维数组
        System.out.println(Arrays.deepToString(arr4));


        // (7)不规则数组
        // 由于二维数组本质是数组数组（对象数组），因此每行元素的个数可以不同
        int[][] arr5 = {{1}, {2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(arr5));
        // 创建不规则数组
        int[][] arr6 = new int[3][];// 行必须规定，列可以不规定
        arr6[0] = new int[]{7};
        arr6[1] = new int[]{8, 9};
        arr6[2] = new int[]{0, 1, 2};
        System.out.println(Arrays.deepToString(arr6));

    }
}
