package com._03_Enum;

public enum SeasonEnum {
    // 1.枚举对象的定义必须写在最前面
    SPRING("春天", "温暖"),// 常量间用逗号间隔
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷"),
    OTHER;// 若调用无参构造器，括号可省略

    private String name;
    private String describe;


    // 2.构造器必须是private
    private SeasonEnum(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }

    private SeasonEnum() {
    }


    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
