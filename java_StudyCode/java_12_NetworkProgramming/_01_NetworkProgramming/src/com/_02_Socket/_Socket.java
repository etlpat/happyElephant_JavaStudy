package com._02_Socket;


// Socket（套接字）
//
// (1)基本介绍
//  1.套接字(Socket)开发网络应用程序被广泛采用,以至于成为事实上的标准。
//  2.通信的两端都要有Socket,是两台机器间通信的端点
//  3.网络通信其实就是Socket间的通信。
//  4.Socket允许程序把网络连接当成一个流,数据在两个Socket间通过I/O传输。
//  5.一般主动发起通信的应用程序属客户端,等待通信请求的为服务端
//
//
// (2)socket的理解
//  【客户端-发起连接 [socket]】<-----数据通道----->【[socket] 服务端-接收连接】
//  如上，当我们需要通讯(读写数据)时：
//      1.socket.getOutputStream()
//      2.socket.getInputStream()
//

public class _Socket {
}
