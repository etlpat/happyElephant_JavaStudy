package com._01_singletonPattern._01_hungHanStyle;

// 饿汉式
// （类加载时创建，因此需要将单例对象设置为static的）

public class HungHanStyle {
    // (1)创建静态的单例对象
    private static HungHanStyle instance = new HungHanStyle();

     // (2)私有化构造器，防止外界创建其它对象
    private HungHanStyle() {
    }

    // (3)提供get方法
    public static HungHanStyle getInstance() {
        return instance;
    }
}
