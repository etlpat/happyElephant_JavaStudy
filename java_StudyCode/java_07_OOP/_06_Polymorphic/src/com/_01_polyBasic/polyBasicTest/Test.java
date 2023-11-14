package com._01_polyBasic.polyBasicTest;

// 案例：1.创建食物Food父类，Fish鱼肉类、Bone骨头类作为其子类
//      2.创建Animal动物类，Cat猫类、Dog狗类作为其子类
//      3.创建Master主人类，其中有feed方法，为宠物喂食（猫吃鱼，狗吃骨头）
//      4.在测试类中创建对象，并调用主人的feed方法为宠物喂食

public class Test {
    public static void main(String[] args) {
        Master master = new Master("张三");
        Cat cat = new Cat("小黑");
        Dog dog = new Dog("旺财");
        Fish fish = new Fish("清蒸鱼");
        Bone bone = new Bone("红烧骨头");

        // 非多态方法喂食
        master.feed1(cat, fish);// 张三喂小猫 小黑 吃清蒸鱼
        master.feed1(dog, bone);// 张三喂小狗 旺财 吃红烧骨头

        // 多态方法喂食
        master.feed2(cat, fish);// 张三喂 小黑 吃清蒸鱼
        master.feed2(dog, bone);// 张三喂 旺财 吃红烧骨头
    }
}
