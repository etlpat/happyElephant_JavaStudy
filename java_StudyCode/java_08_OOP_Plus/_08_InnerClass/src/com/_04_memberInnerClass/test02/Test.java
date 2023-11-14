package com._04_memberInnerClass.test02;

// 案例：问下面代码输出什么结果？

public class Test {
    public Test() {
        Inner s1 = new Inner(10);
        Inner s2 = new Inner();
        System.out.println(s1.a + ", " + s2.a);
    }

    public class Inner {
        public int a = 5;

        public Inner() {
        }

        public Inner(int a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {
        Test t = new Test();// 10, 5
        Inner r = t.new Inner(8);
        System.out.println(r.a);// 8
    }
}
