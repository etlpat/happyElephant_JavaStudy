package com.airplaneWar.userInterface;

import com.airplaneWar.javaBean.UserScore;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;


// 用于绘制排行榜的类
public class ScoreBoardByOrder extends JFrame implements ActionListener {
    public static boolean scoreBoardIsOpen = false;
    // 创建按钮对象
    JButton btReturn = new JButton("关闭排行榜");


    public ScoreBoardByOrder(ArrayList<UserScore> userScores) {

        // (1)设置初始化参数
        // 设置流式布局
        setLayout(new FlowLayout());
        // 设置窗口大小
        int myHeight = 500;
        setSize(512, myHeight);
        // 获取屏幕大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2 - (758 - myHeight) / 2;
        // 设置窗口的位置
        setLocation(x, y); // 注意这里我们假设x轴位置为0，也就是屏幕左侧
        // 设置窗口标题
        setTitle("airplane war score board");
        // 设置关闭窗口时结束进程
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // (2)获取表格数据
        // 定义表格的列名
        String[] colNames = {"排名", "用户名", "游戏时间记录", "分数", "飞行距离"};
        // 定义表行中的数据
        String[][] data = new String[userScores.size()][colNames.length];
        for (int i = 0; i < userScores.size(); i++) {
            data[i][0] = i + 1 + "";
            data[i][1] = userScores.get(i).getUsername();
            data[i][2] = userScores.get(i).getGameDateTime().substring(0, userScores.get(i).getGameDateTime().length() - 2);
            data[i][3] = String.valueOf(userScores.get(i).getScore());
            data[i][4] = String.valueOf(userScores.get(i).getFlyDistance());
        }


        // (3)创建表格窗口
        // 1.创建表格模型
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, colNames);
        // 2.将表格模型放入JTable中
        JTable jTable = new JTable(defaultTableModel);
        // 3.设置列渲染器的对齐方式为居中
        //  创建居中器
        DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(JLabel.CENTER); // 设置水平居中
        //  遍历每列，使得表格元素居中
        TableColumnModel columnModel = jTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(defaultTableCellRenderer);
        }
        // 4.将JTable放入JScrollPane中以便滚动
        JScrollPane jScrollPane = new JScrollPane(jTable);
        // 5.将滚动面板添加到本窗口中
        this.getContentPane().add(jScrollPane);


        // (4)设置表格为可见的
        setVisible(true);

        // (5)为按钮添加监听器
        btReturn.addActionListener(this);

        add(btReturn);// 添加按钮对象
        setAlwaysOnTop(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btReturn) {
            scoreBoardIsOpen = false;
            this.dispose();
        }
    }
}