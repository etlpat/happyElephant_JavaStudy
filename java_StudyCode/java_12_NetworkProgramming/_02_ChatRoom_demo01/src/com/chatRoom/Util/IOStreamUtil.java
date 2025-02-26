package com.chatRoom.Util;

import java.io.*;
import java.net.Socket;

public class IOStreamUtil {

    // 方法：从socket中读取对象数据
    public static Object readMessage(Socket socket) {
        Object object = null;
        try {
            InputStream inputStream = socket.getInputStream();// 获取socket的输入流
            DataInputStream dataInputStream = new DataInputStream(inputStream);// 转换为数据输入流

            int readInt = dataInputStream.readInt();// 获取对象所占的字节数
            byte[] bytes = new byte[readInt];
            dataInputStream.readFully(bytes);// 将输入流中的对象数据，传入字节数组中
            object = BytesObjectConvertUtil.bytesToObject(bytes);// 使用工具类，将字节数组转换为对象

        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }


    // 方法：向socket中写入对象数据
    public static void writeMessage(Socket socket, Object object) {
        try {
            OutputStream outputStream = socket.getOutputStream();// 获取socket的输出流
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);// 转换为数据输出流
            byte[] bytes = BytesObjectConvertUtil.objectToBytes(object);// 将要写入的对象，转换为字节数组

            dataOutputStream.writeInt(bytes.length);// 写入对象的字节数
            dataOutputStream.write(bytes);// 将对象的字符数组写入socket
            dataOutputStream.flush();// 刷新

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
