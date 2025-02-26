package com._02_Socket.test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {
        // 1.创建socket，连接本机的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端建立连接!");

        // 2.向服务端发送信息
        String string = "hello server!";
        System.out.println("客户端向服务端发送：" + string);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(string.getBytes());
        socket.shutdownOutput();// 写入结束标记

        // 3.接收服务端回显的信息
        InputStream inputStream = socket.getInputStream();
        System.out.print("客户端接收回显：");
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }

        // 4.释放资源
        outputStream.close();
        inputStream.close();
        socket.close();
        System.out.println("客户端关闭");

    }
}
