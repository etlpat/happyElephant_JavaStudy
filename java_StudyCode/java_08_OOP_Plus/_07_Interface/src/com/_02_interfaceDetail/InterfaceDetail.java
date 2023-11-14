// 接口细节
//
//
// 【1】接口的成员详解(属性、方法)
//  1.接口中的【属性】
//    接口中，所有属性默认为public、static、final的，且只能为public、static、final的
//    e.g.接口中：int a = 10; 等价于 public static final int a = 10;
//
//  2.接口中的【方法】
//    ①接口中，所有方法的权限默认为public，且只能为public（包括static和default方法）
//    ②接口中，方法默认是abstract的(无方法体)（除了static和default方法）
//    ③JDK8后，接口中可以包含static静态方法(有方法体)
//    ④JDK8后，接口中可以包含默认的方法实现(有方法体)，但是必须加default关键字
//    e.g.接口中：void func(); 等价于 public abstract void func();
//
//  3.接口中【不能包含代码块】，否则报错
//
//=======================================================================
//
//
// (2)接口不能被实例化
//
// (3)普通类实现接口，必须把接口中的所有抽象方法都实现才能实例化
//    不过，抽象类实现接口，不用实现所有抽象方法
//
// (4)类实现接口的方法的【快捷键】
//    快捷键：选中类->Alt+Enter->Implement methods
//
// (5)接口中成员的权限，必须为public（即使不写，默认也为public）
//    接口本身的权限，和类一样，只能是public或默认
//
// (6)由于接口的属性只能是public static final的，且接口中不能存在代码块
//    因此，属性必须在声明的同时赋值
//
// (7)建议通过接口名，直接访问接口的属性和静态方法
//    接口名.静态属性;  接口名.静态方法(...);
//
//
// 【8】一个子类只能继承一个父类，但是可以同时实现多个接口（类和接口间是实现关系）
//       语法：public class A implements IA, IB, IC {...}
//     注意：子类可以继承父类的同时，实现多个接口
//       语法：public class B extends A implements IA, IB, IC{...}
//
// 【9】一个接口不能继承其他的类，但是可以继承多个接口（接口和接口间是继承关系）
//       语法：public interface IF0 extends IF1, IF2,... {...}




package com._02_interfaceDetail;

public class InterfaceDetail {
    public static void main(String[] args) {
        // 1.接口不能实例化
        //new Interface01();// 报错


        // 2.实例化实现接口的类A
        A a = new A();
        a.func1();// A类实现Interface01接口func1
        a.func2();// A类实现Interface01接口func2
        a.func4();// Interface01接口的fun4方法的默认实现
        System.out.println("============");

        // 3.可以直接通过接口调用其静态属性
        System.out.println(Interface01.num1);// 10
        System.out.println(Interface01.num2);// 20
        Interface01.func3();// Interface01接口的静态方法func3
    }
}
