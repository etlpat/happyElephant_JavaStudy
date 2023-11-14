package com._02_linkedList.domain;

import com._02_linkedList.domain.House;

public class HouseNode {
    private House data;
    private HouseNode next;

    public HouseNode() {
    }

    public HouseNode(House house) {
        this.data = house;
        this.next = null;
    }

    public House getData() {
        return data;
    }

    public void setData(House data) {
        this.data = data;
    }

    public HouseNode getNext() {
        return next;
    }

    public void setNext(HouseNode next) {
        this.next = next;
    }
}
