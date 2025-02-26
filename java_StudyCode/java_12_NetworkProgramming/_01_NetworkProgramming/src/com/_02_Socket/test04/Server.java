package com._02_Socket.test04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 案例：TCP网络通信编程
//
// 要求：（文件传输）
//  1.编写一个服务端,和一个客户端
//  2.服务器端在9999端口监听
//  3.客户端连接到服务端,发送一张图片 e:\\xxx.png
//  4.服务器端接收到 客户端发送的 图片,保存到src下,发送“收到图片”再退出
//  5.客户端接收到服务端发送的“收到图片”,再退出
//  6.该程序要求使用 StreamUtils.java


public class Server {
    public static void main(String[] args) throws Exception {

        // 1.监听并等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端监听9999端口，等待连接...");
        Socket socket = serverSocket.accept();

        // 2.接收图片，并存到对应位置
        System.out.println("服务端接收图片...");
        // (1)接收图片的字节数组
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        // (2)将字节数组写入到指定路径，得到图片文件
        String destFilePath = "src\\view\\abc.jpg";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bufferedOutputStream.write(bytes);

        // 3.服务端回显信息
        String string = "服务端收到图片！";
        System.out.println("服务端回显：" + string);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(string);
        bufferedWriter.flush();
        socket.shutdownOutput();

        // 4.关闭资源
        bufferedWriter.close();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
    }
}
