package com._02_generic.test02;

import java.util.Objects;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    // 将MyDate的compareTo方法实现，达到封装的目的
    @Override
    public int compareTo(MyDate o) {
        // 先按年排，年不同则返回年
        int sortByYear = year - o.getYear();
        if (sortByYear != 0) {
            return sortByYear;
        }
        // 若year相同，month不同，则按month排
        int sortByMonth = month - o.getMonth();
        if (sortByMonth != 0) {
            return sortByMonth;
        }
        // 若month相同，则按day排
        return day - o.getDay();
    }
}
