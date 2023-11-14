package com._01_sequenceList.service;

import com._01_sequenceList.domain.House;

/**
 * HouseService
 * 该类中有存放House信息的顺序表，及其crud（增删改查）
 */

public class HouseService {
    private int maxSize = 100;
    private House[] houseArr;
    private int houseNum;// 房屋信息个数


    public HouseService() {
        houseArr = new House[maxSize];
        houseNum = 0;
    }

    public HouseService(int maxSize) {
        this.maxSize = maxSize;
        houseArr = new House[this.maxSize];
        houseNum = 0;
    }

    public int getHouseNum() {
        return houseNum;
    }

    public House[] getHouseArr() {
        return houseArr;
    }


    // 在表尾增加房屋信息
    public boolean addHouse(House house) {
        if (houseNum == houseArr.length) {
            return false;
        }
        houseArr[houseNum++] = house;
        return true;
    }

    // 按id查找并返回元素
    public int getHouseIndex(int id) {
        for (int i = 0; i < houseNum; i++) {
            if (houseArr[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    // 删除指定下标元素
    public boolean DeleteHouse(int index) {
        if (houseNum == 0) {
            return false;
        }
        for (int i = index; i < houseNum - 1; i++) {
            houseArr[i] = houseArr[i + 1];
        }
        houseArr[--houseNum] = null;
        return true;
    }

    // 打印所有房屋信息
    public void printALlHouse() {
        if (houseNum == 0) {
            System.out.println("房屋列表为空");
            return;
        }
        for (int i = 0; i < houseNum; i++) {
            System.out.println(houseArr[i]);
        }
    }

}
