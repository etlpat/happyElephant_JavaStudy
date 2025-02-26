package com.chatRoom.javaBean;

// 提供给ListModel使用
// 用于存放用户名和头像地址的，用于渲染在线用户列表的实体类
public class OnlineUname {
    public static int num = 0;// 在0~8循环，表示9个图片的编号
    String imageSrc;// 头像地址
    String username;// 用户名


    public OnlineUname(String username) {
        this.username = username;
        imageSrc = "images/head/h" + (num + 1) + ".jpg";
        num++;// 每创建一个对象，num自增1
        num %= 9;// 使得staticNum在0~8循环
    }

    @Override
    public String toString() {
        return "Uname{" +
                "num=" + num +
                ", username='" + username + '\'' +
                '}';
    }

    public static void cleanNum() {
        num = 0;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
