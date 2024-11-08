package com._06_builderPattern.test02;

//  建造者模式除了上面的用途外,在开发中还有一个常用的使用方式,就是当一个类构造器需要传入很多参数时,
//  如果创建这个类的实例,代码可读性会非常差,而且很容易引入错误,此时就可以利用建造者模式进行重构。

public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone.PhoneBuilder()
                .setCpu("英特尔")
                .setScreen("三星")
                .setMemory("金士顿")
                .setMainBoard("华硕")
                .buildPhone();

        System.out.println(phone);
    }
}
