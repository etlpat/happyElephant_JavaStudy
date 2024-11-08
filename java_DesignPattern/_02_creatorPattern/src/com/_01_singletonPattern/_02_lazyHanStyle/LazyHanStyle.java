package com._01_singletonPattern._02_lazyHanStyle;

public class LazyHanStyle {
    // (1)创建静态的单例对象，初始为null
    private static LazyHanStyle instance = null;

    // (2)私有化构造器，防止外界创建其它对象
    private LazyHanStyle() {
    }

    // (3)提供get方法
    public static LazyHanStyle getInstance() {
        // 首次使用对象时，创建单例对象（线程不安全）
        if (instance == null) {
            instance = new LazyHanStyle();
        }
        return instance;
    }
}
