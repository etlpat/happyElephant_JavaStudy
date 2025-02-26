package com.chatRoom.client;

import com.chatRoom.Util.FontSupportUtil;
import com.chatRoom.Util.FrameUtil.ImagineCellRenderer;
import com.chatRoom.Util.FrameUtil.ImagineListModel;
import com.chatRoom.Util.IOStreamUtil;
import com.chatRoom.Util.ShakeUtil;
import com.chatRoom.client.view.ClientChat;
import com.chatRoom.client.view.ClientLogin;
import com.chatRoom.javaBean.ChatStatus;
import com.chatRoom.javaBean.FontStyle;
import com.chatRoom.javaBean.OnlineUname;
import com.chatRoom.javaBean.User;

import javax.swing.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// 客户端开一个线程，用于一直读消息
public class ClientHandler extends Thread {
    Socket socket;
    // 一个ClientHandler线程，对应一次用户访问，即对应一次clientLogin登录+clientChat聊天
    ClientLogin clientLogin;
    ClientChat clientChat;
    String username;// 使用本线程的用户名

    public ClientHandler(Socket socket, ClientLogin clientLogin, String username) {
        this.socket = socket;
        this.clientLogin = clientLogin;
        this.username = username;
    }

    @Override
    public void run() {
        // 死循环，使得客户端一直拿消息，形成长连接
        while (true) {
            try {
                // 若不能接收，则暂时阻塞
                Object o = IOStreamUtil.readMessage(socket);// 调用工具包中的读取方法
                System.out.println("服务端接收：" + o);

                // 若传来的数据是User，则进行校验
                if (o instanceof User) {// 当收到User，判断user此时的状态
                    User user = (User) o;

                    if (user.getChatStatus() == ChatStatus.LOGIN) {// 当此时为登录状态
                        handleLogin(user);// 调用处理登录的方法
                    } else if (user.getChatStatus() == ChatStatus.NOTICE) {// 当此时为系统消息状态
                        handleNotice(user);// 调用处理系统请求的方法
                    } else if (user.getChatStatus() == ChatStatus.CHAT) {// 当此时为聊天消息状态
                        handleChat(user);// 调用处理聊天请求的方法
                    } else if (user.getChatStatus() == ChatStatus.SHAKE) {// 当此时为抖动状态
                        handleShake(user);// 调用处理抖动请求的方法
                    } else if (user.getChatStatus() == ChatStatus.ULIST) {// 此时为更新用户列表状态
                        handleUList(user);
                    }
                }

                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    // (1)用于处理登录结果
    private void handleLogin(User user) {
        if (user.isExist()) {// 若用户存在->登录成功
            System.out.println("登录成功！");
            // ①打开用户聊天界面
            clientChat = new ClientChat(user.getUsername(), socket);
            // ②关闭用户登录界面
            clientLogin.dispose();
        } else {// 若用户不存在->登录失败
            System.out.println("登录失败");
        }
    }


    // (2)用于处理系统提示结果
    private void handleNotice(User user) {
        // 将用户的通知信息String转换为FontStyle列表
        List<FontStyle> fontStyles = FontSupportUtil.stringToFontStyleList(user.getNotice() + "\n");

        // 将列表中的内容打印到接收框上（拼接到接收框文本末尾）
        FontSupportUtil.fontStyleListToPane(clientChat.getAcceptPane(), fontStyles);
    }


    // (3)用于处理聊天结果（将获取的对话，输出到接收框中）
    private void handleChat(User user) {
        // 创建列表，存放要打印到输出框的内容
        ArrayList<FontStyle> fontStyles = new ArrayList<>();
        fontStyles.addAll(FontSupportUtil.stringToFontStyleList(user.getSender() + "说： >> "));// 拼接前缀内容
        fontStyles.addAll(user.getChatContent());// 将用户说的话拼接到列表中
        fontStyles.addAll(FontSupportUtil.stringToFontStyleList(" >> 对：" + user.getReceiver() + "\n"));// 拼接后缀内容

        // 使用工具类，将fontStyles列表中的内容，打印到接收框中（拼接到接收框文本的末尾）
        FontSupportUtil.fontStyleListToPane(clientChat.getAcceptPane(), fontStyles);
    }


    // (4)用于使窗体发生抖动
    private void handleShake(User user) {
        // 使窗体抖动
        new ShakeUtil(clientChat).start();// 开启抖动线程（工具包中的类）
    }


    // (5)用于处理在线用户更新结果
    //  功能：更新在线列表、更新在线用户下拉选项
    private void handleUList(User onlineUsers) {
        // 获取当前在线的所有用户名列表
        ArrayList<String> users = (ArrayList<String>) onlineUsers.getNotice();// 获取在线用户列表

        // ①更新在线用户列表
        JList lstUser = clientChat.getLstUser();// 获取在线列表
        // 设置在线用户列表，并添加样式
        OnlineUname.cleanNum();// 将自增的头像编号置为0
        ImagineListModel model = new ImagineListModel();// 获取存储在线用户的model对象
        for (String username : users) {
            model.addElement(new OnlineUname(username));
        }
        lstUser.setModel(model);// 为列表添加模型，用于存放数据
        lstUser.setCellRenderer(new ImagineCellRenderer(username));// 为列表项添加样式


        // ②更新在线用户下拉框
        JComboBox receiverBox = clientChat.getReceiverBox();// 获取下拉框
        String receiver = clientChat.getReceiver();// 获取下拉框默认发信人
        Boolean isReceiverExist = false;// 判断发信人是否存在
        receiverBox.removeAllItems();// 移除全部菜单项

        receiverBox.addItem("所有人");
        for (int i = 0; i < users.size(); i++) {// 添加全部菜单项
            receiverBox.addItem(users.get(i));
            if (receiver.equals(users.get(i))) {
                isReceiverExist = true;
            }
        }

        // 若发信人已经不存在
        if (!receiver.equals("ALL") && !isReceiverExist) {
            clientChat.setReceiver("ALL");
            receiverBox.setSelectedItem("所有人");
        }
    }
}


