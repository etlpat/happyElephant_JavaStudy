// Package：包


// 包
//
// 1.概念
//  包：文件夹
//  打包类：即创建不同的包(文件夹)来保存.java文件
//  包存放路径(规范)：项目文件.src.com.公司名.项目名.业务板块名.xxx包
//
// 2.打包
//  语法：package 包名;
//  功能：必须放在.java文件的最上面，作用是声明当前类所在的包
//
// 3.包的作用：
//  1.当类很多时，用包更方便管理
//  2.不同包中可以存放同名的类
//  3.控制访问范围
//
//
// 4.调用包中的类：
//  法1：import导入包中的类，再直接调用类
//  法2：调用类时，写出类的路径
//
//
// 5.常用的包：
//  java.lang.*; // lan包(基本包)，会默认自动引入，不需要手动引入
//  java.util.*; // util包(系统提供的工具包)，工具类
//  java.net.*;  // 网络包，网络开发
//  java.awt.*;  // java界面开发，GUI



// 导包
//
// 语法：
//  import 包.类;  // 导入包中的类
//  import 包.*;   // 导入包中的全部类
//
// 注意：
//  import语句必须再类之前定义，可以多条，无序





import com.package1.Hello;

import java.util.Arrays;


public class Package {
    public static void main(String[] args) {
        // 1.自定义包的使用
        // (1)先导入，后直接调用包中的类
        Hello hello = new Hello();
        System.out.println(hello);// com.package1.Hello@1b6d3586

        // (2)用路径调用包中的类
        // (同名类只能导入一次，之后想用其他同名类只能通过路径调用)
        com.package2.Hello hello2 = new com.package2.Hello();// com.package2.Hello@4554617c
        System.out.println(hello2);



        // 2.lang包是基本包，会自动被引入
        // 如下：System类和Math类都属于lang包，可以直接使用
        System.out.println(Math.PI);// 3.141592653589793



        // 3.导入Arrays类，对数组排序
        int arr[] = {5, 7, 3, 9, 1};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");// 1 3 5 7 9
        }
    }
}
