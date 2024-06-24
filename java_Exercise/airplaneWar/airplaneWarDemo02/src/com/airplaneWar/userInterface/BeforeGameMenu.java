package com.airplaneWar.userInterface;

import com.airplaneWar.Main;
import com.airplaneWar.game.gameMian.GameUtils;
import com.airplaneWar.javaBean.LoginUser;
import com.airplaneWar.jdbc.DAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BeforeGameMenu extends JFrame implements ActionListener {
    // 设置登录用户成员，用于表示登录该界面的用户
    LoginUser loginUser = null;
    // 用于记录当前页面打开的排行榜窗口
    ScoreBoardByOrder scoreBoardByOrder = null;
    JLabel lbTittle = null;
    JButton btStartGame = new JButton("<html><body style='font-size:14px;'><b>开始游戏</b></body></html>");
    JButton btScoreBoard = new JButton("<html><body style='font-size:14px;'><b>查看排行</b></body></html>");
    JButton btLogin = new JButton("<html><body style='font-size:14px;'><b>退出登录</b></body></html>");
    JButton btExit = new JButton("<html><body style='font-size:14px;'><b>退出</b></body></html>");


    public BeforeGameMenu(LoginUser loginUser) {
        // 获取登录该窗口的用户
        this.loginUser = loginUser;
        lbTittle = new JLabel("<html><body style='font-size:20px;'><b>用户" + loginUser.getUsername() +
                ",你好!</b></body></html>");

        // 设置布局
        setLayout(null);
        // 设置窗口大小
        setSize(512, 768);
        // 设置窗口位置
        setLocationRelativeTo(null);
        // 设置窗口标题
        setTitle("airplane war before game menu");
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
        buttonJP.add(btStartGame);
        buttonJP.add(btScoreBoard);
        buttonJP.add(btLogin);
        buttonJP.add(btExit);
        bgJP.add(buttonJP);


        // 为按钮添加动作监听
        btStartGame.addActionListener(this);
        btScoreBoard.addActionListener(this);
        btLogin.addActionListener(this);
        btExit.addActionListener(this);

        // 设置窗口可见
        setVisible(true);
    }


    // 实现动作监听按钮
    @Override
    public void actionPerformed(ActionEvent e) {
        // 当开始游戏按钮被按下
        if (e.getSource() == btStartGame) {
            // 将开启游戏的loginUser传给Main类中
            Main.loginUser = loginUser;
            // 若排行榜开启,关闭排行榜
            if (ScoreBoardByOrder.scoreBoardIsOpen && scoreBoardByOrder != null) {
                scoreBoardByOrder.dispose();
                ScoreBoardByOrder.scoreBoardIsOpen = false;
            }
            // 关闭当前窗口
            this.dispose();
            // 将Main中的flag设置为true，表示开始游戏
            Main.flag = true;

        } else if (e.getSource() == btScoreBoard) {// 若按下查看排行
            if (ScoreBoardByOrder.scoreBoardIsOpen == false) {
                // 打开该用户的成绩排行榜表格
                scoreBoardByOrder = new ScoreBoardByOrder(DAO.getAirplaneScoreByOrder(loginUser.getUsername()));
                ScoreBoardByOrder.scoreBoardIsOpen = true;
            }

        } else if (e.getSource() == btLogin) {// 关闭当前窗口，打开登录窗口
            // 若排行榜开启,关闭排行榜
            if (ScoreBoardByOrder.scoreBoardIsOpen && scoreBoardByOrder != null) {
                scoreBoardByOrder.dispose();
                ScoreBoardByOrder.scoreBoardIsOpen = false;
            }
            this.dispose();
            new LoginFrame();

        } else if (e.getSource() == btExit) {// 若按下退出
            if (ScoreBoardByOrder.scoreBoardIsOpen == false) {
                JOptionPane.showMessageDialog(this, "感谢游玩");
            }
            // 结束程序运行
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        new BeforeGameMenu(new LoginUser());
    }
}
