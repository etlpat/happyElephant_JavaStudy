package com.test4;

public class A {
    public String name = "AAA";

    public void AShow() {
        class B {
            public String name = "BBB";

            public void BShow() {
                System.out.println("BShow:");
                System.out.println(A.this.name);
                System.out.println(name);
            }
        }

        B b = new B();
        System.out.println("AShow:");
        System.out.println(name);
        System.out.println(b.name);
        b.BShow();
    }
}
