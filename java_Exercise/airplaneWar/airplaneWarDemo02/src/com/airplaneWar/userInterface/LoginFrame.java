package com.airplaneWar.userInterface;

import com.airplaneWar.game.gameMian.GameStart;
import com.airplaneWar.javaBean.LoginUser;
import com.airplaneWar.service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    // 定义登录相关对象
    JLabel lbUsername = new JLabel("请输入用户名");
    JTextField tfUsername = new JTextField(10);
    JLabel lbPassword = new JLabel("请输入密码");
    JTextField tfPassword = new JTextField(10);
    JButton btLogin = new JButton("登录");
    JButton btRegister = new JButton("前往注册");
    JButton btExit = new JButton("退出");


    public LoginFrame() {
        // 设置布局（流式布局）
        setLayout(new FlowLayout());

        // 为窗体添加对象
        add(lbUsername);
        add(tfUsername);
        add(lbPassword);
        add(tfPassword);
        add(btLogin);
        add(btRegister);
        add(btExit);

        // 设置窗口可见
        setVisible(true);
        // 设置窗口大小
        setSize(512, 768);
        // 设置窗口位置
        setLocationRelativeTo(null);
        // 设置窗口标题
        setTitle("airplane war register");
        // 设置关闭窗口时结束进程
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 为按钮添加动作监听
        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);
    }


    // 实现动作监听按钮
    @Override
    public void actionPerformed(ActionEvent e) {
        // 若动作源是btLogin（btLogin按钮被按下）
        if (e.getSource() == btLogin) {
            // 获取用户输入的用户名、密码
            String username = tfUsername.getText();
            String password = tfPassword.getText();

            LoginUser loginUser = new LoginUser(username, password);

            // 判断登录是否成功
            if (Service.isLoginInfoCorrect(loginUser)) {
                // 输出提示信息
                JOptionPane.showMessageDialog(this, "登录成功");
                // 关闭当前窗体
                this.dispose();
                // 开启BeforeGameMenu窗体
                new BeforeGameMenu(loginUser);

            } else {
                // 清空输入框文字
                tfUsername.setText("");
                tfPassword.setText("");
                JOptionPane.showMessageDialog(this, "账号密码错误，登录失败");
            }

        } else if (e.getSource() == btRegister) {// 若动作源是btRegister（注册按钮被按下）
            // 关闭登录窗体
            this.dispose();
            // 开启注册窗体
            new RegisterFrame();


        } else if (e.getSource() == btExit) {// 若动作源是btExit（退出按钮被按下）
            JOptionPane.showMessageDialog(this, "感谢游玩");
            // 结束程序运行
            System.exit(0);
        }
    }
}
