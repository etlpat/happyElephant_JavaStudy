package com._06_Annotation;

// 注解：Annotation
//
// (1)概念
//  ①注解(Annotation)，也称元数据(Metadata)，用于修饰和解释包、类、方法、属性、构造器、局部变量等数据信息
//  ②和注释一样，注解不影响程序的逻辑，但注解可以被编译或运行，相当于嵌入在代码中的补充信息
//  ③在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等
//   在JavaEE中注解占据了更重要是角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的冗余代码和XML配置等
//
//
// (2)三个基本注解
//  1.@Override：限定某个方法，是重写父类方法 (该注解只能作用于方法)
//    功能：语法校验。若方法添加了@Override注解，编译器会检查该方法是否真的是重写方法，若不是则报错
//
//  2.@Deprecated：用于表示某个程序元素(类、方法等)已经过时
//    注意：过时不代表不能用，它只是起到一个提醒的功能，可以做到新旧版本的兼容和过度
//
//  3.@SuppressWarnings：抑制(类、方法、语句等)编译器警告，抑制范围和该注解放置的位置相关
//    注意：warning，是警告，不影响程序的编译和运行
//         error，是报错，若不修正程序不能通过
//
//
//
// (3)注解@Override源码
//  源码如下：
//   @Target(ElementType.METHOD)        // 表示@Override只能作用于方法
//   @Retention(RetentionPolicy.SOURCE) // 表示@Override注解只在编译时生效
//   public @interface Override {       // @Override的声明语句
//   }
//  注意事项：
//   1.@interface表示Override是【注解类】
//     （注意：@interface：注解类，interface：接口，二者是不同的类别）
//   2.如上@Target(ElementType.METHOD)，表示@Override只能作用于方法
//     （@Target、@Retention都是注解的注解，称为元注解）


public class Annotation {
    // 3.@SuppressWarnings，抑制了main方法中所有的警告（也可作用于类、属性等）
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        // 1.@Override，表示该方法重写了父类的方法
        new Fly() {
            @Override
            public void fly() {
                System.out.println("I can fly");
            }
        }.fly();


        // 2.@Deprecated注解标注的过时数据，仍然可以使用，只是不推荐使用
        A a = new A();
        System.out.println(a.a1);
        a.func();
    }
}


// 2.@Deprecated，表示该程序元素已过时
@Deprecated
class A {
    @Deprecated
    int a1 = 10;

    @Deprecated
    public void func() {
    }
}


interface Fly {
    public void fly();
}