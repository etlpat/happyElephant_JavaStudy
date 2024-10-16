package com._01_exceptionBasic;


// 异常处理入门案例如下：
public class ExceptionBasic {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;

//        int res = num1 / num2;
//        System.out.println("程序继续运行");

        // 当num1/num2，除数为零，抛出除零异常，程序崩溃退出。
        // 这好吗？这不好。只因为一个异常，导致整个系统崩溃，是不妥当的。
        // java设计者通过异常处理机制来解决该问题，从而保证代码的健壮性。


        try {
            // 添加try-catch语句快捷键：选中代码 -> ctrl + alt + t
            int res = num1 / num2;
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("程序继续运行");
    }
}
