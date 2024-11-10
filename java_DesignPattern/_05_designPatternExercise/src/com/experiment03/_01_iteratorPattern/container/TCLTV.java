package com.experiment03._01_iteratorPattern.container;

import com.experiment03._01_iteratorPattern.Iterator.AbstractIterator;
import com.experiment03._01_iteratorPattern.Iterator.TVIterator;

import java.util.ArrayList;

public class TCLTV implements TV {
    ArrayList<String> tvStation = new ArrayList<>();

    public TCLTV() {
        tvStation.add("湖南卫视");
        tvStation.add("北京卫视");
        tvStation.add("上海卫视");
        tvStation.add("广州卫视");
        tvStation.add("陕西卫视");
    }


    @Override
    public void add(String str) {
        tvStation.add(str);
    }

    @Override
    public void remove(String str) {
        tvStation.remove(str);
    }

    @Override
    public AbstractIterator iterator() {
        return new TVIterator(tvStation);
    }
}
