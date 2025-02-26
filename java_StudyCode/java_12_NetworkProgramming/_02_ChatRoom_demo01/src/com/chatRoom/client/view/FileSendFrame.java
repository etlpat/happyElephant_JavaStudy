package com.chatRoom.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.Socket;


// 用于发送文件的文本框
public class FileSendFrame extends JFrame {

    int frameWidth = 450;// 设置本窗体的宽
    int frameHeight = 210;// 设置本窗体的高
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// 获取屏幕大小
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    final int MIN_PROGRESS = 0;// 进度条最小进度
    final int MAX_PROGRESS = 100;// 进度条最大进度
    int currentProgress = 0;// 当前进度
    Socket socket;


    public FileSendFrame(Socket socket) {
        this();
        this.socket = socket;
    }


    // 传输文件的文本框
    public FileSendFrame() {
        // (1)设置窗体属性
        setTitle("文件发送");// 设置标题
        setSize(frameWidth, frameHeight);// 设置窗体大小
        setLocation(screenWidth / 2 - frameWidth / 2, screenHeight / 2 - frameHeight / 2);// 设置窗体位置居中
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭窗体时程序自动退出
        setLayout(null);// 设置布局

        // (2)创建文件路径标签
        JLabel fileLabel = new JLabel("文件路径:");
        fileLabel.setBounds(60, 20, 150, 30);//设置位置、大小
        fileLabel.setFont(new Font("宋体", 0, 16));
        fileLabel.setForeground(Color.BLACK);
        add(fileLabel);

        // (3)创建文件路径文本框
        JTextField filePathField = new JTextField();
        filePathField.setBounds(150, 20, 240, 30);
        add(filePathField);


        // (4)创建选择文件按钮
        JButton selectFileBtn = new JButton("选择文件");
        selectFileBtn.setBounds(60, 130, 130, 25);
        add(selectFileBtn);
        // 鼠标点击事件：提供文件选择器，选择指定文件（将文件的绝对路径放入filePathField文本框）
        selectFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建文件选择器
                JFileChooser jFileChooser = new JFileChooser();
                // 设置为仅能获取文件，不能获取文件夹
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                // 打开文件选择窗体，并获取操作后的状态
                int state = jFileChooser.showDialog(new JLabel(), "选择文件");
                if (state == JFileChooser.CANCEL_OPTION) {// 若点击取消按钮
                    return;
                } else {// 若选择了指定文件
                    // 获取被选择的文件
                    File file = jFileChooser.getSelectedFile();
                    // 将该文件的绝对路径赋给文件路径文本框
                    filePathField.setText(file.getAbsolutePath());
                }
            }
        });


        // (5)创建发送文件按钮
        JButton sendFileBtn = new JButton("发送文件");
        sendFileBtn.setBounds(250, 130, 140, 25);
        add(sendFileBtn);
        // 鼠标点击事件
        sendFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 获取文本框中的文件绝对路径
                    String fieldPath = filePathField.getText();
                    // 若路径为空，不做任何操作
                    if (fieldPath.equals("") || fieldPath == null) {
                        return;
                    } else {// 处理并上传文件
                        // 将文件读取到内存中
//                        File file = new File(fieldPath);// 获取文件路径
//                        FileInputStream fileInputStream = new FileInputStream(file);// 获取文件输入流
//                        int available = fileInputStream.available();// 读取文件的字节数
//                        byte[] bytes = new byte[available];// 创建与文件大小相等的字节数组
//                        fileInputStream.read(bytes);// 将文件数据放入字节数组中

                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });


        // (6)创建文件传输进度条
        setProgressBar(this);

        // (7)设置窗体可视化
        setVisible(true);
    }


    // 用于设置滚动条
    public void setProgressBar(JFrame jFrame) {
        // ①设置初始属性
        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(60, 80, 330, 25);
        progressBar.setMinimum(MIN_PROGRESS);// 设置最小值
        progressBar.setMaximum(MAX_PROGRESS);// 设置最大值
        progressBar.setValue(currentProgress);// 设置当前进度值
        progressBar.setStringPainted(true);// 绘制百分比文本(进度条中间显示的百分数)
        jFrame.add(progressBar);

//        // ②添加进度改变通知
//        progressBar.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                System.out.println("当前进度值:" + progressBar.getValue() + "; "
//                        + "进度百分比:" + progressBar.getPercentComplete());
//            }
//        });
//
//        // ③模拟延时操作进度,每隔time毫秒更新进度
//        int time = 50;
//        new Timer(time, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (currentProgress < MAX_PROGRESS) {
//                    currentProgress++;
//                } else if (currentProgress == MAX_PROGRESS) {
//                    progressBar.setString("传输完成");
//                }
//                progressBar.setValue(currentProgress);
//            }
//        }).start();
    }


    public static void main(String[] args) {
        new FileSendFrame();
    }
}
