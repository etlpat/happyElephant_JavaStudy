package com._02_MetaAnnotation;

// 元注解：meta-annotation
//
// (1)概念
//  元注解是注解的注解
//
// (2)常见的元注解
//  @Target：指定注解可以修饰的程序元素
//  @Retention：指定注解可以保留多长时间 （三种保留时间：①SOURCE:仅在编译器中生效/②CLASS:在.class中也生效/③RUNTIME在运行时仍然生效）
//  @Documented：指定该注解是否会在javadoc体现
//  @Inherited：子类会继承父类的注解


public class MetaAnnotation {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
    }
}
