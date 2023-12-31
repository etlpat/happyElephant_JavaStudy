// 代码块细节
//
// (1)静态与非静态代码块：
//  ①静态代码块：会在加载类信息时被执行 （一个类只会调用一次）
//      静态代码块，只能调用静态成员
//  ②非静态代码块：会在每次创建新对象时被执行 （在调用构造器之前执行）
//      非静态代码块，可以调用静态/非静态成员
//
//
//
// (2)补充：静态成员
//  静态成员：静态属性、静态方法、静态代码块
//  特点：①静态成员是类级别的成员，它们属于类本身，而不属于某个对象实例
//       ②静态成员都是在类加载时生成，随着类一同消亡
//       ③静态成员只能调用静态成员，不能调用非静态成员
//
//
//
// (3)类什么时候加载
//  简单来讲：类在第一次使用类时被加载
//  ①创建对象实例时
//  ②创建子类实例，会先加载父类
//  ③使用类的静态成员时
//  注意：静态成员就是类级别的，加载类信息的同时会初始化静态成员
//
//
//
// (4)构造器知识点补充【重点】
//  构造器，在最前面隐含了 ①super() 和 ②调用普通代码块
//  实际执行中：先调用父类构造器，再调用子类普通代码块，最后调用子类构造器
//  e.g.
//  class A {
//      public A() {
//          super();
//          //调用普通代码块
//          System.out,println("A类构造器调用");
//      }
//  }
//
//
//
// (5)首次创建子类对象时的【内存布局】 <重难点>
//  【1】加载类信息到方法区，(同时初始化静态成员)（仅一次）
//      1.先加载父类信息，同时初始化父类静态成员（初始化父类静态属性、加载父类静态方法、调用父类静态代码块）
//      2.后加载子类信息，同时初始化子类静态成员（初始化子类静态属性、加载子类静态方法、调用子类静态代码块）
//  【2】在堆区中分配子类对象的内存空间(一次性分配好)
//      此时，所有属性的值都为0（堆区数据默认为0）
//  【3】初始化对象的非静态属性
//      1.先初始化父类对象的属性
//        ①为父类属性赋默认值，同时调用父类的非静态代码块
//        ②调用父类构造器
//      2.后初始化子类对象新增属性
//        ①为子类属性赋默认值，同时调用子类的非静态代码块
//        ②调用子类构造器
//  【4】将堆区对象地址返回给引用变量
//
// 注意事项：
//  1.“静态属性的初始化”和“调用静态代码块”的优先级相同，二者按照定义的顺序(从上到下)调用
//  2.“普通属性赋默认值”和“调用普通代码块”的优先级相同，二者也按照定义的顺序(从上到下)调用




package com._02_codeBlockDetail;

public class CodeBlockDetail {
    public static void main(String[] args) {
        // (1)“静态属性初始化”和“静态代码块调用”优先级相同
        new A1();
//        static属性num1被赋默认值
//        A1类static代码块被执行
//        static属性num2被赋默认值
//        A1类构造器调用


        System.out.println("=================");
        // (2)“普通属性赋初值”和“静态代码块调用”优先级相同
        new A2();
//        属性num1被赋默认值
//        A2类代码块被执行
//        属性num2被赋默认值
//        A2类构造器调用


        System.out.println("=================");
        // (3)内存布局：
        // 1.加载类信息、初始化静态成员（先父后子）
        // 2.一次性开辟好堆区空间
        // 3.先初始化父类对象（①赋默认值、执行代码块  ②执行构造方法）
        //   后初始化子类对象（①赋默认值、执行代码块  ②执行构造方法）
        new Sub();
//        静态属性b1被赋初值  (加载父类信息，初始化父类静态成员)
//        Base类静态代码块
//        静态属性b2被赋初值
//        静态属性s1被赋初值  (加载子类信息，初始化子类静态成员)
//        Sub类静态代码块
//        静态属性s2被赋初值
//        普通属性b3被赋初值  (初始化父类对象属性)
//        Base类非静态代码块
//        普通属性b4被赋初值
//        Base类构造器
//        普通属性s3被赋初值  (初始化子类对象属性)
//        Sub类非静态代码块
//        普通属性s4被赋初值
//        Sub类构造器


        System.out.println("=================");
        // 类信息只加载一次（静态成员只初始化一次）
        new Sub();
//        普通属性b3被赋初值
//        Base类非静态代码块
//        普通属性b4被赋初值
//        Base类构造器
//        普通属性s3被赋初值
//        Sub类非静态代码块
//        普通属性s4被赋初值
//        Sub类构造器
    }
}
