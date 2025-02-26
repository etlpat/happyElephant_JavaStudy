package com._02_Socket.test04;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws Exception {

        // 1.与服务端建立连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        // 2.向服务端发送图片
        System.out.println("客户端发送图片...");
        // (1)将磁盘中的图片，读取转换为字节数组
        String filePath = "C:\\Users\\lenovo\\OneDrive\\图片\\联想安卓照片\\6814-2022-04-20032327-1650439407522.jpg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        // (2)将该图片的字节数组发送给服务端
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);
        socket.shutdownOutput();

        // 3.接收服务端回显
        InputStream inputStream = socket.getInputStream();
        String string = StreamUtils.streamToString(inputStream);
        System.out.println("客户端接收信息：" + string);

        // 4.释放资源
        inputStream.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        socket.close();
    }
}
