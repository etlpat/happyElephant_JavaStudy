package com.chatRoom.client.view;

import com.chatRoom.Util.FontSupportUtil;
import com.chatRoom.Util.IOStreamUtil;
import com.chatRoom.javaBean.ChatStatus;
import com.chatRoom.javaBean.FontStyle;
import com.chatRoom.javaBean.OnlineUname;
import com.chatRoom.javaBean.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.List;


// 客户端的聊天界面
public class ClientChat extends JFrame {

    int frameWidth = 750;// 设置本窗体的宽
    int frameHeight = 600;// 设置本窗体的高
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// 获取屏幕大小
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    String username;
    Socket socket;
    ClientChat clientChat = this;
    String receiver = "ALL";// 消息的接收人（默认为ALL）

    // 创建组件
    JTextPane acceptPane = new JTextPane();// 创建接收框
    JTextPane sendPane = new JTextPane();// 创建输入框
    JList lstUser = new JList();// 创建用户列表
    JComboBox fontFamilyCmb = new JComboBox();// 字体下拉框
    JComboBox receiverBox = new JComboBox();// 选择聊天用户的下拉框
    JButton jbSend = new JButton("发送");// 发送按钮
    JButton jbFile = new JButton("传文件");// 传文件按钮


    public ClientChat(String username, Socket socket) throws HeadlessException {
        this();
        this.username = username;
        this.socket = socket;
    }


    // 构造器，用于设置窗体
    public ClientChat() throws HeadlessException {

        // (1)设置窗体属性
        setTitle("客户端聊天室");// 设置标题
        setSize(frameWidth, frameHeight);// 设置窗体大小
        setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);// 设置窗体位置居中
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭窗体时程序自动退出
        setLayout(null);// 设置布局


