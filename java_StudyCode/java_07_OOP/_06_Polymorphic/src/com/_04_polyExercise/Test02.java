package com._04_polyExercise;

// 问：下列代码输出结果是什么

public class Test02 {
    public static void main(String[] args) {
        Sub1 s1 = new Sub1();
        System.out.println(s1.n);// 20
        s1.display();// 20

        Base b = s1;//（子类对象赋给父类不用强转，向上转型）
        System.out.println(b == s1);// true（hashCode相等）
        System.out.println(b.n);// 10（属性不具备多态性，调用编译类型的属性）
        b.display();// 20（b的运行类型是Sub1，调用Sub1中新增的成员）

        Sub2 s2 = new Sub2();
        System.out.println(s2.n);// 30
        s2.display();// 10
    }
}


class Base {
    int n = 10;
    public void display() {
        System.out.println(this.n);
    }
}


class Sub1 extends Base {
    int n = 20;
    public void display() {
        System.out.println(this.n);
    }
}

class Sub2 extends Base {
    int n = 30;
}