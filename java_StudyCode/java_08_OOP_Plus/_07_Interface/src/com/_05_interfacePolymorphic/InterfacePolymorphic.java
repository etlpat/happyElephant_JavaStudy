// interface polymorphic： 接口的多态


// 接口的多态
//
// (1)概念
//  接口类型的引用，指向实现接口的类的对象
//
// (2)特点
//  接口多态，可以类比对象多态的向上转型
//  如：InterfaceA a = new B(); （B类实现了接口InterfaceA）
//      1.引用变量a的编译类型为InterfaceA，因此a只能调用InterfaceA中存在的成员
//      2.a的运行类型为B，a引用调用方法时，调用的是B类中实现的方法。且该方法与B类动态绑定
//      3.由于属性没有多态的性质，a引用调用属性时，调用的是接口InterfaceA中的public、static、final属性
//
//
//
// (3)注意事项
//  1.应用场景：
//     多态参数：形参为接口类型的引用，实参为实现接口的类的对象
//     多态数组：用接口类型的数组，存放实现接口的对象元素
//
//  2.接口多态传递
//  e.g.若接口IB继承了IA，C类实现了接口IB
//      可以用IA类型的引用指向C类对象
//  （和Object-A-B-C，A类引用可以指向C类对象一个道理）




package com._05_interfacePolymorphic;

public class InterfacePolymorphic {
    public static void main(String[] args) {
        // (1)用接口类引用，接收实现接口的类的对象
        UsbInterface usbInterface = new Phone("诺基亚", 1145);


        // (2)接口多态访问成员的规则，和向上转型的规则相同
        //  1.方法：按运行类型调用，且动态绑定
        usbInterface.start();// Phone诺基亚 插入USB接口，开始运行
        usbInterface.end();// Phone诺基亚 拔出USB接口，结束运行
        //  2.属性：按编译类型调用，无动态绑定
        System.out.println(usbInterface.USB_ID);// 111111


        // (3)想实现类中新增的成员，需要向下转型
        ((Phone) usbInterface).call();// Phone诺基亚 正在拨号中...

        if (usbInterface instanceof Phone) {// 若usbInterface的运行类型是Phone
            System.out.println(((Phone) usbInterface).USB_ID);// 1145
        }
    }
}
