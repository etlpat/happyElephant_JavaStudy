package com.test07;

public class MyIterator {
    private MyList myList;
    private int index;

    public MyIterator(MyList myList) {
        this.myList = myList;
        index = -1;// index初始指向不包含元素的头节点
    }

    // 判断下一个是否为空
    public boolean hasNext() {
        if (index + 1 >= myList.getList().length) {
            return false;
        }
        return myList.getList()[index + 1] != null;
    }

    // 指向并返回下一个元素
    public Object next() {
        return myList.getList()[++index];
    }
}
