package com._02_AWT._02_Panel.Layout;

// 容器的布局
//
// (0)基本概念
//  容器有三种布局方式：流式布局、东西南北中布局、表格布局
//  ·为容器设置布局的两种方法：（二者参数都是布局类对象）
//  1.创建同时设置布局（只能是panel，不能是frame）
//      e.g.Panel panel = new panel(new BorderLayout());
//  2.通过setLayout()方法设置布局（frame和panel均可）
//      e.g.frame.setLayout(new FlowLayout(FlowLayout.LEFT));
//
//
//
// (1)流式布局（FlowLayout类）
//  语法：frame.setLayout(new FlowLayout(FlowLayout.LEFT));
//  构造器：
//  FlowLayout();// 默认居中对齐，水平、垂直间隙默认是5
//  FlowLayout(int align);// 传入对齐方式（FlowLayout.LEFT/CENTER/RIGHT分别表示左/居中/右对齐）
//  FlowLayout(int align, int hgap, int vgap);// 传入对齐方式，和水平垂直的间隙。
//
//
// (2)东西南北中布局（BorderLayout类）
//  语法：Frame frame = new frame(new BorderLayout());
//       frame.add(组件对象, BorderLayout.EAST);// 表示在东边（添加元素时，必须指定方为）
//  同理，组件还可以添加到EAST\WEST\SOUSE\NORTH\CENTER
//
//
// (3)表格布局
//  语法：frame.setLayout(new GridLayout(3, 2));
//  构造器：
//  public GridLayout();// 表格默认1行
//  public GridLayout(int rows, int cols);// 传入行、列
//  public GridLayout(int rows, int cols, int hgap, int vgap);// 传入行、列、水平间隙、垂直间隙
//  注意：表格布局遵循【行优先】
//      行优先，e.g. 1.若规定5行3列：假如你有10个元素，实际格式5行2列；若3个元素，实际格式5行1列，空2行
//                 2.若规定2行2列：假如你有10个元素，实际格式2行5列；若你有2个元素，实际格式2行1列
//                 以上，行数一定是规定的行数，列数是足够放下所有元素的最小列数
//
//
// (4)注意事项
//  在为容器设置布局后，流式布局、表格布局在add组件时，会将组件自动对齐
//  但是东西南北中布局，add时还须传入方位对象（如BorderLayout.EAST）


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Layout_ {
    public static void main(String[] args) {
        // 创建窗口frame对象
        Frame frame = new Frame("这是窗口");
        frame.setBounds(100, 100, 600, 600);
        frame.setVisible(true);

        // 新建组件对象 - 按钮
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        Button button4 = new Button("button4");
        Button button5 = new Button("button5");
        Button button6 = new Button("button6");


        // (1)流式布局
//        //frame.setLayout(new FlowLayout());// 默认居中
//        frame.setLayout(new FlowLayout(FlowLayout.LEFT));// 向左对齐
//        //frame.setLayout(new FlowLayout(FlowLayout.CENTER));// 居中
//        //frame.setLayout(new FlowLayout(FlowLayout.RIGHT));// 向右对齐
//        frame.add(button1);
//        frame.add(button2);
//        frame.add(button3);
//        frame.add(button4);
//        frame.add(button5);
//        frame.add(button6);


        // (2)东西南北中布局
//        frame.add(button1, BorderLayout.EAST);
//        frame.add(button2, BorderLayout.WEST);
//        frame.add(button3, BorderLayout.SOUTH);
//        frame.add(button4, BorderLayout.NORTH);
//        frame.add(button5, BorderLayout.CENTER);


        // (3)表格布局
//        frame.setLayout(new GridLayout(2, 2));// 规定行列，按行优先
//        //frame.setLayout(new GridLayout());// 默认一行
//        frame.add(button1);
//        frame.add(button2);
//        frame.add(button3);
//        frame.add(button4);
//        frame.add(button5);
//        frame.add(button6);


        // 为frame的关闭键添加事件监听器
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
