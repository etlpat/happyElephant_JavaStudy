package com.airplaneWar.userInterface;

import com.airplaneWar.javaBean.User;
import com.airplaneWar.jdbc.DAO;
import com.airplaneWar.service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame implements ActionListener {
    // 定义注册相关对象
    JLabel lbUsername = new JLabel("请输入用户名");
    JTextField tfUsername = new JTextField(10);
    JLabel lbPassword1 = new JLabel("请输入注册密码");
    JTextField tfPassword1 = new JTextField(10);
    JLabel lbPassword2 = new JLabel("请再次确认密码");
    JTextField tfPassword2 = new JTextField(10);
    JLabel lbSex = new JLabel("请选择性别");
    JRadioButton rbSex1 = new JRadioButton("男", true);// true表示"男"默认被选中
    JRadioButton rbSex2 = new JRadioButton("女", false);
    ButtonGroup bgSex = new ButtonGroup();
    JLabel lbLevel = new JLabel("请选择您的玩家级别");
    JComboBox cbLevel = new JComboBox();
    JButton btRegister = new JButton("注册");
    JButton btLogin = new JButton("返回登录");
    JButton btExit = new JButton("退出");


    public RegisterFrame() {
        // 设置布局（流式布局）
        setLayout(new FlowLayout());

        // 为窗体添加对象
        add(lbUsername);
        add(tfUsername);
        add(lbPassword1);
        add(tfPassword1);
        add(lbPassword2);
        add(tfPassword2);
        add(lbSex);
        add(rbSex1);
        add(rbSex2);
        bgSex.add(rbSex1);// 将单选按钮添加到单选按钮组
        bgSex.add(rbSex2);
        add(lbLevel);
        add(cbLevel);
        cbLevel.addItem("新手玩家");// 将信息添加到组合框
        cbLevel.addItem("中级玩家");
        cbLevel.addItem("高级玩家");
        cbLevel.addItem("传奇玩家");
        add(btRegister);
        add(btLogin);
        add(btExit);

        // 设置窗口可见
        setVisible(true);
        // 设置窗口大小
        setSize(512, 768);
        // 设置窗口位置
        setLocationRelativeTo(null);
        // 设置窗口标题
        setTitle("airplane war login");
        // 设置关闭窗口时结束进程
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 为按钮添加动作监听
        btRegister.addActionListener(this);
        btLogin.addActionListener(this);
        btExit.addActionListener(this);
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
}
