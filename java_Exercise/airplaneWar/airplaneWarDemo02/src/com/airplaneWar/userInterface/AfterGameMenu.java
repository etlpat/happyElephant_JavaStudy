package com.airplaneWar.userInterface;

import com.airplaneWar.javaBean.UserScore;
import com.airplaneWar.jdbc.DAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AfterGameMenu extends JFrame implements ActionListener {
    // 设置分数表用户对象
    UserScore userScore = null;

    JButton btScoreBoard = new JButton("查看排行");
    JButton btExit = new JButton("退出");


    public AfterGameMenu(UserScore userScore) {
        // 获取登录该窗口的用户
        this.userScore = userScore;
        // 将本次分数添加到分数排行榜中
        DAO.insertAirplaneScoreBoard(userScore);

        // 为窗体添加对象
        add(btScoreBoard);
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
        btScoreBoard.addActionListener(this);
        btExit.addActionListener(this);
    }


    // 实现动作监听按钮
    @Override
    public void actionPerformed(ActionEvent e) {
        // 若按下查看排行
        if (e.getSource() == btScoreBoard) {
            // 打开该用户的成绩排行榜表格
            new ScoreBoardByOrder(DAO.getAirplaneScoreByOrder(userScore.getUsername()));

        } else if (e.getSource() == btExit) {// 若按下退出
            JOptionPane.showMessageDialog(this, "感谢游玩");
            // 结束程序运行
            System.exit(0);
        }
    }
}
