package com.experiment02._03_facadePattern.subSystem;

public class Memory {
    public void check() {
        // 有0.1的概率出错
        if (Math.random() < 0.1) {
            throw new RuntimeException(this.getClass().getSimpleName() + "运行出错");
        }

        System.out.println("内存 -- 自检");
    }
}
