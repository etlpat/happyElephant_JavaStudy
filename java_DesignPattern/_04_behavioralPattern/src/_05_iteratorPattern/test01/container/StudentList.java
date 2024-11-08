package _05_iteratorPattern.test01.container;

import _05_iteratorPattern.test01.Iterator.AbstractIterator;
import _05_iteratorPattern.test01.Iterator.StudentListIterator;
import _05_iteratorPattern.test01.Student;

import java.util.ArrayList;

// 具体集合

public class StudentList implements AbstractList {
    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public void add(Object o) {
        students.add((Student) o);
    }

    @Override
    public void remove(Object o) {
        students.remove((Student) o);
    }

    @Override
    public int size() {
        return students.size();
    }

    @Override
    public Student get(int index) {
        return students.get(index);
    }

    // 获取该对象的迭代器
    @Override
    public AbstractIterator getIterator() {
        return new StudentListIterator(this);
    }
}
