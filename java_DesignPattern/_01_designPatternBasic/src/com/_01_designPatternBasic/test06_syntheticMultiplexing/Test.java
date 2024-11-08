package com._01_designPatternBasic.test06_syntheticMultiplexing;

// 案例：汽车分类管理程序
//  汽车按“动力源”划分可分为汽油汽车、电动汽车等;
//  按“颜色”划分可分为白色汽车、黑色汽车和红色汽车等。
//  如果同时考虑这两种分类,其组合就很多。
//

public class Test {
    public static void main(String[] args) {
        Car car = new Car(new Red(), new Kerosene());
        car.show();

        // 若是使用继承关系，那么会有白色汽油车/红色汽油车/白色煤油车/红色煤油车
        // 合成复用原则，有关联先关联，再考虑继承
    }
}
