package com.chatRoom.server.view;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;


// 服务器端主界面
public class ServerFrame extends JFrame {

    int frameWidth = 550;// 设置本窗体的宽
    int frameHeight = 510;// 设置本窗体的高
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// 获取屏幕大小
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;

    // 添加组件
    JTextField txtNumber = new JTextField("0人", 10);// 在线人数框体
    JTextField txtServerName = new JTextField(10);// 服务器名称框体
    JTextField txtIP = new JTextField(10);// IP框体
    JTextField txtPort = new JTextField("8888", 10);// 端口号框体
    JTextPane txtLog = new JTextPane();// 服务器日志框体
    JList lstUser = new JList();// 用户列表


    // 构造器，用于设置窗体
    public ServerFrame() throws HeadlessException, UnknownHostException {
        // (1)设置窗体属性
        setTitle("服务端主界面");// 设置标题
        setSize(frameWidth, frameHeight);// 设置窗体大小
        setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);// 设置窗体位置居中
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭窗体时程序自动退出


        // (2)添加选项卡
        JTabbedPane tpServer = new JTabbedPane(JTabbedPane.TOP);// 创建选项卡
        tpServer.setBackground(Color.WHITE);// 设置颜色
        tpServer.setFont(new Font("宋体", 0, 18));// 设置大小


        // (3)绘制左侧选项卡--服务器信息
        JLabel serverInfoParam = getServerInfoParam();
        addServerLog(serverInfoParam);
        tpServer.add("服务器信息", serverInfoParam);


        // (4)绘制右侧选项卡--在线用户
        tpServer.add("在线用户", getOnlineUserPanel());
        add(tpServer);


