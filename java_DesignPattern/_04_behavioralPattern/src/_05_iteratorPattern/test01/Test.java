package _05_iteratorPattern.test01;

// 案例：
//  定义一个可以存储学生对象的容器对象,
//  将通历该容器的功能交由迭代器实现。

import _05_iteratorPattern.test01.Iterator.AbstractIterator;
import _05_iteratorPattern.test01.container.StudentList;

public class Test {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        studentList.add(new Student("张三", 18));
        studentList.add(new Student("李四", 25));
        studentList.add(new Student("王五", 36));
        studentList.add(new Student("赵六", 42));

        // 获取迭代器，遍历列表
        AbstractIterator iterator = studentList.getIterator();
        while (iterator.hasNext()) {// 若存在下一个对象
            // 指向并返回下一个对象
            Student student = (Student) iterator.next();
            System.out.println(student);
        }
    }
}
