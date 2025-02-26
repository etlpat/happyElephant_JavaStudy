package com._02_Socket.test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


// 案例：TCP网络通信编程
//
// 要求：
//  1.编写一个服务端,和一个客户端
//  2.服务器端在9999端口监听
//  3.客户端连接到服务端,发送“hello,server",并接收服务器端回发的"hello,client",再退出
//  4.服务器端接收到 客户端发送的 信息,输出,并发送“hello,client",再退出


// 服务端
public class Server {
    public static void main(String[] args) throws IOException {
        // 1.监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端等待请求...");

        // 2.当接收请求，获取其socket对象
        Socket socket = serverSocket.accept();

        // 3.接收输入流信息
        InputStream inputStream = socket.getInputStream();
        System.out.print("服务端接收信息：");
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }

        // 4.向客户端回显信息
        String string = "hello client!";
        System.out.println("向客户端发送：" + string);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(string.getBytes());
        socket.shutdownOutput();// 写入结束标记

        // 5.释放资源
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端关闭");
    }
}
