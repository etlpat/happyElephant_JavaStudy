package com.test07;

public class MyList {
    private Object[] list;

    public MyList(Object[] list) {
        this.list = list;
    }

    public MyList() {
        list = new Object[10];
    }

    public MyIterator myIterator() {
        return new MyIterator(this);
    }

    public Object[] getList() {
        return list;
    }

    public void setList(Object[] list) {
        this.list = list;
    }
}
