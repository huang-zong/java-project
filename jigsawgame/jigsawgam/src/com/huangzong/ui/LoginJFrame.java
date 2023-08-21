package com.huangzong.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //LoginJFrame 表示登录界面
    //所有登录相关的代码，写在这里

    //定义空参构造，初始化界面
    public LoginJFrame(){
        //设置界面大小
        this.setSize(488 , 430);
        //设置界面标题
        this.setTitle("拼图 登录");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面的关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置界面是否显示
        this.setVisible(true);
    }
}
