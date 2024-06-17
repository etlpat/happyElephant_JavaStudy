package com._02_UserDefinedExceptions;

// 自定义异常类
//
// (1)如何自定义异常？
//  自定义异常类：
//      1.创建一个异常类，该类继承Exception类或其子类
//       （若是运行时异常，建议继承RuntimeException类；若是编译时异常，建议直接继承Exception类）
//      2.为自定义异常类添加构造器
//
//  抛出自定义异常：
//      语法：throw new 自定义异常类名(实参列表);
//      功能：当前方法停止运行，将异常对象抛给上层方法，直到异常对象被try-catch语句捕获
//
//
//
// (2)编译时异常和运行时异常
//      编译时异常：只要可能抛出，编译器就会报错，只有用throws层层上传，最后传入try-catch语句或JVM，报错才会消失
//      运行时异常：编译器不会主动报错，运行时才会报错
//
//      使用场景：一个异常是编译时异常/运行时异常，完全有程序员决定
//              若该异常比较严重/容易犯错，则建议定义成编译时异常。只要出现，编译器就会报红线，会有强烈的提示
//              反之，所一个异常不容易犯、少见，则定义成运行时异常，编写程序时不会报红线


public class UserDefinedExceptions {
    public static void main(String[] args) {
        boolean flag = false;
        try {
            System.out.println("*****");
            new Person("张三", 55);
            System.out.println("*****");
            new Person("李四", -10);// 抛出异常，try中语句直接中断运行，跳到catch代码块
            System.out.println("#####");
        } catch (AgeIllegalRuntimeException ageException) {
            flag = true;
            System.out.println(ageException);// com._02_UserDefinedExceptions.AgeIllegalRuntimeException: 异常：年龄超出[0,130]的范围，你输入的年龄：-10
        } catch (Exception e) {
            flag = true;
            System.out.println(e);
        } finally {
            if (flag) {
                System.out.println("报异常了！！！");
            } else {
                System.out.println("没报异常");
            }
        }
    }
}
