package com.huangzong.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test01 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        //设置界面宽高
        jFrame.setSize(603 , 680);
        //设置界面标题
        jFrame.setTitle("事件演示");
        //设置界面置顶
        jFrame.setAlwaysOnTop(true);
        //设置界面居中
        jFrame.setLocationRelativeTo(null);
        //设置关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中设置，只有取消才会按照XY轴添加组件
        jFrame.setLayout(null);

        //设置按钮对象
        JButton jButton = new JButton("按钮");
        //设置按钮的位置和宽高
        jButton.setBounds(0 , 0 , 100 , 50);
        //给按钮对象添加监听（动作监听）(鼠标左键点击、空格）
        //1、匿名内部类方式
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了");
            }
        });

        //把按钮添加到界面当中
        jFrame.getContentPane().add(jButton);
        //设置界面是否显示
        jFrame.setVisible(true);
    }
}
