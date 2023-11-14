package com.test06;

/**
 * 案例6：
 * 1.创建Person类{name,sex,age}，方法有play()
 * 2.Student类继承Person，定义新属性stu_id，重写play，定义方法study()
 * 3.Teacher类继承Person，定义新属性work_age，重写play，定义方法teach()
 */

public class Test {
    public static void main(String[] args) {
        Person[] arr = new Person[3];
        arr[0] = new Teacher("张三", "男", 55, 27);
        arr[1] = new Student("小明", "男", 14, 114514);
        arr[2] = new Student("小红", "女", 13, 1919810);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("====================");
            System.out.println(arr[i]);
            arr[i].play();
            if (arr[i] instanceof Student) {
                ((Student) arr[i]).study();
            } else if (arr[i] instanceof Teacher) {
                ((Teacher) arr[i]).teach();
            }
        }

        // 输出结果如下：
//        ====================
//        Teacher{name='张三', sex='男', age=55, work_age=27}
//        Teacher张三 爱玩象棋
//        Teacher张三 在教书
//        ====================
//        Student{name='小明', sex='男', age=14, stu_id=114514}
//        Student小明 爱玩足球
//        Student小明 在学习
//        ====================
//        Student{name='小红', sex='女', age=13, stu_id=1919810}
//        Student小红 爱玩足球
//        Student小红 在学习
    }
}
