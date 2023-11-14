package com._02_localInnerClass;

public class Outer {
    private int outerNum = 100;
    private int count = 10;

    private void outerFunc() {
        System.out.println("outerFunc方法被调用");
    }


    // 包含局部内部类的方法1
    public void testLocalInnerClass1() {
        System.out.println("testLocalInnerClass1方法被调用");

        // 在方法内，创建局部内部类
        class Inner {
            private int innerNum = 200;

            public void innerFunc() {
                // (1)局部内部类可以直接访问外部类的全部成员
                System.out.println("outerNum=" + outerNum);
                outerFunc();
            }
        }

        // (2)外部类中，想要访问局部内部类的成员，需要创建对象（前提是在其作用域中）
        Inner inner = new Inner();
        System.out.println("innerNum=" + inner.innerNum);
        inner.innerFunc();
    }


    // 包含局部内部类的方法2
    public void testLocalInnerClass2() {
        System.out.println("testLocalInnerClass2方法被调用");

        // (3)局部内部类和局部变量一样，不能用访问修饰符、static修饰，可以用final修饰
        //public class inner1 {}// 报错
        //static class inner2 {}// 报错
        final class inner3 {
        }
        //class inner4 extends inner3 {}// 报错，final方法不可继承

        // (4)局部内部类的作用域是其所在的方法/代码块内，出了作用域就不存在了
        //Inner inner = new Inner();// 报错
    }


    // 包含局部内部类的方法3
    public void testLocalInnerClass3() {
        System.out.println("testLocalInnerClass3方法被调用");

        // 局部内部类
        class method3Inner {
            public int count = 20;

            // (5)若局部内部类和外部类成员重名，访问遵循就近原则
            private void printCount() {
                System.out.println(count);// 20
                // 通过以下格式，可在局部内部类中访问外部类的重名成员
                System.out.println(Outer.this.count);// 10
            }
        }

        method3Inner inner = new method3Inner();

        System.out.println(count);// 10
        System.out.println(inner.count);// 20
        inner.printCount();
    }
}
