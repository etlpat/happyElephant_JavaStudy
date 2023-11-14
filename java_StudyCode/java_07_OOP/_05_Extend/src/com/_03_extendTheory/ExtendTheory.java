// extend theory：继承的本质


// 继承的本质【重点】
//
// 1.子类创建时的内存布局：
//  (1)加载类信息到方法区(仅一次)
//    类加载的顺序：从父类到子类依次加载(追溯到Object)
//  (2)在堆区开辟内存空间
//    这块内存中又包括(从父到子)多个类的空间，分别存放各个类中非继承(新增)的属性
//  (3)将堆区地址返回给栈区的引用变量
//
//
//
//
// 2.子类成员的查找关系
// 规则：就近原则，子类优先
// 案例：假设有C类 (C类继承关系：Object-A-B-C)
//  以下步骤是通过查找关系来确定子类C的name属性：
//  (1)首先查看子类C中是否有新增的name属性
//  (2)若子类C中有，则该name就是子类C的name属性
//  (3)若子类C中没有，就看父类B中有没有(若有，则该name就是子类C的name属性)
//  (4)若父类B中没有，就一直向上追溯，直到Object类
//
//
// 注意事项：
//  [1]当父类子类中出现同名属性：(就近原则，子类优先)
//  e.g.若A、B、C类中都有name属性，C类的堆区空间中会存在3个name属性
//      C类的name属性，是子类C中新增的name，而父类A、B中的name属性会被隐藏
//
//  [2]属性的查找关系与访问修饰符无关
//  e.g.若A、B中name都是public，而C中name是private
//      C类的name属性，仍是C中新增的name，与权限无关
//
//  [3]属性和方法都遵循以上的查找关系
//      区别在于：属性是在堆区空间中查找；而方法是在方法区中加载的类信息中查找




package com._03_extendTheory;

public class ExtendTheory {
    public static void main(String[] args) {
        Son son = new Son();
        // 创建以上子类对象时的内存布局：
        //
        // 1.【将类信息加载到方法区】
        //   加载类(顺序由前到后)：Object、GrandPa、Father、Son
        //   顺序：先加载父类信息，再加载子类信息
        //
        // 2.【在堆区开辟空间】 Son类的空间中，包含Son类及其全部父类的所有成员变量
        //   这块堆区空间又可分为：(从上到下表示父类到子类的空间)
        //   1.GrandPa的空间，存放name、hobby、password (仅存放当前类中定义的属性，不包含继承下来的属性)
        //   2.Father的空间，存放name、age、password
        //   3.Son的空间，存放name
        //   (这里先不讨论Object的成员变量)
        //
        // 3.【将堆区的地址返回给栈区的引用变量】


        // 通过查找关系确定Son类的属性
        // 查找关系遵循：就近原则
        System.out.println(son.name);// 儿子
        System.out.println(son.age);// 42
        System.out.println(son.hobby);// 旅游
        //System.out.println(son.password);// 报错，private权限


        System.out.println(son.getName());// 爸爸
        System.out.println(son.getHobby());// 旅游
        System.out.println(son.getPassword());// 666666
    }
}


class GrandPa {
    public String name = "爷爷";
    public String hobby = "旅游";
    public String password = "123456";
}

class Father extends GrandPa {
    public String name = "爸爸";
    public int age = 42;
    private String password = "666666";

    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getHobby() {
        return hobby;
    }
}

class Son extends Father {
    public String name = "儿子";
}
