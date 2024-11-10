package com.experiment03._01_iteratorPattern.container;

import com.experiment03._01_iteratorPattern.Iterator.AbstractIterator;
import com.experiment03._01_iteratorPattern.Iterator.TVIterator;

import java.util.ArrayList;

public class SkyworthTV implements TV {
    ArrayList<String> tvStation = new ArrayList<>();

    public SkyworthTV() {
        tvStation.add("CCTV-1");
        tvStation.add("CCTV-2");
        tvStation.add("CCTV-3");
        tvStation.add("CCTV-4");
        tvStation.add("CCTV-5");
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