        // (2)设置背景图片窗体
        ImageIcon imageIcon = new ImageIcon("images/bg2.jpg");// 加载窗体的背景图片
        imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(750, 600, Image.SCALE_SMOOTH));// 将图片等比缩小
        JLabel jblBackground = new JLabel(imageIcon);// 创建一个标签并将图片添加进去
        jblBackground.setBounds(0, 0, frameWidth, frameHeight);
        jblBackground.setLayout(null);
        this.add(jblBackground);// 将背景窗体添加到最外层窗体中


        // (3)添加接收框
        // 接收框
        acceptPane.setOpaque(false);// 设置透明
        acceptPane.setFont(new Font("宋体", 0, 16));
        // 设置接收框滚动条
        JScrollPane scoPaneOne = new JScrollPane(acceptPane);
        scoPaneOne.setBounds(15, 20, 500, 332);
        scoPaneOne.setOpaque(false);// 设置透明
        scoPaneOne.getViewport().setOpaque(false);
        jblBackground.add(scoPaneOne);


        // (4)添加输入框
        // 输入框
        sendPane.setOpaque(false);// 设置透明
        sendPane.setFont(new Font("宋体", 0, 16));
        // 设置接收框滚动条
        JScrollPane scoPaneTwo = new JScrollPane(sendPane);
        scoPaneTwo.setBounds(15, 400, 500, 122);
        scoPaneTwo.setOpaque(false);// 设置透明
        scoPaneTwo.getViewport().setOpaque(false);
        jblBackground.add(scoPaneTwo);


        // (5)添加在线用户列表
        setLstUser(jblBackground);// 通过方法，添加在线用户列表

        // (6)添加表情选择
        JLabel jblFace = getJblFace();// 通过方法，获取表情包标签
        jblBackground.add(jblFace);

        // (7)添加抖动标签
        JLabel jblShake = getJblShake();// 通过方法，获取抖动标签
        jblBackground.add(jblShake);

        // (8)设置字体选择
        JLabel jblFontChoose = getJblFontChoose(jblBackground);// 通过方法，获取字体标签
        jblBackground.add(jblFontChoose);

        // (9)添加选择聊天用户的下拉框
        setReceiverBox(jblBackground);// 通过方法，添加选择聊天用户的下拉框

        // (10)设置发送按钮
        setJbSend();// 使用设置按钮的方法
        jblBackground.add(jbSend);

        // (11)设置传文件按钮
        setJbFile();// 使用设置按钮的方法
        jblBackground.add(jbFile);

        // (12)设置窗体可见（必须最后设置）
        setVisible(true);
    }


    // [5]添加在线用户列表，并添加鼠标点击事件
    public void setLstUser(JLabel jblBackground) {
        // 设置用户列表属性
        lstUser.setFont(new Font("宋体", 0, 14));
        lstUser.setVisibleRowCount(17);// 可见行数
        lstUser.setFixedCellWidth(180);// 单元格宽度
        lstUser.setFixedCellHeight(60);// 单元格高度

        // 添加滚动条
        JScrollPane spUser = new JScrollPane(lstUser);
        spUser.setFont(new Font("宋体", 0, 14));
        spUser.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spUser.setBounds(530, 17, 200, 507);
        jblBackground.add(spUser);

        // 创建点击在线用户后的菜单
        JPopupMenu popupMenu = getPopupMenu();

        // 添加鼠标点击事件（点击右键，弹出菜单）
        lstUser.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // 当点击鼠标右键（不能空点）
                if (e.isMetaDown() && lstUser.getSelectedValue() != null) {
                    // 弹出菜单
                    popupMenu.show(lstUser, e.getX(), e.getY());
                }
            }
        });
    }


    // [5.1]获取点击在线用户后的菜单
    public JPopupMenu getPopupMenu() {
        // 创建组件
        JPopupMenu popupMenu = new JPopupMenu();// 声明菜单
        JMenuItem privateChat = new JMenuItem("私聊");// 声明私聊按钮（菜单项）
        JMenuItem blackList = new JMenuItem("拉黑");// 声明拉黑按钮（菜单项）
        popupMenu.add(privateChat);// 将私聊按钮放入菜单
        popupMenu.add(blackList);// 将拉黑按钮放入菜单

        // 为【私聊按钮】添加鼠标点击事件
        // 点击事件：与该用户私聊，将发送人和下拉框全部设为该用户
        privateChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取被点击的在线用户
                Object selectedValue = lstUser.getSelectedValue();// 获取被点击的在线用户
                if (selectedValue instanceof OnlineUname) {
                    receiver = ((OnlineUname) selectedValue).getUsername();// 将发送人设为该用户
                    receiverBox.setSelectedItem(receiver);// 将下拉框设置为发送人
                }
            }
        });

        // 为【拉黑按钮】添加鼠标点击事件
        blackList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //...
            }
        });

        return popupMenu;
    }


    // [6]获取表情包标签，并添加鼠标点击事件
    public JLabel getJblFace() {
        // 设置标签初始属性
        ImageIcon imageIcon1 = new ImageIcon("images/emoji.png");
        imageIcon1 = new ImageIcon(imageIcon1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));// 将图片等比缩小
        JLabel jblFace = new JLabel(imageIcon1);
        jblFace.setBounds(14, 363, 25, 25);

        // 添加鼠标点击事件（点击后new一个标签框）
        jblFace.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new EmojiFrame(sendPane);// 创建表情框体
            }
        });
        return jblFace;
    }


    // [7]获取抖动标签，并添加鼠标点击事件
    public JLabel getJblShake() {
        // 设置标签初始属性
        ImageIcon imageIcon2 = new ImageIcon("images/shake.png");
        imageIcon2 = new ImageIcon(imageIcon2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));// 将图片等比缩小
        JLabel jblShake = new JLabel(imageIcon2);
        jblShake.setBounds(43, 363, 25, 25);

        // 设计鼠标点击事件-窗体抖动
        jblShake.addMouseListener(new MouseAdapter() {
            // 点击事件：点击抖动按钮，使得全部客户端抖动
            @Override
            public void mouseClicked(MouseEvent e) {
                // ①更新接收人
                receiver = receiverBox.getSelectedItem().toString();// 将接收人设为下拉框中被选中的用户
                if (receiver.equals("所有人")) {
                    receiver = "ALL";
                }

                // 将抖动信息传给服务器
                User user = new User();
                user.setChatStatus(ChatStatus.SHAKE);// 设置抖动状态
                user.setSender(username);
                user.setReceiver(receiver);
                IOStreamUtil.writeMessage(socket, user);// 发送给服务器
            }
        });
        return jblShake;
    }


    // [8]获取字体选择标签，并添加鼠标点击事件
    public JLabel getJblFontChoose(JLabel jblBackground) {
        // 设置标签初始属性
        ImageIcon imageIcon3 = new ImageIcon("images/font.png");
        imageIcon3 = new ImageIcon(imageIcon3.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));// 将图片等比缩小
        JLabel jblFontChoose = new JLabel(imageIcon3);
        jblFontChoose.setBounds(44, 363, 80, 25);

        // 添加字体下拉选项框
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        String[] str = graphicsEnvironment.getAvailableFontFamilyNames();
        for (String string : str) {
            fontFamilyCmb.addItem(string);
            fontFamilyCmb.setSelectedItem("宋体");
            fontFamilyCmb.setBounds(104, 363, 150, 25);
            jblBackground.add(fontFamilyCmb);
        }

        // 设置鼠标点击事件-选择字体
        jblFontChoose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 创建颜色选择器（系统提供）
                JColorChooser colorChooser = new JColorChooser();
                // 将所选中的颜色，存放到color中
                Color color = colorChooser.showDialog(clientChat, "字体颜色", Color.BLACK);
                // 使用工具类，将所选中文字转换为对应形式的艺术字
                FontSupportUtil.setFont(sendPane, color, fontFamilyCmb.getSelectedItem().toString(), Font.BOLD, 60);
            }
        });
        return jblFontChoose;
    }


    // [9]设置选择聊天用户的下拉框
    public void setReceiverBox(JLabel jblBackground) {
        // 设置聊天对象标签
        JLabel receiverLabel = new JLabel("聊天对象:");
        receiverLabel.setBounds(304, 363, 80, 25);
        jblBackground.add(receiverLabel);

        // 设置聊天用户的下拉选择框
        receiverBox.setSelectedItem("所有人");// 设置默认选项为“所有人”
        receiverBox.addItem("所有人");
        receiverBox.setBounds(364, 363, 150, 25);
        jblBackground.add(receiverBox);
    }


    // [10]设置发送按钮，并添加鼠标点击事件
    public void setJbSend() {
        jbSend.setBounds(15, 533, 125, 25);

        // 添加鼠标点击事件（此处为群发，发给所有在线用户）
        jbSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ①更新接收人
                receiver = receiverBox.getSelectedItem().toString();// 将接收人设为下拉框中被选中的用户
                if (receiver.equals("所有人")) {
                    receiver = "ALL";
                }

                // ②将用户写的发送框中的内容，传到服务器
                // 使用工具类，获取发送框中的内容
                List<FontStyle> fontStyles = FontSupportUtil.paneTxtToFontStyleList(sendPane);

                User user = new User();
                user.setChatContent(fontStyles);// 将发送框内容存入user中
                user.setSender(username);// 设置发送人
                user.setReceiver(receiver);// 设置接收人（成员变量receiver，默认为ALL，可以被改变）
                user.setChatStatus(ChatStatus.CHAT);// 设置状态为CHAT聊天
                IOStreamUtil.writeMessage(socket, user);// 将发送框内容发到服务器

                // ③将输入框置空
                sendPane.setText("");
            }
        });
    }


    // [11]设置传文件按钮，并添加鼠标点击事件
    public void setJbFile() {
        jbFile.setBounds(389, 533, 125, 25);

        // 添加鼠标点击事件
        jbFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ①更新接收人
                receiver = receiverBox.getSelectedItem().toString();// 将接收人设为下拉框中被选中的用户
                if (receiver.equals("所有人")) {
                    JOptionPane.showMessageDialog(null, "只能给单个用户发送文件！");// 打印提示信息
                    return;
                }

                // ②创建文件发送界面
                new FileSendFrame(socket, username, receiver);
            }
        });
    }


    public static void main(String[] args) {
        new ClientChat();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public JTextPane getAcceptPane() {
        return acceptPane;
    }

    public void setAcceptPane(JTextPane acceptPane) {
        this.acceptPane = acceptPane;
    }

    public JTextPane getSendPane() {
        return sendPane;
    }

    public void setSendPane(JTextPane sendPane) {
        this.sendPane = sendPane;
    }

    public JList getLstUser() {
        return lstUser;
    }

    public void setLstUser(JList lstUser) {
        this.lstUser = lstUser;
    }

    public JComboBox getReceiverBox() {
        return receiverBox;
    }

    public void setReceiverBox(JComboBox receiverBox) {
        this.receiverBox = receiverBox;
    }

    public JButton getJbSend() {
        return jbSend;
    }

    public void setJbSend(JButton jbSend) {
        this.jbSend = jbSend;
    }

    public JComboBox getFontFamilyCmb() {
        return fontFamilyCmb;
    }

    public void setFontFamilyCmb(JComboBox fontFamilyCmb) {
        this.fontFamilyCmb = fontFamilyCmb;
    }
}
