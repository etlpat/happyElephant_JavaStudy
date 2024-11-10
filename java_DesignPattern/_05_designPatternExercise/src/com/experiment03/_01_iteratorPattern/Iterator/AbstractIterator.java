package com.experiment03._01_iteratorPattern.Iterator;

public interface AbstractIterator {
    public boolean hasNext();

    public String next();

    public boolean hasPrevious();

    public String previous();
}
