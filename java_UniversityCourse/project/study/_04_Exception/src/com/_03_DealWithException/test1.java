package com._03_DealWithException;

// 异常的处理方式：
//  1.若多个方法嵌套调用，习惯将底层异常层层抛出，一直抛到最外层，再一并进行捕获处理


import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class test1 {
    public static void main(String[] args) {
        try {
            test2();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();// 打印详细异常信息
            System.out.println(e1);
        } catch (ParseException e2) {
            e2.printStackTrace();
            System.out.println(e2);
        }
    }


    public static void test2() throws FileNotFoundException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Data d = (Data) sdf.parse("2000-11-11 10:23");
        System.out.println(d);
        test3();
    }

    public static void test3() throws FileNotFoundException {
        InputStream is = new FileInputStream("D:nonono");
    }
}
