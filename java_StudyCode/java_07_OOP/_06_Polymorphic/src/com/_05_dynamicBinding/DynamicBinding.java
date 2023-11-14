// dynamic binding：动态绑定


// java的动态绑定机制【重点】
// 规则：
//  1.当调用对象【方法】时：该方法会和该对象的内存地址/运行类型绑定
//  2.当调用对象【属性】时：属性没有动态绑定机制，在哪里声明，就在哪里使用 （根据作用域调用属性）
//
// 解释：（以Object-A-B为例）
//  ①.方法的动态绑定：若以运行类型B调用方法func
//      func会和B类型进行动态绑定，方法func及其内部调用的全部方法都按照B类的方法来调用。
//  ②.属性没有动态绑定机制，其按定义域访问：
//      在哪个类中调用属性，得到的就是哪个类的属性。若本类中没有就按照继承规则来查找属性。



package com._05_dynamicBinding;

public class DynamicBinding {
    public static void main(String[] args) {
        A a = new B();
        // 以下方法和其运行类型B类动态绑定
        System.out.println(a.sum1());// 30
        System.out.println(a.sum2());// 20
    }
}
