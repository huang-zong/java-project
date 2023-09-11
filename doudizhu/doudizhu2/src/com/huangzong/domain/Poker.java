package com.huangzong.domain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Poker extends JLabel implements MouseListener{
    //牌的名字，格式数字-数字
    private String name;
    //牌显示正面还是反面
    private boolean up;
    //牌是否可以被点击
    private boolean canClick = false;
    //牌是否已经被点击
    private boolean clicked = false;

    //有参构造
    public Poker(String name , boolean up){
        this.name = name;
        this.up = up;

        //判断当前的牌是显示正面还是反面
        if (this.up){
            //显示正面
            turnFront();
        }else {
            //显示反面
            turnRear();
        }

        //设置牌的宽高
        this.setSize(71,96);
        //设置牌是否显示
        this.setVisible(true);
        //给每一张牌添加监听
        this.addMouseListener(this);
    }

    //显示正面
    public void turnFront(){
        //给牌设置正面
        this.setIcon(new ImageIcon("doudizhu2\\image\\poker\\" + name + ".png"));
        //修改成员变量
        this.up = true;
    }
    //显示背面
    public void turnRear(){
        //给牌设置背面
        this.setIcon(new ImageIcon("doudizhu2\\image\\poker\\rear.png"));
        //修改成员变量
        this.up = false;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        //点击
        //判断当前的牌是否可以被点击
        if (canClick){
            //牌被点击
            //定义变量表示牌的位移
            int step = 0;
            if (clicked){
                //已经被点击
                //降落
                step = 20;
            }else {
                //没有被点击
                //升起
                step = -20;
            }
            //修改clicked的值
            clicked = !clicked;
            //修改牌的位置
            Point location = this.getLocation();
            //创建一个对象，表示结束位置
            Point point = new Point(location.x , location.y + step);
            //更新牌的位置
            this.setLocation(point);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isCanClick() {
        return canClick;
    }

    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
