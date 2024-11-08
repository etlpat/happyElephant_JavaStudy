package _05_iteratorPattern.test01.Iterator;

import _05_iteratorPattern.test01.Student;
import _05_iteratorPattern.test01.container.StudentList;

public class StudentListIterator implements AbstractIterator {
    StudentList studentList;

    // 游标初始指向头节点（不包含数据）
    int index = -1;

    public StudentListIterator(StudentList studentList) {
        this.studentList = studentList;
    }


    // 判断是否有下一个元素
    @Override
    public boolean hasNext() {
        if (index + 1 <= studentList.size() - 1) {
            return true;
        }
        return false;
    }

    // 指向并返回下一个元素
    @Override
    public Student next() {
        return studentList.get(++index);
    }
}
