package com._04_genericWildcardCharacter;

import java.util.ArrayList;
import java.util.List;


// 泛型的通配符
//
// 1.用于接收泛型的通配符：?
//  【?】系列的通配符，用于限制【形参】所接收到的泛型的范围。
//  <?>:可以接收任意类型的泛型。
//  <? extends A>:可以接收A类泛型及其子类（包括间接子类）。
//  <? super A>:可以接收A类泛型及其父类（包括间接父类）。
//
//  注意：以上这些通配符，都用于方法的形参。详情见下面例子。
//


public class GenericWildcardCharacter {
    public static void main(String[] args) {
        GenericWildcardCharacter gwc = new GenericWildcardCharacter();
        List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();
        List<C> listC = new ArrayList<>();


        // (1)<?>通配符，接收任意泛型
        gwc.func1(listA);// √
        gwc.func1(listB);// √
        gwc.func1(listC);// √

        // (2)<? extends B>通配符，接收B及其子类的泛型
//        gwc.func2(listA);// ×
        gwc.func2(listB);// √
        gwc.func2(listC);// √

        // (3)<? super B>通配符，接收B及其父类的泛型
        gwc.func3(listA);// √
        gwc.func3(listB);// √
//        gwc.func3(listC);// ×

    }


    // (1)形参通配符为<?>，表示接收任意类型泛型
    public void func1(List<?> list) {
    }


    // (2)形参通配符为<? extends B>，表示接收B及其子类的泛型
    public void func2(List<? extends B> list) {
    }


    // (3)形参通配符为t<? super B>，表示接收B及其父类的泛型
    public void func3(List<? super B> list) {
    }
}
