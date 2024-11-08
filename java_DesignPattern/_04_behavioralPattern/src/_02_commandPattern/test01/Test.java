package _02_commandPattern.test01;

// 案例：遥控器和电视
//  电视机是请求的接收者,遥控器是请求的发送者,
//  遥控器上有一些按钮,不同的按钮对应电视机的不同操作。
//  抽象命令角色由一个命令接口来扮演,有三个具体的命令类实现了抽象命令接口,
//  这三个具体命令类分别代表三种操作:打开电视机、关闭电视机和切换频道。
//  显然,电视机遥控器就是一个典型的命令模式应用实例。
//
//

import _02_commandPattern.test01.tv.TV;
import _02_commandPattern.test01.tv.TVRemoteControl;

public class Test {
    public static void main(String[] args) {
        // 创建电视遥控器 -- 调用者
        TVRemoteControl tvRemoteControl = new TVRemoteControl(new TV());

        // 调用者中调用命令对象；命令对象中调用接收者
        tvRemoteControl.openTV();
        tvRemoteControl.changeTVChannel();
        tvRemoteControl.closeTV();
    }
}
