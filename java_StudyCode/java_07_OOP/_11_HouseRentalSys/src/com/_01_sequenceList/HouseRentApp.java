package com._01_sequenceList;

import com._01_sequenceList.view.HouseView;

/**
 * 房屋出租系统（顺序表）
 * 要求：
 * 本次实现使用【分层模式】，用多个包逐层实现项目
 * 层级关系：数据层 -> 业务层 -> 界面层
 *
 *
 * 包1：domain包[数据层][domain/model]
 * 用于存放数据元素的基本信息
 *
 * 包2：service包[业务层]
 * 用于实现房屋信息的基本操作：增删改查
 * 增删改查：crud（c:create/r:read/u:update/d:delete）
 *
 * 包3：view[界面层]
 * 显式界面、接收用户输入、调用HouseService完成对房屋信息的各种操作
 *
 * 类：HouseRentApp
 * 该类调用main方法，创建并调用房屋对象
 */


public class HouseRentApp {
    public static void main(String[] args) {
        new HouseView().RunHouseView();
    }
}
