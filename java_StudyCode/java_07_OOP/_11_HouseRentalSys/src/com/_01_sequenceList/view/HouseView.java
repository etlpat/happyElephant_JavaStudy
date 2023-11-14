package com._01_sequenceList.view;

import com._01_sequenceList.domain.House;
import com._01_sequenceList.service.HouseService;

import java.util.Scanner;

/**
 * 功能：
 * 1.显式界面
 * 2.接收用户输入
 * 3.调用HouseService完成对房屋信息的操作
 */

public class HouseView {
    private boolean loop = true;// 用于控制循环
    private char key;// 接收键入的字符
    private HouseService houseSqList = new HouseService(150);// 房屋信息顺序表
    private int addCount = 0;// 调用addHouseInfo的次数


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


    // 增加信息
    public void addHouseInfo(Scanner sc) {
        addCount++;
        House newHouse = new House();
        System.out.println("请输入房屋信息：");
        newHouse.setId(addCount);
        System.out.print("姓名：");
        newHouse.setName(sc.next());
        System.out.print("电话：");
        newHouse.setPhone(sc.next());
        System.out.print("地址：");
        newHouse.setAddress(sc.next());
        System.out.print("租金：");
        newHouse.setRent(sc.nextDouble());
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
        newHouse.setState(state == 1 ? "已出租" : "未出租");

        if (houseSqList.addHouse(newHouse)) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }


    // 按编号查找信息
    public void findHouseInfo(Scanner sc) {
        System.out.print("请输入所找元素编号：");
        int id = sc.nextInt();
        if (id < 1 || id > addCount) {
            System.out.println("编号信息不存在");
            return;
        }
        int index = houseSqList.getHouseIndex(id);
        if (index == -1) {
            System.out.println("该编号信息已被删除");
        } else {
            System.out.println(houseSqList.getHouseArr()[index]);
        }
    }


    // 删除房屋信息
    public void deleteHouseInfo(Scanner sc) {
        System.out.println("请输入待删除房间编号(-1停止删除)：");
        int id = sc.nextInt();
        if (id == -1) {
            System.out.println("删除操作停止");
            return;
        } else if (id < 1 || id > addCount) {
            System.out.println("编号信息不存在");
            return;
        } else {
            int index = houseSqList.getHouseIndex(id);
            if (index == -1) {
                System.out.println("编号信息不存在");
                return;
            }
            if (houseSqList.DeleteHouse(index)) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }

    }


    // 修改指定编号的元素信息
    public void updateHouseInfo(Scanner sc) {
        System.out.print("请输入要修改的元素编号：");
        int id = sc.nextInt();
        if (id < 1 || id > addCount) {
            System.out.println("编号信息不存在");
            return;
        }
        int index = houseSqList.getHouseIndex(id);
        if (index == -1) {
            System.out.println("该编号信息已被删除");
        } else {
            System.out.println("请输入房屋信息：");
            System.out.print("姓名：");
            String name = sc.next();
            houseSqList.getHouseArr()[index].setName(name);
            System.out.print("电话：");
            String phone = sc.next();
            houseSqList.getHouseArr()[index].setPhone(phone);
            System.out.print("地址：");
            String address = sc.next();
            houseSqList.getHouseArr()[index].setAddress(address);
            System.out.print("租金：");
            String rent = sc.next();
            houseSqList.getHouseArr()[index].setRent(Double.valueOf(rent));
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
            houseSqList.getHouseArr()[index].setState(state == 1 ? "已出租" : "未出租");
        }
    }


    // 打印房屋列表
    public void printAllHouseInfo() {
        System.out.println("================================");
        houseSqList.printALlHouse();
        System.out.println("================================");
    }


    // 判断是否退出系统
    public boolean exitSys(Scanner sc) {
        System.out.print("请确认是否退出系统(y/n)：");
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
            key = sc.next().charAt(0);
            switch (key) {
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
                    printAllHouseInfo();
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
