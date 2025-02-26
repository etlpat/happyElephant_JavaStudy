package com._02_Socket.test01;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


// 客户端
public class Client {
    public static void main(String[] args) throws IOException {
        // 1.连接服务端(ip, 端口)
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);// 连接本机的9999端口
        System.out.println("客户端连接999端口");

        // 2.连接上后, 生成Socket, 通过socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();

        // 3.通过输出流, 写入数据到数据通道
        String str = "hello world!";
        outputStream.write(str.getBytes());
        System.out.println("客户端写入：" + str);

        // 4.释放资源
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");

    }
}
