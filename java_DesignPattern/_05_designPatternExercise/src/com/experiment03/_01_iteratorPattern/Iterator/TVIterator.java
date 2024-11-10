package com.experiment03._01_iteratorPattern.Iterator;

import java.util.ArrayList;

public class TVIterator implements AbstractIterator {
    ArrayList<String> tvStation;

    int index = -1;

    public TVIterator(ArrayList<String> tvStation) {
        this.tvStation = tvStation;
    }

    // 若下一个有值
    @Override
    public boolean hasNext() {
        return (index + 1 < tvStation.size());
    }

    // 指向并返回下一个
    @Override
    public String next() {
        return tvStation.get(++index);
    }

    // 若上一个有值
    @Override
    public boolean hasPrevious() {
        return (index - 1 >= 0);
    }

    // 指向并返回上一个
    @Override
    public String previous() {
        return tvStation.get(--index);
    }
}
