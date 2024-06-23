package com.airplaneWar.userInterface;

import com.airplaneWar.Main;
import com.airplaneWar.javaBean.LoginUser;
import com.airplaneWar.jdbc.DAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BeforeGameMenu extends JFrame implements ActionListener {
    // 设置登录用户成员，用于表示登录该界面的用户
    LoginUser loginUser = null;

    JButton btStartGame = new JButton("开始游戏");
    JButton btScoreBoard = new JButton("查看排行");
    JButton btLogin = new JButton("退出登录");
    JButton btExit = new JButton("退出");


    public BeforeGameMenu(LoginUser loginUser) {
        // 获取登录该窗口的用户
        this.loginUser = loginUser;

        // 为窗体添加对象
        add(btStartGame);
        add(btScoreBoard);
        add(btLogin);
        add(btExit);

        // 设置布局（流式布局）
        setLayout(new FlowLayout());
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
        btStartGame.addActionListener(this);
        btScoreBoard.addActionListener(this);
        btLogin.addActionListener(this);
        btExit.addActionListener(this);
    }


    // 实现动作监听按钮
    @Override
    public void actionPerformed(ActionEvent e) {
        // 当开始游戏按钮被按下
        if (e.getSource() == btStartGame) {
            // 将开启游戏的loginUser传给Main类中
            Main.loginUser = loginUser;
            // 关闭当前窗口
            this.dispose();
            // 将Main中的flag设置为true，表示开始游戏
            Main.flag = true;

        } else if (e.getSource() == btScoreBoard) {// 若按下查看排行
            // 打开该用户的成绩排行榜表格
            new ScoreBoardByOrder(DAO.getAirplaneScoreByOrder(loginUser.getUsername()));

        } else if (e.getSource() == btLogin) {
            // 关闭当前窗口，打开登录窗口
            this.dispose();
            new LoginFrame();

        } else if (e.getSource() == btExit) {// 若按下退出
            JOptionPane.showMessageDialog(this, "感谢游玩");
            // 结束程序运行
            System.exit(0);
        }
    }
}
