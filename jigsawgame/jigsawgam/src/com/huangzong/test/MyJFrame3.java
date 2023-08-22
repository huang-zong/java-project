package com.huangzong.test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {
    public MyJFrame3() {
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

        //给整个窗体添加键盘监听
        //调用者this:本类对象，当前的界面对象，表示要给整个界面添加监听
        //addKsyListener:表示给界面添加键盘监听
        //参数this:当事件被触发后，会执行本类中的代码
        this.addKeyListener(this);

        //设置界面显示
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开按键");
        //获取键盘按下的字符
        char keyChar = e.getKeyChar();
        System.out.println(keyChar);
    }
}
