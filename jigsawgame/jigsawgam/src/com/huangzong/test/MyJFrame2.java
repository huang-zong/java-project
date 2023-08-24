package com.huangzong.test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {

    //创建一个按钮对象
    JButton jButton = new JButton("按钮");
    public MyJFrame2() {
        //设置界面宽高
        this.setSize(603, 680);
        //设置界面标题
        this.setTitle("事件演示");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中位置，只有取消了才可以按照XY轴添加组件
        this.setLayout(null);

        //给按钮设置位置和宽高
        jButton.setBounds(0, 0 , 100 ,50);
        //给按钮绑定鼠标监听事件
        jButton.addMouseListener(this);

        //把按钮添加到界面中
        this.getContentPane().add(jButton);

        //设置界面显示
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
