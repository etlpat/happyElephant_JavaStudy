package com._02_linkedList.service;

import com._02_linkedList.domain.House;
import com._02_linkedList.domain.HouseNode;

public class HouseLinkList {
    HouseNode head;
    HouseNode tail;

    public HouseLinkList() {
        this.head = new HouseNode();
        this.tail = head;
    }

    // 尾插法添加节点
    public boolean addTailNode(HouseNode houseNode) {
        houseNode.setNext(null);
        tail.setNext(houseNode);
        tail = houseNode;
        return true;
    }

    // 寻找编号对应的房屋信息
    public House nodeDataById(int id) {
        HouseNode node = head.getNext();
        while (node != null) {
            if (node.getData().getId() == id) {
                return node.getData();
            }
            node = node.getNext();
        }
        return null;
    }

    // 删除对应编号的结点
    public boolean deleteNodeById(int id, House house) {
        HouseNode node = head;
        while (node.getNext() != null) {
            if (node.getNext().getData().getId() == id) {
                HouseNode tmp = node.getNext();
                house.copyData(tmp.getData());
                node.setNext(tmp.getNext());
                tmp = null;
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    // 打印全部结点信息
    public void printAllNodeData() {
        HouseNode node = head.getNext();
        if (node == null) {
            System.out.println("链表为空！");
            return;
        }
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }
}
