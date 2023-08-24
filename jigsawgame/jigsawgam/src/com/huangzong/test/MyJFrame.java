package com.huangzong.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {

    //创建一个按钮对象
    JButton jButton1 = new JButton("按钮1");
    //创建一个按钮对象
    JButton jButton2 = new JButton("按钮2");
    public MyJFrame(){
        //设置界面宽高
        this.setSize(603 , 680);
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



        //设置按钮的位置和宽高
        jButton1.setBounds(0 , 0 , 100 , 50);
        //给按钮添加事件
        jButton1.addActionListener(this); //this 传递本类对象


        //设置按钮的位置和宽高
        jButton2.setBounds(100 , 0 , 100 ,50 );
        //给按钮添加事件
        jButton2.addActionListener(this);

        //把按钮添加到整个界面当中
        this.getContentPane().add(jButton1);
        this.getContentPane().add(jButton2);

        //设置界面显示
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //对当前的按钮进行判断
        //过去当前被操作的按钮对象
        Object source = e.getSource();
        if (source == jButton1){
            //修改按钮宽高
            jButton1.setSize(200 , 200 );
        }else if (source == jButton2){
            Random r = new Random();
            //修改按钮位置
            jButton2.setLocation(r.nextInt(500) , r.nextInt(500));
        }

    }
}
