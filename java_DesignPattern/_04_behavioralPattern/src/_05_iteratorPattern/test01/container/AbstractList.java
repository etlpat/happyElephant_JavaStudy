package _05_iteratorPattern.test01.container;

import _05_iteratorPattern.test01.Iterator.AbstractIterator;

// 抽象集合

public interface AbstractList {
    public void add(Object o);

    public void remove(Object o);

    public int size();

    public Object get(int index);

    public AbstractIterator getIterator();
}
