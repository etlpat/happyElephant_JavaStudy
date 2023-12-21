package com._04_EnumMethod;

public enum Season {
    // 定义枚举对象
    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷");

    private String name;
    private String describe;

    Season(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }
}
