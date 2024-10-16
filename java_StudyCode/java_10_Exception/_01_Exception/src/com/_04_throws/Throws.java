package com._04_throws;


import java.io.FileInputStream;
import java.io.IOException;// 异常处理 -- throws
//
//
// 1.基本介绍
//  ①如果一个方法中的语句可能产生某种异常，但是不能立刻确定如何处理这些异常，
//    此时可以用throws将异常抛出该方法，表明该方法不对这些异常进行处理，而是由该方法的调用者负责处理。
//
//  ②在方法的声明中，可以用throws语句声明要抛出的异常对象列表，
//    throws后面的异常类型，可以是该方法中产生的异常类，及其父类。
//
//
//
// 2.语法
//  public void func() throws 异常类1,异常类2,... {
//      // 可能出现异常的代码块...
//  }
//
//
//
// 3.throws细节【重点】
//  ①对于编译时异常，必须在程序中显式处理。如用try-catch或throws处理。（编译器会检测出编译时异常，并红线报错）
//  ②对于运行时异常，可以不对其进行处理。若我们不处理，系统会默认使用throws Exception的方式将其抛出。
//  ③子类重写父类的方法时，抛出的异常的类型，要么与父类抛出的异常一致，要么是父类抛出的异常的子类。
//  ④throws和try-catch是处理异常的两种方法，使用时选择其一即可。
//
//


import java.io.FileNotFoundException;

public class Throws {

    // (1)使用try-catch语句处理编译时异常
    public void func1() {
        try {
            FileInputStream fis = new FileInputStream("d://xxx.txt");// 爆出编译时异常
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // (2)使用throws抛出编译时异常
    public void func2() throws IOException {// 将异常抛出给调用者处理
        FileInputStream fis = new FileInputStream("d://xxx.txt");// 爆出编译时异常
    }


    public void func3() {
        try {
            func2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
