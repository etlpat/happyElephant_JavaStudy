package com.chatRoom.Util.FrameUtil;

import com.chatRoom.javaBean.OnlineUname;

import javax.swing.*;
import java.awt.*;


// DefaultListCellRenderer是JList的渲染器
// （本类继承JLable，因此可以看作JLable去编写）
//  功能：用于美化客户端的在线用户列表
public class ImagineCellRenderer extends DefaultListCellRenderer {
    String clintName;

    public ImagineCellRenderer(String username) {
        this.clintName = username;
    }


    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof OnlineUname) {
            // 获取在线用户对象
            OnlineUname onlineUname = (OnlineUname) value;

            // 从OnlineUname获取文字信息
            String username = onlineUname.getUsername();
            String signature1 = username.equals(clintName) ? "  [我]" : "  在线";
            String signature2 = " -用户留言";
            String text = "<html><body><span color='blue' style='font-size:15px'>" + username +
                    "</span><br/><span color='green' style='font-size:12px'>" + signature1 +
                    "</span><span style='font-size:7px'>" + signature2 + "</span></body></html>";

            // 渲染客户在线列表
            ImageIcon icon = new ImageIcon(onlineUname.getImageSrc());
            icon.setImage(icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));// 设置图片大小
            setIcon(icon);
            setText(text);
            setForeground(new Color(9, 118, 126));// 设置字体颜色
            setVerticalTextPosition(SwingConstants.TOP);
            setHorizontalTextPosition(SwingConstants.RIGHT);
            setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 150, 246, 173)));// 设置边框
            if (username.equals(clintName)) {// 将本人与其它用户的背景色设为不同颜色
                setBackground(new Color(238, 10, 181, 84));// 设置背景颜色
            } else {
                setBackground(new Color(14, 174, 225, 76));
            }
        }

        return this;
    }
}
