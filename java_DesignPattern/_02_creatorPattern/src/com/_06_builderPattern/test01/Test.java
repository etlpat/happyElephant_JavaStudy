package com._06_builderPattern.test01;

// 案例：创建共享单车
//  生产单行车是一个复杂的过程,它包含了车架,车座等组件的生产。
//      而车架又有碳纤维,铝合金等材质的,车座有橡胶,真皮等材质。
//      对于自行车的生产就可以使用建造者模式。
//  这里Bike是产品,包含车架,车座等组件;Builder是抽象建造者,
//  MobikeBuilder和OfoBuilder是具体的建造者;Director是指挥者。
//

public class Test {
    public static void main(String[] args) {
        // 创建指挥者对象
        Director director = new Director();

        // 使用director组装摩拜单车
        // (指挥者调用摩拜单车的构建者对象)
        director.setBuilder(new MobikeBuilder());
        Bike moBike = director.constructBike();
        System.out.println(moBike);
        System.out.println("===================");

        // 使用director组装ofo单车
        // (指挥者调用ofo单车的构建者对象)
        director.setBuilder(new OfoBuilder());
        Bike ofoBike = director.constructBike();
        System.out.println(ofoBike);

    }
}
