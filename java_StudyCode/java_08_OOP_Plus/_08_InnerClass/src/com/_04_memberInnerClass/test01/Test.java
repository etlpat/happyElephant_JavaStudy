package com._04_memberInnerClass.test01;

public class Test {
    public static void main(String[] args) {
        // (1)创建Person对象，并测试其成员内部类的使用情况
        Person p1 = new Person("小明", 17, 2000);
        p1.playWithDog();// 小明 没养小狗
        p1.setDog("乐乐", 5);
        p1.playWithDog();
        //小明的小狗是：Dog{name='乐乐', age=5}
        //小狗乐乐 吃骨头
        //小狗乐乐 在睡觉
        //小狗乐乐 寻找主人小明


        // (2)测试成员内部类
        System.out.println("================");
        new Person("小红", 18, 0, "大黄", 18).playWithDog();
        //小红的小狗是：Dog{name='大黄', age=18}
        //小狗大黄 吃骨头
        //小狗大黄 在睡觉
        //小狗大黄 寻找主人小红


        // (3)在外部其他类中创建成员内部类对象
        System.out.println("================");
        Person.Dog dog1 = p1.new Dog("小黑", 3);
        Person.Dog dog2 = p1.getDogInstance("小白", 4);
        Person.Dog dog3 = new Person().new Dog("小黄", 2);
        System.out.println(dog1);// Dog{name='小黑', age=3}
        System.out.println(dog2);// Dog{name='小白', age=4}
        System.out.println(dog3);// Dog{name='小黄', age=2}
        dog1.findMaster();// 小狗小黑 寻找主人小明
        dog2.findMaster();// 小狗小白 寻找主人小明
        dog3.findMaster();// 小狗小黄 寻找主人null
    }
}
