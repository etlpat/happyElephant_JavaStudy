package com.chatRoom.Util;

import java.io.*;
import java.net.Socket;

public class IOStreamUtil {

    // 方法：从socket中读取对象数据
    public static Object readMessage(Socket socket) {
        Object message = null;
        try {
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            message = objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }


    // 方法：向socket中写入对象数据
    public static void writeMessage(Socket socket, Object message) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
