package com.chatRoom.server;

import com.chatRoom.Util.IOStreamUtil;
import com.chatRoom.javaBean.ChatStatus;
import com.chatRoom.javaBean.User;
import com.chatRoom.jdbc.DAO;
import com.chatRoom.server.view.ServerFrame;

import javax.swing.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 服务器开一个线程，用于一直读消息
public class ServerHandler extends Thread {
    Socket socket;
    ServerFrame serverFrame;
    static List<String> onlineUsers = new ArrayList<>();// 在线用户名列表
    static List<Socket> onlineSocket = new ArrayList<>();// 在线用户socket列表
    static Map<String, Socket> onlineUserMap = new HashMap<>();// 在线用户的<用户名,socket>键值对集合


    public ServerHandler(Socket socket, ServerFrame serverFrame) {
        this.socket = socket;
        this.serverFrame = serverFrame;
    }


    @Override
    public void run() {
        // 死循环，使得服务端一直拿消息，形成长连接
        while (true) {// 若不能接收，则暂时阻塞
            try {
                // 调用工具包中的读取方法，获取客户端传来的数据
                Object o = IOStreamUtil.readMessage(socket);
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
                    } else if (user.getChatStatus() == ChatStatus.ULIST) {// 此时为更新用户列表状态（客户端）
                        handleUList(user);
                    }
                }

                Thread.sleep(500);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    // (1)处理用户登录请求
    private void handleLogin(User user) {
        boolean userExist = DAO.isUserExist(user);// 调用DAO包的方法，判断该用户是否在数据库中存在
        if (userExist) {// 若登录成功
            // ①该用户变为在线
            onlineUsers.add(user.getUsername());// 将在线用户添加到在线列表
            onlineSocket.add(socket);// 将在线用户socket添加到列表
            onlineUserMap.put(user.getUsername(), socket);// 将<用户名,socket>键值对添加到集合
            flushUserOnlineList();// 调用刷新在线用户列表的方法

            // ②给用户发送登录消息，使用户成功登录
            user.setExist(true);// 设置User的isExist属性为true
            user.setChatStatus(ChatStatus.LOGIN);// 设置为登录态
            IOStreamUtil.writeMessage(socket, user);// 将user回显给客户端

            // ③给所有客户端发送系统消息，表示用户已上线
            String username = user.getUsername();
            user = new User();
            user.setChatStatus(ChatStatus.NOTICE);// 切换为系统态
            user.setNotice(">>>欢迎" + username + "上线啦！");
            sendAll(user);// 将该信息群发给所有在线用户
            serverFrame.log(">>用户" + username + "登录成功");// 记录日志

            // ④给所有客户端更新在线列表
            user = new User();
            user.setChatStatus(ChatStatus.ULIST);
            user.setNotice(onlineUsers);
            sendAll(user);

        } else {// 若登录失败
            IOStreamUtil.writeMessage(socket, user);// 将失败的user回显给客户端
            serverFrame.log(">>用户" + user.getUsername() + "登录失败");// 记录日志
        }
    }


    // (2)处理用户的系统消息请求
    private void handleNotice(User user) {
    }


    // (3)处理用户的聊天请求
    private void handleChat(User user) {
        String receiver = user.getReceiver();// 获取接收人

        // 单发or群发
        if ("ALL".equals(receiver)) {// 若接收人为ALL，则给所有人群发消息
            sendAll(user);

        } else {// 否则，只给某个人单发
            Socket pSocket = onlineUserMap.get(receiver);// 获取接收人对应的socket
            IOStreamUtil.writeMessage(pSocket, user);// 给接收人发送信息
            if (pSocket != socket) {
                IOStreamUtil.writeMessage(socket, user);// 也给自己发送信息
            }
        }
    }


    // (4)处理抖动请求
    private void handleShake(User user) {
        String receiver = user.getReceiver();// 获取接收人

        if ("ALL".equals(receiver)) {// 若接收人为ALL，则将信息发送给所有人
            sendAll(user);

        } else {// 否则，只给某个人私发
            Socket pSocket = onlineUserMap.get(receiver);// 获取接收人对应的socket
            IOStreamUtil.writeMessage(pSocket, user);// 给接收人发送抖动
            if (pSocket != socket) {
                IOStreamUtil.writeMessage(socket, user);// 自己也抖动
            }
        }
    }


    // (5)用于更新在线列表（客户端）
    private void handleUList(User user) {
    }


    // 给所有在线用户群发信息
    public void sendAll(User user) {
        for (Socket socket : onlineSocket) {// 变量全部socket
            IOStreamUtil.writeMessage(socket, user);// 向所有用户发送信息
        }

        serverFrame.log(user.getUsername() + "对所有用户发送" + user.getChatStatus() + "状态信息");// 记录日志
    }


    // 刷新服务端用户在线列表
    public void flushUserOnlineList() {
        // 获取用户列表组件
        JList lstUser = serverFrame.getLstUser();
        lstUser.setListData(onlineUsers.toArray());// 将用户添加到服务器在线用户列表中

        // 修改服务器在线人数
        serverFrame.getTxtNumber().setText(onlineUsers.size() + "人");
    }

}
