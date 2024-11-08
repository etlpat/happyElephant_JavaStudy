package com._05_prototypePattern.test02;

// 案例：
//  用原型模式生成“三好学生”奖状（深克隆）。
//      同一学校的“三好学生”奖状除了获奖人Student不同,其他都相同,
//      可以使用原型模式复制多个“三好学生”奖状出来,然后在修改奖状上的Student对象即可。

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 克隆原型对象
        MeritCertificate certificate1 = new MeritCertificate(new Student(114, "张三", 18));
        MeritCertificate certificate2 = certificate1.clone();


        // 测试深克隆
        certificate1.show();
        certificate2.show();

        System.out.println(certificate1 == certificate2);// false
        System.out.println(certificate1.getStudent() == certificate2.getStudent());// false
        System.out.println(certificate1.hashCode() + " " + certificate2.hashCode());
        System.out.println(certificate1.getStudent().hashCode() + " " + certificate2.getStudent().hashCode());


        // 修改克隆对象
        certificate2.setStudent(new Student(514, "李四", 25));
        certificate2.show();

    }
}
