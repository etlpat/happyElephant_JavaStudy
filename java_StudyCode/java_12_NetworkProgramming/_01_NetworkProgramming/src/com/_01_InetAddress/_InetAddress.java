package com._01_InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;


// InetAddress类
//
// 相关方法
//  1.获取本机InetAddress对象 getLocalHost
//  2.根据指定主机名/域名获取ip地址对象 getByName
//  3.获取InetAddress对象的主机名 getHostName
//  4.获取InetAddress对象的地址 getHostAddress

public class _InetAddress {
    public static void main(String[] args) throws UnknownHostException {

        // 1. 获取本机的 InetAddress对象
        InetAddress localHost1 = InetAddress.getLocalHost();
        System.out.println(localHost1);// LAPTOP-VNOOVHEB/169.254.148.228 （主机名/ip地址）

        // 2.1. 根据指定主机名，获取对应的 InetAddress对象
        InetAddress localHost2 = InetAddress.getByName("LAPTOP-VNOOVHEB");
        System.out.println(localHost2);// LAPTOP-VNOOVHEB/169.254.148.228

        // 2.2. 根据指定域名，获取对应的 InetAddress对象
        InetAddress localHost3 = InetAddress.getByName("www.baidu.com");
        System.out.println(localHost3);// www.baidu.com/39.156.70.239 （域名/ip地址）

        // 3. 通过InetAddress对象，获取对应主机名/域名
        String hostName = localHost1.getHostName();
        System.out.println(hostName);// LAPTOP-VNOOVHEB

        // 4. 通过InetAddress对象，获取对应IP地址
        String hostAddress = localHost1.getHostAddress();
        System.out.println(hostAddress);// 169.254.148.228
    }
}
