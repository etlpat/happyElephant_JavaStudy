// equal：相等的

// equals方法（属于Object类）
//
// (0)补充：== 运算符
//  功能；判断两值是否相等
//   ① 如果“==”判断基本类型，判断两变量的值是否相等
//   ② 如果“==”判断引用类型，判断存放的地址是否相等 (引用变量存放的值就是对象地址)
//
//
// (1)equals方法：
//  Objet类的equals源码：
//  public boolean equals(Object obj) {
//      return (this == obj);
//  }
//  功能：Object中的equals方法【默认判断两对象的地址是否相等】
//      子类中往往重写此方法，改为判断内容是否相等
//      （例如String、Integer等类都将equals方法重写为判断值是否相等）
//
//
//
//  e.g.如下是String中重写的equals源码：
//  public boolean equals(Object anObject) {
//      if (this == anObject) {// 1.若地址相等，返回true
//          return true;
//      }
//      if (anObject instanceof String) {// 2.若形参的运行类型为String，判断字符串内容
//          String anotherString = (String)anObject;
//          int n = value.length;
//          if (n == anotherString.value.length) {
//              char v1[] = value;
//              char v2[] = anotherString.value;
//              int i = 0;
//              while (n-- != 0) {// 3.循环判断每个字符是否相等
//                  if (v1[i] != v2[i])
//                      return false;
//                  i++;
//              }
//              return true;// 4.若两字符串内容相等，返回true
//          }
//      }
//      return false;
//  }




// 知识点补充：IDEA中查看源码
//  查看官方/自己的源码：
//  ① 快捷键：ctrl + b
//  ② 右键指定方法 -> Go To -> Declaration or Usages（声明或用法）




package com._01_equals;

public class Equals_ {
    public static void main(String[] args) {
        B b1 = new B();
        B b2 = b1;
        A a1 = b1;
        B b3 = new B();

        // (1) == 比较运算符
        System.out.println(b1 == b2);// true
        System.out.println(b1 == a1);// true（父类引用指向子类对象，a1、b1类型不同，但存放的地址相同）
        System.out.println(b1 == b3);// false
        // 引用变量a1、b1、b2、b3的值是对象的地址，“==”判断值是否相等


        // (2) equals()方法
        System.out.println("==========");
        // Object中的equals方法默认判断对象地址是否相等（源码中用==判断）
        System.out.println(b1.equals(a1));// true
        System.out.println(b1.equals(b3));// false
        // String中equals方法被改写为判断字符串内容是否相等（ctrl + b 查看源码）
        System.out.println("abc".equals("hello"));// false
        System.out.println("abc".equals("abc"));// true

        Integer i1 = new Integer(200);
        Integer i2 = new Integer(200);
        System.out.println(i1 == i2);// false，地址不相等
        System.out.println(i1.equals(i2));// true（Integer类中将equals重写为判断值是否相等）

    }
}
