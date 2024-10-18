package com._03_userDefinedGeneric;


// 自定义泛型
//
//
// 1.语法
// (1)自定义泛型【类】
//  class 类名<E, T,...> {// 注意：类名后的泛型标识符，一般为单个大写字母
//      // （在类内，泛型可以作为数据类型使用）
//      // 成员...
//  }
//
// (2)自定义泛型【接口】
//  interface 接口名<E, T,...> {
//      // 成员...
//  }
//
// (3)自定义泛型【方法】
//  访问修饰符 <E, T,...> 返回类型 方法名(参数列表) {
//      // 方法体...
//  }
//
// (4)自定义泛型方法的调用
//  对象名.方法名(值1, 值2);
//  // 注意：自定义泛型方法的调用，和普通方法的调用，语法完全一致。
//  //      泛型方法在调用时，不需要用<>指明泛型类型，编译器会自动推断。
//
//
//
// 2.注意事项
//  ①普通成员可以使用泛型（属性、方法）。
//  ②使用泛型的数组，不能初始化。
//  ③静态方法中，不能使用泛型。
//      （因为静态方法在类加载时创建，而泛型是在类实例化时确定）
//  ④泛型类的具体类型，是在类实例化时确定的。
//      若实例化时，没有指定泛型的类型，则默认为Object。
//
//  ⑤【泛型接口的类型，是在继承接口或实现接口时确定的】。
//      泛型接口不指定类型，默认也为Object。
//
//  ⑥【泛型方法的类型，在调用该方法时自动确定】。
//      泛型方法在调用时，不需要用<>指明泛型类型，编译器会自动推断。
//  ⑦泛型方法，内部既可以使用自己定义的泛型，也可以使用类声明的泛型。
//      （泛型=广泛的类型，完全可以把泛型看作普通数据类型使用）
//


public class UserDefinedGeneric implements RealUsb {
    public static void main(String[] args) {
        UserDefinedGeneric udg = new UserDefinedGeneric();

        // 调用泛型方法func
        // 泛型方法在调用时，不需要用<>指明泛型类型，编译器会自动推断。
        udg.func("Hello World", 123);
    }


    // 由于RealUsb接口在继承Usb时，已经确定了Usb中的泛型
    // 因此，这里的泛型U、R就是RealUsb中规定的Integer、Double
    @Override
    public Integer getU() {
        return 123;
    }

    @Override
    public Double getR() {
        return 123.456;
    }


    // 泛型方法
    public <T, E> void func(T t, E e) {
        System.out.println(t + " , " + e);
    }
}
