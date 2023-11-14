package com._02_linkedList.view;

import com._02_linkedList.domain.House;
import com._02_linkedList.domain.HouseNode;
import com._02_linkedList.service.HouseLinkList;

import java.util.Scanner;


public class HouseView {
    private HouseLinkList linkList = new HouseLinkList();
    private boolean loop = true;
    private int addCount = 0;

    // 打印主菜单
    public void printMenu() {
        System.out.println("********************************");
        System.out.println("*******  房 屋 出 租 系 统  *******");
        System.out.println("*******  1. 新 增 房 屋   ********");
        System.out.println("*******  2. 查 找 房 屋   ********");
        System.out.println("*******  3. 删 除 房 屋   ********");
        System.out.println("*******  4. 修 改 房 屋   ********");
        System.out.println("*******  5. 房 屋 列 表   ********");
        System.out.println("*******  6. 退      出   ********");
        System.out.println("********************************");
    }


    // 初始化房屋对象（不初始化编号）
    public boolean initHouse(Scanner sc, House house) {
        if (house == null) {
            return false;
        }
        System.out.println("请输入房屋信息：");
        System.out.print("姓名：");
        house.setName(sc.next());
        System.out.print("电话：");
        house.setPhone(sc.next());
        System.out.print("地址：");
        house.setAddress(sc.next());
        System.out.print("租金：");
        house.setRent(sc.nextDouble());
        System.out.print("状态(1=已出租/0=未出租)：");
        int state;
        while (true) {
            state = sc.nextInt();
            if (state == 0 || state == 1) {
                break;
            } else {
                System.out.print("只能输入(0/1)：");
            }
        }
        house.setState(state == 1 ? "已出租" : "未出租");
        return true;
    }


    // 创建结点对象
    public HouseNode createHouseNode(Scanner sc) {
        House house = new House();
        initHouse(sc, house);
        house.setId(addCount);
        HouseNode houseNode = new HouseNode(house);
        return houseNode;
    }


    // 增加信息
    public void addHouseInfo(Scanner sc) {
        addCount++;
        HouseNode houseNode = createHouseNode(sc);
        if (linkList.addTailNode(houseNode)) {
            System.out.println("结点添加成功");
        }
    }


    // 查找信息
    public void findHouseInfo(Scanner sc) {
        System.out.print("请输入查找房屋的编号：");
        int findId = sc.nextInt();
        House house = linkList.nodeDataById(findId);
        System.out.println(house == null ? "您查找的编号不存在" : house);
    }


    // 删除信息
    public void deleteHouseInfo(Scanner sc) {
        System.out.print("请输入查找房屋的编号：");
        int findId = sc.nextInt();
        House house = new House();
        if (linkList.deleteNodeById(findId, house)) {
            System.out.println("删除结点的信息为：");
            System.out.println(house);
            System.out.println("删除成功！");
        } else {
            System.out.println("结点不存在");
        }
    }


    // 更改信息
    public boolean updateHouseInfo(Scanner sc) {
        System.out.print("请输入修改房屋的编号：");
        int findId = sc.nextInt();
        House house = linkList.nodeDataById(findId);
        if (house == null) {
            System.out.println("房间编号不存在！");
            return false;
        }
        House tmp = new House();
        tmp.setId(house.getId());
        initHouse(sc, tmp);
        house.copyData(tmp);
        tmp = null;
        System.out.println("修改后信息为：");
        System.out.println(house);
        System.out.println("修改成功！");
        return true;
    }


    // 判断是否退出系统
    public boolean exitSys(Scanner sc) {
        System.out.print("请确认是否退出系统(y/n)：");
        char key;
        while (true) {
            key = sc.next().charAt(0);
            if (key == 'y') {
                return false;
            } else if (key == 'n') {
                System.out.println("取消退出");
                return true;
            } else {
                System.out.print("输入有误，请重新输入(y/n)：");
            }
        }
    }


    // 运行房屋出租系统
    public void RunHouseView() {
        Scanner sc = new Scanner(System.in);
        loop = true;
        do {
            printMenu();
            System.out.print("请输入您的选择(1~6)：");
            switch (sc.next().charAt(0)) {
                case '1':// 新增信息
                    addHouseInfo(sc);
                    break;
                case '2':// 查找信息
                    findHouseInfo(sc);
                    break;
                case '3':// 删除信息
                    deleteHouseInfo(sc);
                    break;
                case '4':// 修改信息
                    updateHouseInfo(sc);
                    break;
                case '5':// 房屋列表
                    linkList.printAllNodeData();
                    break;
                case '6':// 退出
                    loop = exitSys(sc);
                    break;
                default:
                    System.out.println("选择有误，请重新输入");
                    break;
            }
            System.out.println("\n\n");
        } while (loop);
        System.out.println("已退出房屋出租系统");
    }
}
