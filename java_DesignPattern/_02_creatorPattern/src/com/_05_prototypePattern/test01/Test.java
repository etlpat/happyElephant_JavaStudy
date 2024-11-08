package com._05_prototypePattern.test01;

// 案例：
//  用原型模式生成“三好学生”奖状（浅克隆）。
//      同一学校的“三好学生”奖状除了获奖人姓名不同,其他都相同,
//      可以使用原型模式复制多个“三好学生”奖状出来,然后在修改奖状上的名字即可。

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 创建原型对象
        MeritCertificate meritCertificate = new MeritCertificate();
        System.out.println("原型的哈希码：" + meritCertificate.hashCode());
        System.out.println("===========================");


        // 获取克隆奖状对象1，将该对象改为张三的奖状
        MeritCertificate certificate1 = meritCertificate.clone();
        certificate1.setName("张三");

        System.out.println(certificate1);
        certificate1.show();
        System.out.println("克隆对象1的哈希码：" + certificate1.hashCode()
                + "，是否相等？" + (certificate1 == meritCertificate));
        System.out.println("===========================");


        // 获取克隆奖状对象2，将该对象改为李四的奖状
        MeritCertificate certificate2 = meritCertificate.clone();
        certificate2.setName("李四");

        System.out.println(certificate2);
        certificate2.show();
        System.out.println("克隆对象2的哈希码：" + certificate2.hashCode()
                + "，是否相等？" + (certificate2 == meritCertificate));

    }
}
