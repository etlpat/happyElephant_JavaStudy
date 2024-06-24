package com.airplaneWar.userInterface;

import com.airplaneWar.game.gameMian.GameUtils;
import com.airplaneWar.javaBean.User;
import com.airplaneWar.jdbc.DAO;
import com.airplaneWar.service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame implements ActionListener {
    // 定义注册相关对象
    JLabel lbTittle = new JLabel("<html><body style='font-size:30px;'><b>注册界面</b></body></html>");
    JLabel lbUsername = new JLabel("<html><body style='font-size:14px;'><b>请输入用户名:</b></body></html>");
    JTextField tfUsername = new JTextField(15);
    JLabel lbPassword1 = new JLabel("<html><body style='font-size:14px;'><b>请输入注册密码:</b></body></html>");
    JTextField tfPassword1 = new JTextField(15);
    JLabel lbPassword2 = new JLabel("<html><body style='font-size:14px;'><b>请再次确认密码:</b></body></html>");
    JTextField tfPassword2 = new JTextField(15);
    JLabel lbSex = new JLabel("<html><body style='font-size:14px;'><b>请选择性别:&nbsp&nbsp</b></body></html>");
    JRadioButton rbSex1 = new JRadioButton("男", true);// true表示"男"默认被选中
    JRadioButton rbSex2 = new JRadioButton("女", false);
    ButtonGroup bgSex = new ButtonGroup();
    JLabel lbLevel = new JLabel("<html><body style='font-size:14px;'><b>请选择级别:&nbsp&nbsp&nbsp</b></body></html>");
    JComboBox cbLevel = new JComboBox();
    JButton btRegister = new JButton("<html><body style='font-size:14px;'><b>注册</b></body></html>");
    JButton btLogin = new JButton("<html><body style='font-size:14px;'><b>返回登录</b></body></html>");
    JButton btExit = new JButton("<html><body style='font-size:14px;'><b>退出</b></body></html>出");


    public RegisterFrame() {
        // 设置布局
        setLayout(null);
        // 设置窗口大小
        setSize(512, 768);
        // 设置窗口位置
        setLocationRelativeTo(null);
        // 设置窗口标题
        setTitle("airplane war register");
        // 设置关闭窗口时结束进程
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // 设置全局JPanel参数
        Color color = GameUtils.getBabackgroundColor();
        int y0 = 80, y1 = 200, y2 = 270, y3 = 320, y4 = 390, y5 = 450, y6 = 550;


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


        // 添加密码1的JPanel
        tfPassword1.setPreferredSize(new Dimension(0, 35));
        JPanel password1JP = new JPanel();
        password1JP.setBounds(0, y2, 512, 40);
        password1JP.setBackground(color);
        password1JP.add(lbPassword1);
        password1JP.add(tfPassword1);
        bgJP.add(password1JP);


        // 添加密码2的JPanel
        tfPassword2.setPreferredSize(new Dimension(0, 35));
        JPanel password2JP = new JPanel();
        password2JP.setBounds(0, y3, 512, 40);
        password2JP.setBackground(color);
        password2JP.add(lbPassword2);
        password2JP.add(tfPassword2);
        bgJP.add(password2JP);


        // 添加性别的JPanel
        JPanel sexJP = new JPanel();
        sexJP.setBounds(0, y4, 512, 40);
        sexJP.setBackground(color);
        sexJP.add(lbSex);
        sexJP.add(rbSex1);
        sexJP.add(rbSex2);
        bgSex.add(rbSex1);// 将按钮添加到单选框
        bgSex.add(rbSex2);
        bgJP.add(sexJP);


        // 添加级别的JPanel
        JPanel levelJP = new JPanel();
        levelJP.setBounds(0, y5, 512, 40);
        levelJP.setBackground(color);
        levelJP.add(lbLevel);
        levelJP.add(cbLevel);
        cbLevel.addItem("新手玩家");// 将信息添加到组合框
        cbLevel.addItem("中级玩家");
        cbLevel.addItem("高级玩家");
        cbLevel.addItem("传奇玩家");
        bgJP.add(levelJP);


        // 添加按钮JPanel
        JPanel buttonJP = new JPanel();
        buttonJP.setBounds(0, y6, 512, 40);
        buttonJP.setBackground(color);
        buttonJP.add(btRegister);
        buttonJP.add(btLogin);
        buttonJP.add(btExit);
        bgJP.add(buttonJP);


        // 为按钮添加动作监听
        btRegister.addActionListener(this);
        btLogin.addActionListener(this);
        btExit.addActionListener(this);

        // 设置窗口可见
        setVisible(true);
    }


    // 实现动作监听按钮
    @Override
    public void actionPerformed(ActionEvent e) {

        // 若动作源是btRegister（注册按钮被按下）
        if (e.getSource() == btRegister) {
            // (1)获取注册信息
            String username = tfUsername.getText();
            String password1 = tfPassword1.getText();
            String password2 = tfPassword2.getText();
            String sex = rbSex1.isSelected() ? rbSex1.getText() : rbSex2.getText();
            String level = cbLevel.getSelectedItem().toString();


            // (2)判断输入的两个密码是否相等
            if (!password1.equals(password2)) {
                // 若两次密码不相等，清空密码框，并输出提示信息
                tfPassword1.setText("");
                tfPassword2.setText("");
                JOptionPane.showMessageDialog(this, "两次密码不相等");

            } else {
                // (3)判断用户名是否为空，或""
                if (username == null || username.equals("")) {
                    JOptionPane.showMessageDialog(this, "用户名不能为空");

                } else {
                    // (4)判断用户名是否与已注册的用户重复
                    User user = new User(username, password1, sex, level);
                    if (Service.isRegisterInfoCorrect(user) && DAO.insertAirplaneUsers(user)) {
                        // 若输入的用户名不重复，且信息能成功加入数据库，注册成功
                        // 输出提示信息
                        JOptionPane.showMessageDialog(this, "注册成功");
                        // 关闭当前窗体
                        this.dispose();
                        // 打开登录窗体
                        new LoginFrame();

                    } else {
                        // 否则用户名重复，清空文本框信息
                        tfUsername.setText("");
                        tfPassword1.setText("");
                        tfPassword2.setText("");
                        rbSex1.setSelected(true);
                        rbSex2.setSelected(false);
                        cbLevel.setSelectedIndex(0);
                        // 打印提示信息
                        JOptionPane.showMessageDialog(this, "注册失败，用户已存在");
                    }
                }
            }


        } else if (e.getSource() == btLogin) {// 当返回登录按钮被按下
            // 输出提示信息
            JOptionPane.showMessageDialog(this, "您并未注册用户");
            // 关闭当前窗体
            this.dispose();
            // 打开登录窗体
            new LoginFrame();


        } else if (e.getSource() == btExit) {// 当退出按钮被按下
            JOptionPane.showMessageDialog(this, "感谢游玩");
            // 结束程序运行
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        new RegisterFrame();
    }
}
