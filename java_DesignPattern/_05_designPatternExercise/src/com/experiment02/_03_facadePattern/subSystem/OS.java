package com.experiment02._03_facadePattern.subSystem;

public class OS {
    public void load() {
        // 有0.1的概率出错
        if (Math.random() < 0.1) {
            throw new RuntimeException(this.getClass().getSimpleName() + "运行出错");
        }

        System.out.println("操作系统 -- 载入");
    }
}
