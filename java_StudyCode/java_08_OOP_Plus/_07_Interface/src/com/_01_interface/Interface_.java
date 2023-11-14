// interface：接口


// 接口
//
// (1)基本介绍
//  接口就是给出一些没有实现的方法，将其封装到一起，
//  到某个类要使用的时候，再具体实现这些方法
//
//
//
// (2)语法
//【1】定义接口语法
// （一个接口可以继承多个其他接口）
//  [访问修饰符] interface 接口名 [extends 接口1, 接口2,...] {
//      //属性 (public static final的)
//      //方法 (1.抽象方法/ 2.默认实现方法/ 3.静态方法)
//  }
//
//
// 【2】interface中的成员(属性、方法)定义语法
//  [1]属性
//  接口中，所有属性默认为public、static、final的，且只能为public、static、final的
//      语法：int a = 10;
//      等价于：public static final int a = 10;
//      等价于：public int a = 10;
//
//  [2]方法
//  注意：接口中，所有方法的权限默认为public，且只能是public的
//  ①抽象方法(无方法体)：接口中，方法默认都是abstract的（除了static和default方法）
//      语法：void func();
//      等价于：public abstract void func();
//  ②默认实现的方法(有方法体)：JDK8后，接口中可以包含默认的方法实现，但必须带default关键字
//      语法：default public void func() {...}
//      等价于：default void func() {...}
//  ③静态方法(有方法体)：JDK8后，接口中可以有静态方法
//      语法：public static void func() {...}
//      等价于：static void func() {...}
//
//  [3]接口中不能包含代码块
//
//
// 3.实现接口语法
// （类可以实现多个接口，子类可以继承父类的同时实现多个接口）
//  [访问修饰符] class 类名 [extends 父类名] implements 接口名1, 接口名2,... {
//      //新增属性
//      //新增方法
//      //必须实现接口的抽象方法
//  }
//
//
//
//
// (3)注意事项
//  1.在JDK7以及更低的版本，接口中的所有方法必须都没有方法体
//    在JDK8以及之后的版本，接口中可以有静态方法、默认实现的方法，也就是说接口中可以有方法的具体实现
//
//  2.接口中所有成员的权限必须为public的，否则报错
//    原因：接口可以看作是一种完全抽象的类，它是一种规范和协议，因此成员权限被规定必须为public
//
//  3.接口的default方法
//  default方法，是接口中已经实现完毕方法体的方法。若实现该接口的类不重写default方法，则默认按照接口中的实现来执行
//
//  4.接口中的静态成员
//  接口的静态成员和类的静态成员有相同的性质，都是和接口/类同一级别，并在接口/类加载时初始化
//  建议通过接口名来调用接口中的静态成员
//
//  5.接口和接口间可以是继承关系：一个接口可以继承多个接口
//    类和接口间是实现关系：一个类可以实现多个接口