package com.chatRoom.server;

import com.chatRoom.server.view.ServerFrame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


// 服务器启动入口
public class ServerMain {
    ServerFrame serverFrame;

    public ServerMain() {
        try {

            // 服务器监听8888端口，等待客户端连接
            ServerSocket serverSocket = new ServerSocket(8888);

            // 服务器启动时，打开服务窗体！
            serverFrame = new ServerFrame();

            // 此处循环，解决多客户端的使用
            // （每个客户端对应一轮循环：每个客户端对应一个socket和一个serverHandler线程）
            // （若无新客户端，则该循环阻塞等待）
            while (true) {
                // 当与客户端连接后，返回本次连接的socket
                String string = "服务端等待连接...";
                System.out.println(string);
                serverFrame.log(string);// 记录日志信息
                Socket socket = serverSocket.accept();
                serverFrame.log("服务器已连接");// 记录日志信息

                // 创建一个ServerHandler线程，循环读取，实现长连接
                ServerHandler serverHandler = new ServerHandler(socket, serverFrame);
                serverHandler.start();
                System.out.println("服务端接收到客户端的连接：" + socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerMain();
    }
}
