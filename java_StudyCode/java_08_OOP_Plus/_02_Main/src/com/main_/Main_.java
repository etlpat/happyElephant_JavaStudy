// main方法
//
// (1)语法
//  public static void main(String[] args){}
//
//
// (2)细节
//  1.main方法由java虚拟机调用
//    main方法是程序执行的入口
//
//  2.main方法访问权限必须为public
//      原因：JVM的存储位置和main所在的类不在同一个目录，因此main必须为public才能被访问到
//
//  3.main方法必须为static静态方法
//      原因：JVM调用main时不必创建对象，直接通过类名访问main方法，因此main方法必须是static的
//      注意：由于main方法是静态的，只能直接调用本类的静态成员；若想调用本类的非静态成员，必须创建对象调用
//
//  4.main方法的参数为字符串数组 String[] args
//      用法：用户可以在运行java程序时，通过命令行传递参数给程序
//      传参语法：java 类名 参数1 参数2 参数3...
//             （程序会把这些参数放入args数组）
//      注意：数组名args是arguments的缩写，我们也可以用其他名称代替args
//
//
// (3)注意事项
//  1.除了用命令行，idea中也可以给main方法传参数
//    操作：Run按键->Edit->设置Program arguments（项目参数）




package com.main_;

public class Main_ {
    public static void main(String[] args) {
        // (1)main是静态方法，可以直接调用类中静态成员
        System.out.println(Main_.num2);// 200
        System.out.println(getNum2());// 200

        //System.out.println(num1);// 报错
        //System.out.println(getNum1());// 报错


        // (2)main静态方法无this关键字，不能直接调用非静态成员
        //  想调用非静态成员，必须通过创建对象然后调用
        Main_ m = new Main_();
        System.out.println(m.num1);// 100
        System.out.println(m.getNum1());// 100
    }


    private int num1 = 100;

    private static int num2 = 200;

    public int getNum1() {
        return num1;
    }

    public static int getNum2() {
        return num2;
    }
}
