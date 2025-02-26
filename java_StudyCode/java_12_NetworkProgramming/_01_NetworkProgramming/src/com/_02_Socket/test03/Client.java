package com._02_Socket.test03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {

        // 1.与服务端建立连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        // 2.向服务端发送信息
        String string = "hello server! 字符流";
        System.out.println("客户端发送：" + string);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(string);// 写入字符流
        bufferedWriter.newLine();// 插入换行符，表示写入内容结束（注意：接收方必须使用readLine()）
        bufferedWriter.flush();// 刷新字符流，将其写入通道

        // 3.接收服务端回显信息
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = bufferedReader.readLine();
        System.out.println("客户端接收回显：" + str);

        // 4.释放资源
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}
