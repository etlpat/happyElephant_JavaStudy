package com._03_tryCatchFinally;


// 异常处理 -- try_catch_finally
//
//
// 1.语法
//
// (1)try-catch-finally（可省略）
//  try {
//      // 可能出现异常的代码块...
//  } catch (Exception e) {
//      // 捕获到异常
//      //  1.当try中语句发生异常时，立即中断执行，并进入catch代码块
//      //  2.系统将异常封装成Exception对象e，传递给catch
//      //  3.得到异常对象后，程序员自己对其进行处理
//      // 注意：若try中无异常，catch代码块不执行
//  } finally {
//      // 不管try中是否有异常发生，最后都要执行finally代码块
//      // （因此，通常将释放资源的代码，放在finally中）
//  }
//
//
// (2)try-多个catch
//  try {
//      // 可能出现异常的代码块...
//  } catch (NullPointerException e) {
//      // 注意：catch中的异常对象，子类在前，父类在后（范围小的在前，范围大的在后）。
//      //      发生异常时，只会匹配一个catch语句
//      // 代码块1...
//  } catch (RuntimeException e) {
//      // 代码块2...
//  } catch (Exception e) {
//      // 代码块3...
//  }
//
//
//
// 2.try-catch细节
//  (1)【如果try中发生了异常，则异常发生后面的代码不会执行，直接进入catch块】。
//  (2)如果异常没有发生，则顺序执行try中语句，不会进入catch块。
//  (3)【可以有多个catch语句，捕获不同的异常】。要求子类在前，父类在后（捕获范围小的在前，范围大的在后）。
//      发生异常时，只会匹配一个catch。
//


public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            int a = 1 / 0;
            System.out.println("hello world");// 不会执行该语句（上一条语句发生异常，直接跳转到catch块中）
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("finally块执行");
        }
        System.out.println("**************************************");


        try {
//            int a = 1 / 0;
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("catch 1 捕获异常");
            System.out.println(e);
        } catch (RuntimeException e) {
            System.out.println("catch 2 捕获异常");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("catch 3 捕获异常");
            System.out.println(e);
        }
        System.out.println("**************************************");


        // 尝试多条catch语句，令其范围大的在前，报错
//        try {
//        } catch (Exception e) {
//        } catch (RuntimeException e) {// 报错
//        }

    }
}
