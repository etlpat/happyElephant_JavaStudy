package com._01_Exception;

// 异常
//
// (1)异常的体系
//  java.lang.Throwable
//            ├─Error（系统级别的严重错误）
//            └─Exception（异常：编写程序时的错误）
//                      ├─RuntimeException（运行时异常(编译时不会检查)）
//                      └─其它异常（编译时异常(编译器会报错)）
//
//
// (2)处理异常的方式
// 1.try-catch-finally语句
//  语法：
//      try {
//          //可能异常的语句块...
//      } catch (异常类型1 e1) {
//          //处理异常e1...
//      } catch (异常类型2 e2) {
//          //处理异常e2...
//      } finally {// 可以不写
//          //无论是否发生异常，最终一定执行...
//      }
//  功能：
//      当try中语句遇到异常时，try这个代码块中断运行。
//      之后程序会跳到catch代码块中，对捕获到的异常对象进行处理
//      （若有多个catch，则异常会被【首个】类型符合(接收本类或子类)的catch捕获）
//      无论是否发生异常，最后都会执行finally代码块中的内容
//
//
// 2.throw关键字
//  语法：throw 异常对象;
//  功能：手动抛出异常对象
//  异常的抛出：当异常对象被抛出，程序会立即停止执行当前方法，（若未被直接捕获）则将异常对象抛向调用该方法的方法
//           当一个异常被抛出，它会被逐层向上传递，直到它被某个方法的try-catch语句块捕获。
//           若异常对象没有被手动捕获，则最后会到最上层JVM中被处理（整个程序停止运行，并打印异常信息）
//
//
// 3.throws关键字
//  语法：
//      修饰符 返回类型 方法名(形参列表) throws 异常类名1,异常类名2,...{
//          //方法体...
//      }
//
//  功能：将方法内的异常抛给上一层方法来处理
//       一个方法中若抛出异常，可以直接对其处理；也可以不处理，而是把异常向上传递，交给上一层处理
//  注意：若是main方法通过throws抛出异常，则该异常对象会被交给最上层的JVM虚拟机来处理（JVM虚拟机会直接打印异常信息）


public class Exception_ {
    public static void main(String[] args) {
        // (1)程序中的隐式异常抛出（非法操作导致异常自动抛出）
        int[] arr = new int[10];
        //System.out.println(arr[10]);// 没被catch捕获，直接传给JVM，之后JVM打印该异常

        try {
            System.out.println(arr[10]);// 程序遇到运行时异常，会自动抛出该异常
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println(e1);// java.lang.ArrayIndexOutOfBoundsException: 10
        } finally {
            System.out.println("emmm");
        }


        // (2)程序中显式(手动)抛出异常
        try {
            // 通过throw手动抛出异常
            throw new RuntimeException("这是运行时异常");
        } catch (RuntimeException e) {
            System.out.println(e);// java.lang.RuntimeException: 这是运行时异常
        }


        // (3)throws将异常抛给上层处理
        try {
            func();// 该函数内部用throws将异常抛给外部的main方法处理
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);// java.lang.ArrayIndexOutOfBoundsException: 4
        }
    }


    static void func() throws ArrayIndexOutOfBoundsException {
        int[] arr = new int[3];
        arr[4] = 0;
        System.out.println("1111");
    }
}
