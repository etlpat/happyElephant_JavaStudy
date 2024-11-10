package com.experiment03._01_iteratorPattern.container;

import com.experiment03._01_iteratorPattern.Iterator.AbstractIterator;

public interface TV {
    public void add(String str);

    public void remove(String str);

    public AbstractIterator iterator();
}
