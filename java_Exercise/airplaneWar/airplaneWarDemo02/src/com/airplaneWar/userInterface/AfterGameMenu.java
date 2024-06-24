package com.airplaneWar.userInterface;

import com.airplaneWar.game.gameMian.GameUtils;
import com.airplaneWar.javaBean.UserScore;
import com.airplaneWar.jdbc.DAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AfterGameMenu extends JFrame implements ActionListener {
    // 设置分数表用户对象
    UserScore userScore = null;
    JLabel lbTittle = null;
    ScoreBoardByOrder scoreBoardByOrder = null;
    JButton btScoreBoard = new JButton("<html><body style='font-size:14px;'><b>查看排行</b></body></html>");
    JButton btExit = new JButton("<html><body style='font-size:14px;'><b>退出</b></body></html>");


    public AfterGameMenu(UserScore userScore) {
        // 获取登录该窗口的用户
        this.userScore = userScore;
        // 获取用户对应的lbTittle
        lbTittle = new JLabel("<html><body style='font-size:20px;'><b>用户" + userScore.getUsername() +
                ",游戏结束了!</b></body></html>");
        // 将本次分数添加到分数排行榜中
        DAO.insertAirplaneScoreBoard(userScore);


        // 设置布局
        setLayout(null);
        // 设置窗口大小
        setSize(512, 768);
        // 设置窗口位置
        setLocationRelativeTo(null);
        // 设置窗口标题
        setTitle("airplane war after game menu");
        // 设置关闭窗口时结束进程
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // 设置全局JPanel参数
        Color color = GameUtils.getBabackgroundColor();
        int y0 = 540, y1 = 620;


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


        // 添加按钮JPanel
        JPanel buttonJP = new JPanel();
        buttonJP.setBounds(0, y1, 512, 40);
        buttonJP.setBackground(color);
        buttonJP.add(btScoreBoard);
        buttonJP.add(btExit);
        bgJP.add(buttonJP);


        // 为按钮添加动作监听
        btScoreBoard.addActionListener(this);
        btExit.addActionListener(this);

        // 设置窗口可见
        setVisible(true);
    }


    // 实现动作监听按钮
    @Override
    public void actionPerformed(ActionEvent e) {
        // 若按下查看排行
        if (e.getSource() == btScoreBoard) {
            if (ScoreBoardByOrder.scoreBoardIsOpen == false) {
                // 打开该用户的成绩排行榜表格
                scoreBoardByOrder = new ScoreBoardByOrder(DAO.getAirplaneScoreByOrder(userScore.getUsername()));
                ScoreBoardByOrder.scoreBoardIsOpen = true;
            }
        } else if (e.getSource() == btExit) {// 若按下退出
            if (ScoreBoardByOrder.scoreBoardIsOpen == false) {
                JOptionPane.showMessageDialog(this, "感谢游玩");
            }
            // 结束程序运行
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new AfterGameMenu(new UserScore());
    }
}
