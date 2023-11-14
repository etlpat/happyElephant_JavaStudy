package com._06_override;

public class Dog extends Animal {

    public void eat() {// 重写父类eat()
        System.out.println("Dog吃骨头");
    }

    public void sleep(String name) {// 重载父类sleep()
        System.out.println("Dog" + name + "睡觉");
    }

    public String m1() {// 重写父类m1
        // 重写时，（子类方法的返回类型）可以是（父类方法返回类型）的子类
        return null;
    }

    public void m2() {// 重写父类m2
        //重写时，子类方法的访问权限必须>=父类
    }

    public void func() {
        // 方法的重写并非真正的覆盖，父类方法仍存在内存中
        this.eat();
        super.eat();
    }
}
