package com._03_userDefinedGeneric.test01;

// 问：下面代码是否正确,如果有错误,修改正确,并说明输出什么?
//
//  class Apple<T,R,M>{
//      public<E> void fly(E e){
//          System.out.println(e.getClass().getSimpleName());
//      }
//      public void eat(U u) {}// 错误
//      public void run(M m) {}
//  }
//
//  class Dog {}
//
//  // 下面代码输出什么?
//  Apple<String, Integer, Double> apple= new Apple<>();
//  apple.fly(10);
//  apple.fly(new Dog());
//


public class Test {
    public static void main(String[] args) {
        Apple<String, Integer, Double> apple = new Apple<>();
        apple.fly(10);// Integer
        apple.fly(new Dog());// Dog
    }
}
