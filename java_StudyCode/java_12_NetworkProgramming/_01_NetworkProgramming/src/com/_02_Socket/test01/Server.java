package com._02_Socket.test01;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 案例：TCP网络通信编程
//
// (1)要求
//  1.编写一个服务器端,和一个客户端
//  2.服务器端在9999端口监听
//  3.客户端连接到服务器端,发送“hello,server",然后退出
//  4.服务器端接收到 客户端发送的 信息,输出,并退出
//
//
// (2)编写思路
//  ①创建服务端
//      1.在本机的9999端口监听,等待连接
//      2.当没有客户端连接9999端口时,程序会阻塞,等待连接
//      3.通过socket.getlnputStream()读取客户端写入到数据通道的数据,显示
//
//  ②创建客户端
//      1.连接服务端(ip,端口)
//      2.连接上后,生成Socket,通过socket.getOutputStream()
//      3.通过输出流,写入数据到数据通道
//


// 服务端
public class Server {
    public static void main(String[] args) throws IOException {

        // 1.在本机的9999端口监听,等待连接
        //  注意：9999端口不能被其它服务监听/占用
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端正在监听9999端口...");

        // 2.当没有客户端连接9999端口时,程序会阻塞,等待连接
        //  当有客户连接，获取该连接的 socket对象
        Socket socket = serverSocket.accept();
        System.out.println("服务端接收请求-" + socket.getClass().getSimpleName());

        // 3.通过socket.getlnputStream()读取客户端写入到数据通道的数据,显示数据
        InputStream inputStream = socket.getInputStream();
        // 获取输入流数据
        System.out.print("服务端接收：");
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }

        // 4.释放资源
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");

    }
}
