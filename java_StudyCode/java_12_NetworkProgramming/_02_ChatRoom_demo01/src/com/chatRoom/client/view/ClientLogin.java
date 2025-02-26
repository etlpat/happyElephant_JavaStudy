package com.chatRoom.client.view;

import com.chatRoom.Util.IOStreamUtil;
import com.chatRoom.client.ClientHandler;
import com.chatRoom.javaBean.ChatStatus;
import com.chatRoom.javaBean.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;


// 客户端的登录界面
public class ClientLogin extends JFrame {

    int frameWidth = 400;// 设置本窗体的宽
    int frameHeight = 300;// 设置本窗体的高
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// 获取屏幕大小
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    ClientLogin clientLogin = this;

    // 定义组件
    JLabel lbUsername = new JLabel("账号：");
    JTextField tfUsername = new JTextField();
    JLabel lbPassword = new JLabel("密码：");
    JPasswordField pfPassword = new JPasswordField();
    JButton btLogin = new JButton("登录");
    JButton btExit = new JButton("取消");


    // 构造器，用于设置窗体
    public ClientLogin() throws HeadlessException {

        // (1)设置窗体属性
        setTitle("客户端登录");// 设置标题
        setSize(frameWidth, frameHeight);// 设置窗体大小
        setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);// 设置窗体位置居中
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭窗体时程序自动退出
        setLayout(null);// 设置布局


        // (2)设置背景图片窗体
        ImageIcon imageIcon = new ImageIcon("images/bg1.jpg");// 加载窗体的背景图片
        imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH));// 将图片等比缩小
        JLabel jblBackground = new JLabel(imageIcon);// 创建一个标签并将图片添加进去
        jblBackground.setBounds(0, 0, frameWidth, frameHeight);
        jblBackground.setLayout(null);
        this.add(jblBackground);// 将背景窗体添加到最外层窗体中


        // (3)添加窗体组件
        // 账号标签
        lbUsername.setBounds(80, 40, 120, 30);// 设置坐标、大小
        lbUsername.setFont(new Font("宋体", 0, 16));// 设置字体
        lbUsername.setForeground(Color.WHITE);// 设置颜色
        jblBackground.add(lbUsername);

        // 账号文本框
        tfUsername.setBounds(150, 40, 160, 30);
        jblBackground.add(tfUsername);

        // 密码标签
        lbPassword.setBounds(80, 80, 120, 30);// 设置坐标、大小
        lbPassword.setFont(new Font("宋体", 0, 16));// 设置字体
        lbPassword.setForeground(Color.WHITE);// 设置颜色
        jblBackground.add(lbPassword);

        // 密码框
        pfPassword.setBounds(150, 80, 160, 30);
        jblBackground.add(pfPassword);

        // 登录按钮
        setBtLogin(this);// 调用设置登录按钮的方法
        jblBackground.add(btLogin);


        // 退出按钮
        setBtExit();// 调用设置退出按钮的方法
        jblBackground.add(btExit);


        // (4)设置窗体可见（必须最后设置）
        setVisible(true);
    }


    // 用于设置登录按钮（点击事件）
    public void setBtLogin(ClientLogin clientLogin) {
        btLogin.setBounds(110, 170, 80, 25);

        // 点击登录按钮，触发监听器
        btLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取用户登录信息
                User user = new User(tfUsername.getText(), pfPassword.getText());
                user.setChatStatus(ChatStatus.LOGIN);// 设置为登录状态

                try {
                    // 当点击登录，与服务端建立连接
                    Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

                    // 将用户登录信息user，传给服务端
                    IOStreamUtil.writeMessage(socket, user);

                    // 开辟一个clientHandler线程，用于循环读取，形成长连接
                    // 一个线程对应一次Login+Chat流程，因此本次Login的线程需要为其传入本次连接的socket和本login窗体
                    ClientHandler clientHandler = new ClientHandler(socket, clientLogin, user.getUsername());
                    clientHandler.start();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    // 用于设置退出按钮（点击事件）
    public void setBtExit() {
        btExit.setBounds(215, 170, 80, 25);
        // 当点击退出，关闭窗体
        btExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientLogin.dispose();
            }
        });
    }


    public static void main(String[] args) {
        new ClientLogin();
    }
}
