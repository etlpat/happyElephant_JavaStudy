package com.test8;

public class A {
    private String name;

    public A() {
    }

    public A(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("外部类A，name=" + getName());
    }


    // 成员内部类
    public class B {
        private final String name;

        public B(String name) {
            this.name = name;
        }

        public void show() {
            System.out.println("成员内部类B，name=" + name);
        }
    }


    // 测试局部内部类
    public void showC(String name) {
        class C {
            private final String name;

            public C(String name) {
                this.name = name;
            }

            public void show() {
                System.out.println("局部内部类C，name=" + name);
            }
        }

        C c = new C(name);
        c.show();
    }
}