        // (5)设置窗体可见（必须最后设置）
        setVisible(true);
    }


    // 获取服务器信息窗体（左侧选项卡-左）
    public JLabel getServerInfoParam() throws UnknownHostException {
        // 整个服务选项卡面板，包括日志区域
        JPanel jPanel = new JPanel();
        jPanel.setOpaque(false);
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, frameWidth, frameHeight);

        // 服务器参数面板，不包括日志区域
        JPanel serverParamPanel = new JPanel();
        serverParamPanel.setOpaque(false);
        serverParamPanel.setBounds(5, 5, 100, 400);
        serverParamPanel.setFont(new Font("宋体", 0, 14));
        serverParamPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(""),
                BorderFactory.createEmptyBorder(1, 1, 1, 1)));

        // ①显示在线人数
        // 人数标签
        JLabel lblNumber = new JLabel("当前在线人数:");
        lblNumber.setFont(new Font("宋体", 0, 14));
        serverParamPanel.add(lblNumber);
        // 人数框体
        txtNumber.setFont(new Font("宋体", 0, 14));
        txtNumber.setEditable(false);
        serverParamPanel.add(txtNumber);

        // ②显示服务器名称
        // 名称标签
        JLabel lblServerName = new JLabel("服务器名称:");
        lblServerName.setFont(new Font("宋体", 0, 14));
        serverParamPanel.add(lblServerName);
        // 名称框体
        txtServerName.setText(InetAddress.getLocalHost().getHostName());// 获取本机名称并设置
        txtServerName.setFont(new Font("宋体", 0, 14));
        txtServerName.setEditable(false);
        serverParamPanel.add(txtServerName);

        // ③显示服务器IP
        // IP标签
        JLabel lblIP = new JLabel("服务器IP:");
        lblIP.setFont(new Font("宋体", 0, 14));
        serverParamPanel.add(lblIP);
        // IP框体
        txtIP.setText(InetAddress.getLocalHost().getHostAddress());// 获取本机IP地址并设置
        txtIP.setFont(new Font("宋体", 0, 14));
        txtIP.setEditable(false);
        serverParamPanel.add(txtIP);

        // ④显示服务器端口
        // 端口标签
        JLabel lblPort = new JLabel("服务器端口:");
        lblPort.setFont(new Font("宋体", 0, 14));
        serverParamPanel.add(lblPort);
        // 端口框体
        txtPort.setFont(new Font("宋体", 0, 14));
        txtPort.setEditable(false);
        serverParamPanel.add(txtPort);

        // 将以上组件添加到外层窗体中
        jPanel.add(serverParamPanel);

        // 添加背景图片
        ImageIcon imageIcon = new ImageIcon("images/bg2.jpg");// 加载窗体的背景图片
        imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(750, 600, Image.SCALE_SMOOTH));// 将图片等比缩小
        JLabel jblBackground = new JLabel(imageIcon);// 创建一个标签并将图片添加进去
        jblBackground.setBounds(0, 0, frameWidth, frameHeight);
        jblBackground.add(jPanel);

        return jblBackground;
    }


    // 为外层窗体添加日志信息（左侧选项卡-右）
    public void addServerLog(JLabel jLabel) {
        // 日志标签
        JLabel lblLog = new JLabel("[服务器日志]");
        lblLog.setForeground(Color.BLACK);
        lblLog.setFont(new Font("宋体", 0, 16));
        lblLog.setBounds(130, 5, 100, 30);
        jLabel.add(lblLog);

        // 日志框体
        txtLog.setOpaque(false);
        // 设置滚动条
        JScrollPane scoPaneOne = new JScrollPane(txtLog);
        scoPaneOne.setBounds(130, 35, 340, 360);
        scoPaneOne.setOpaque(false);
        scoPaneOne.getViewport().setOpaque(false);
        txtLog.setFont(new Font("宋体", 0, 12));
        jLabel.add(scoPaneOne);

        // 添加关闭服务器按钮
        JButton stopBtn = getStopBtn();
        jLabel.add(stopBtn);

        // 添加保存日志按钮
        JButton saveLogBtn = getSaveLogBtn();
        jLabel.add(saveLogBtn);
    }


    // 获取关闭服务器按钮
    public JButton getStopBtn() {
        JButton stopBtn = new JButton("关闭服务器");
        stopBtn.setBackground(Color.WHITE);
        stopBtn.setFont(new Font("宋体", 0, 14));
        stopBtn.setBounds(200, 400, 110, 30);
        return stopBtn;
    }


    // 获取保存日志按钮
    public JButton getSaveLogBtn() {
        JButton saveLogBtn = new JButton("保存日志");
        saveLogBtn.setBackground(Color.WHITE);
        saveLogBtn.setFont(new Font("宋体", 0, 14));
        saveLogBtn.setBounds(320, 400, 110, 30);
        return saveLogBtn;
    }


    // 获取在线用户列表（右侧选项卡）
    public JLabel getOnlineUserPanel() {
        // 用户面板（外层窗体）
        JPanel pnlUser = new JPanel();
        pnlUser.setLayout(null);
        pnlUser.setBackground(new Color(52, 130, 203));
        pnlUser.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(""),
                BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        pnlUser.setBounds(frameWidth / 2 - 300 / 2, 5, 300, 400);
        pnlUser.setOpaque(false);//设置透明

        // 文字标签
        JLabel lblUser = new JLabel("[在线用户列表]");
        lblUser.setFont(new Font("宋体", 0, 16));
        lblUser.setBounds(50, 10, 200, 30);
        pnlUser.add(lblUser);

        // 用户列表
        lstUser.setFont(new Font("宋体", 0, 14));
        lstUser.setVisibleRowCount(17);
        lstUser.setFixedCellWidth(180);
        lstUser.setFixedCellHeight(18);
        lstUser.setOpaque(false);
        // 设置滚动条
        JScrollPane spUser = new JScrollPane(lstUser);
        spUser.setFont(new Font("宋体", 0, 14));
        spUser.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spUser.setBounds(50, 35, 200, 360);
        spUser.setOpaque(false);
        pnlUser.add(spUser);

        // 添加背景窗体
        ImageIcon imageIcon = new ImageIcon("images/bg2.jpg");// 加载窗体的背景图片
        imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_SMOOTH));// 将图片等比缩小
        JLabel jblBackground = new JLabel(imageIcon);// 创建一个标签并将图片添加进去
        jblBackground.add(pnlUser);

        return jblBackground;
    }


    // 记录日志信息
    public void log(String log) {
        // 获取日期
        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        // 书写日志
        if (txtLog.getText().equals("")) {
            txtLog.setText(format + " " + log);
        } else {
            txtLog.setText(txtLog.getText() + "\n" + format + " " + log);
        }
    }


    public static void main(String[] args) throws UnknownHostException {
        new ServerFrame();
    }


    public JTextField getTxtNumber() {
        return txtNumber;
    }

    public void setTxtNumber(JTextField txtNumber) {
        this.txtNumber = txtNumber;
    }

    public JTextField getTxtServerName() {
        return txtServerName;
    }

    public void setTxtServerName(JTextField txtServerName) {
        this.txtServerName = txtServerName;
    }

    public JTextField getTxtIP() {
        return txtIP;
    }

    public void setTxtIP(JTextField txtIP) {
        this.txtIP = txtIP;
    }

    public JTextField getTxtPort() {
        return txtPort;
    }

    public void setTxtPort(JTextField txtPort) {
        this.txtPort = txtPort;
    }

    public JTextPane getTxtLog() {
        return txtLog;
    }

    public void setTxtLog(JTextPane txtLog) {
        this.txtLog = txtLog;
    }

    public JList getLstUser() {
        return lstUser;
    }

    public void setLstUser(JList lstUser) {
        this.lstUser = lstUser;
    }
}
