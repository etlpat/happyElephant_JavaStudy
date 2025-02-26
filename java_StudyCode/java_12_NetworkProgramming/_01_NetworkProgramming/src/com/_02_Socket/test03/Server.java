package com._02_Socket.test03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 案例：TCP网络通信编程
//
// 要求：(使用字符流)
//  1.编写一个服务端,和一个客户端
//  2.服务端在9999端口监听
//  3.客户端连接到服务端,发送“hello,server",并接收服务端回发的"hello,client",再退出
//  4.服务端接收到 客户端发送的 信息,输出,并发送“hello,client",再退出
//

public class Server {
    public static void main(String[] args) throws IOException {

        // 1.监听并等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端监听9999端口，等待连接...");
        Socket socket = serverSocket.accept();

        // 2.接收客户端信息
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = bufferedReader.readLine();
        System.out.println("服务端接收：" + str);

        // 3.向客户端回显信息
        String string = "hello client! 字符流";
        System.out.println("服务端回显：" + string);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(string);// 写入字符流
        bufferedWriter.newLine();// 插入换行符，表示写入内容结束（注意：接收方必须使用readLine()）
        bufferedWriter.flush();// 刷新字符流，将其写入通道

        // 4.释放资源
        bufferedWriter.close();// 关闭外层流
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
