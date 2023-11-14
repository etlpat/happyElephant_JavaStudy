// access modifier：访问修饰符


// 访问修饰符
//
// java提供四种访问修饰符：
//  1.public(公开)：   (类内【可】访问，同包的类【可】访问，不同包的类【可】访问，同包子类【可】访问，不同包子类【可】访问)
//  2.protected(保护)：(类内【可】访问，同包的类【可】访问，不同包的类【不可】访问，同包子类【可】访问，不同包子类【可】访问)
//  3.没有修饰符(默认)： (类内【可】访问，同包的类【可】访问，不同包的类【不可】访问，同包子类【可】访问，不同包子类【不可】访问)
//  4.private(私有)：  (类内【可】访问，同包的类【不可】访问，不同包的类【不可】访问，同包子类【不可】访问，不同包子类【不可】访问)
//
//
// 记忆技巧：
//  public：所有其他类都可访问
//  protected：子类优先，子类都可访问
//  默认：同包优先，同包的类都可访问
//  private：自身以外的类都不可访问
//
//
// 访问权限大小：
//  public > protected > 默认 > private
//
//
// 注意：
//  1.类的属性、方法，都必须添加这四种权限
//  2.只有默认和public才能修饰类，也遵循以上访问权限的规则




package com.accessModifier;

public class AccessModifier {
    // 四种访问修饰符
    public int n1 = 1;
    protected int n2 = 2;
    int n3 = 3;
    private int n4 = 4;


    public static void main(String[] args) {
        AccessModifier am = new AccessModifier();

        // 四种访问权限在本类中都可使用
        System.out.println(am.n1);
        System.out.println(am.n2);
        System.out.println(am.n3);
        System.out.println(am.n4);
        Cat cat = new Cat();
    }
}




// 只有默认和public能修饰类：
class Cat {};
//protected Dog {};// 报错
//private Chicken {};// 报错