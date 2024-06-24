package com.airplaneWar.userInterface;

import com.airplaneWar.game.gameMian.GameStart;
import com.airplaneWar.game.gameMian.GameUtils;
import com.airplaneWar.javaBean.LoginUser;
import com.airplaneWar.service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    // 定义登录相关对象
    JLabel lbTittle = new JLabel("<html><body style='font-size:30px;'><b>登录界面</b></body></html>");
    JLabel lbUsername = new JLabel("<html><body style='font-size:14px;'><b>请输入用户名:</b></body></html>");
    JTextField tfUsername = new JTextField(15);
    JLabel lbPassword = new JLabel("<html><body style='font-size:14px;'><b>请输入密码:</b></body></html>");
    JTextField tfPassword = new JTextField(15);
    JButton btLogin = new JButton("<html><body style='font-size:14px;'><b>登录</b></body></html>");
    JButton btRegister = new JButton("<html><body style='font-size:14px;'><b>前往注册</b></body></html>");
    JButton btExit = new JButton("<html><body style='font-size:14px;'><b>退出</b></body></html>");


    public LoginFrame() {
        // 设置布局
        setLayout(null);
        // 设置窗口大小
        setSize(512, 768);
        // 设置窗口位置
        setLocationRelativeTo(null);
        // 设置窗口标题
        setTitle("airplane war login");
        // 设置关闭窗口时结束进程
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // 设置全局JPanel参数
        Color color = GameUtils.getBabackgroundColor();
        int y0 = 80, y1 = 200, y2 = 300, y3 = 500;


        // 添加背景JPanel
        JPanel bgJP = new JPanel();
        bgJP.setLayout(null);
        bgJP.setBackground(color);
        setContentPane(bgJP);// 将bgJP填充到背景


        // 添加标题JPanel
        JPanel tittleJP = new JPanel();
        tittleJP.setBounds(0, y0, 512, 80);
        tittleJP.setBackground(color);
        tittleJP.add(lbTittle);
        bgJP.add(tittleJP);


        // 添加用户名JPanel
        tfUsername.setPreferredSize(new Dimension(0, 35));
        JPanel usernameJP = new JPanel();
        usernameJP.setBounds(0, y1, 512, 40);
        usernameJP.setBackground(color);
        usernameJP.add(lbUsername);
        usernameJP.add(tfUsername);
        bgJP.add(usernameJP);


        // 添加密码JPanel
        tfPassword.setPreferredSize(new Dimension(0, 35));
        JPanel passwordJP = new JPanel();
        passwordJP.setBounds(0, y2, 512, 40);
        passwordJP.setBackground(color);
        passwordJP.add(lbPassword);
        passwordJP.add(tfPassword);
        bgJP.add(passwordJP);


        // 添加按钮JPanel
        JPanel buttonJP = new JPanel();
        buttonJP.setBounds(0, y3, 512, 40);
        buttonJP.setBackground(color);
        buttonJP.add(btLogin);
        buttonJP.add(btRegister);
        buttonJP.add(btExit);
        bgJP.add(buttonJP);


        // 为按钮添加动作监听
        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);

        // 设置窗口可见
        setVisible(true);
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


    public static void main(String[] args) {
        new LoginFrame();
    }
}
