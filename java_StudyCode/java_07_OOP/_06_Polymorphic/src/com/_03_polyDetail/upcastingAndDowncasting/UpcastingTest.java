// upcasting：向上转型

// 【向上转型】
//  多态的向上转型，即用父类引用接收子类对象
//
// (1)本质
//  父类的引用指向子对象(堆区空间)
//
// (2)语法
//  父类类型 引用名 = new 子类类型(参数列表);
//  如：Animal animal = new Dog();
//
//
// (3)规则【重点】
//  1.编译类型看“=”左边，运行类型看“=”右边
//  2.由于编译类型是父类Animal，引用变量animal【只能执行Animal类允许的操作】
//      说明：只允许调用父类中拥有的成员(按照父类查找关系)，不能调用子类中的新增成员
//  3.由于运行类型是子类Dog，程序执行时实际调用的是子类对象(重写后)的成员
//
//  e.g.(以此为例：Animal animal = new Dog();)
//      由于animal是Animal类的引用变量，因此只能执行Animal类允许的操作
//      animal指向的是Dog对象的堆区空间，因此实际调用的是Dog对象的成员
//
//
// (4)注意事项
//  1.上述规则中，规则②在编译阶段由编译器完成，规则③在运行阶段由JVM完成，二者不矛盾


package com._03_polyDetail.upcastingAndDowncasting;

public class UpcastingTest {
    public static void main(String[] args) {
        // 向上转型：用父类引用接收子类对象
        Object obj = new Dog();// 不一定用直接父类

        Animal animal = new Dog("小白", 123);

        // (1)animal是Animal类的引用变量，因此只能执行Animal类允许的操作
        //System.out.println(animal.id);// 报错，无法解析符号
        animal.cry();// Dog在叫唤...
        //animal.sleep();// 报错，无法访问私有方法
        //animal.eatBone();// 报错，无法解析符号

        // (2)animal指向的是Dog对象(的堆区空间)，实际调用的是Dog对象的成员
        System.out.println("===============");
        animal.enjoy();
        // Dog吃骨头...
        // Dog睡觉...
        // Dog小白“123” 很享受


        // (3)用Dog本类对象测试方法
        System.out.println("===============");
        Dog dog = new Dog("小黑", 456);
        System.out.println(dog.id);// 456
        dog.cry();// Dog在叫唤...
        dog.sleep();// Dog睡觉...
        dog.eatBone();// Dog吃骨头...
    }
}
