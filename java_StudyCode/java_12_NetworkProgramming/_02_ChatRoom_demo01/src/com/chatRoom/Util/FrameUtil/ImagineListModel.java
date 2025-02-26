package com.chatRoom.Util.FrameUtil;

import com.chatRoom.javaBean.OnlineUname;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


// JList的模型类，是构成JList的模型元素（提供给CellRenderer类去调用）
//  功能：用于美化客户端的在线用户列表
public class ImagineListModel extends AbstractListModel<OnlineUname> {
    List<OnlineUname> list = new ArrayList<>();

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public OnlineUname getElementAt(int index) {
        return list.get(index);
    }

    // 为列表添加元素
    public void addElement(OnlineUname element) {
        list.add(element);
    }
}
