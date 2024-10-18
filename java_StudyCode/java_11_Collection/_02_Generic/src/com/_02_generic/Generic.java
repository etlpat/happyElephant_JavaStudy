package com._02_generic;

import java.util.ArrayList;


// 泛型
//
//
// 1.泛型介绍
//  ①泛型<=>广泛的类型，如范型E，既可以代表Integer类型，也可以代表String、Person等...
//      （泛型E具体代表哪种类型，由程序员使用时所决定）
//  ②泛型又称参数化类型，是jdk5出现的新特性，用于解决数据类型的安全性问题。
//  ③在类声明或实例化时，只要指定好 泛型所需要的具体类型 即可。
//  ④Java泛型可以保证：若程序在编译时没有发出警告，运行时就不会产生ClassCastException（类型转换异常）。
//      同时，泛型使代码更加简洁、健壮。
//  ⑤泛型的使用方法：在类声明时，可以通过一个（泛型）标识，表示类中某个属性的类型/方法的返回类型/参数类型...
//      【在类声明时定义泛型；之后就可以在类内，将这些泛型作为数据类型使用】
//
//
//
// 2.泛型语法
//  (1)泛型的定义，语法如下：
//  class C<E, T,...> {// 在类名旁边，定义泛型（接口/方法也可以）
//      // 在类内，可以将这些泛型作为数据类型使用
//      E element1;
//      T element2;
//
//      public C(E element1, T element2) {
//          this.element1 = element1;
//          this.element2 = element2;
//      }
//
//      // 其它方法...
//      // （这些方法均可以将泛型作为数据类型使用）
//  }
//
//  (2)泛型的使用，语法如下：
//  C<String, Integer> c1 = new C<String, Integer>("abc", 123);
//  C<Character, Boolean> c2 = new C<Character, Boolean>('A', true);
//  // 在类实例化（new 对象）时，可以在<>中指明泛型E的实际类型，
//  // 在【编译期间】，这些泛型就会被转化为对应的类型。
//
//
//
// 3.泛型细节【重点】
//  (1)泛型必须为【引用类型】。
//      例如：ArrayList<E>、HashMap<K,V>，其中E、K、V必须都是引用类型。
//      ArrayList<Integer>是正确的；ArrayList<int>是错误的。
//
//  (2)在指定泛型的具体类型后，可以传入该类型或其子类类型。
//      （父类引用可以指向子类对象）
//
//  (3)定义了泛型的类，若不在实例化时指明其具体类型，则【泛型默认为Object】。
//      例如：ArrayList list = new ArrayList();// 泛型默认为Object
//      等价于：ArrayList<Object> list = new ArrayList<>();
//
//  (4)泛型的简化形式
//      实例化对象时，new后边<>中的泛型定义可以省略。
//      （编译器会根据前边的类型，自动推断后边的类型）
//      以下两种定义方式【等价】，推荐使用后一种：
//          ArrayList<String> list = new ArrayList<String>();
//          ArrayList<String> list = new ArrayList<>();
//


public class Generic {
    public static void main(String[] args) {
        // (1)泛型测试
        // Person类中定义了泛型，因此在实例化时，需要指定这些泛型对应的类型
        Person<Integer, Character, String> person = new Person<Integer, Character, String>(1, 'A', "张三");

        System.out.println(person.getE());// 1
        System.out.println(person.getT());// A
        System.out.println(person.getQ());// 张三

        System.out.println(person.getAllElementClass());// 运行类型：e=Integer, t=Character, q=String


        // (2)泛型必须定义为引用类型
        ArrayList<Integer> arrayList1 = new ArrayList<>();// 正确
//        ArrayList<int> arrayList2 = new ArrayList<>();// 报错


        // (3)在指定泛型的具体类型后，可以传入该类型或其子类类型。
        ArrayList<Person> arrayList3 = new ArrayList<Person>();
        arrayList3.add(new Person());
        arrayList3.add(new Son());// 为泛型传入子类对象


        // (4)泛型的简写
        ArrayList<String> strings4 = new ArrayList<String>();
        ArrayList<String> strings5 = new ArrayList<>();// 后边的类型可以省略


        // (5)若不指明泛型的具体类型，默认为Object
        ArrayList arrayList6 = new ArrayList();// 定价于下面
        ArrayList<Object> arrayList7 = new ArrayList<>();
    }
}
