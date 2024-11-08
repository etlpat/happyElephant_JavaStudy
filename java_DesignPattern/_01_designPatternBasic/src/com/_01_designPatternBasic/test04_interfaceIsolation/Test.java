package com._01_designPatternBasic.test04_interfaceIsolation;

// 案例：安全门
//  门1有防水、防火、防盗的功能
//  门2有防火、防盗的功能

public class Test {
    public static void main(String[] args) {
        // 细分接口，讲不用的功能隔离开，减少冗余

        new Door1().check();
        new Door2().check();
    }
}
