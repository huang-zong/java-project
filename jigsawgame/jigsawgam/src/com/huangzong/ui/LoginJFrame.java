package com.huangzong.ui;

import com.huangzong.domain.User;
import com.huangzong.util.CodeUtil;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener{
    //LoginJFrame 表示登录界面
    //所有登录相关的代码，写在这里


    //创建一个集合存储正确的用户名和密码
    static  ArrayList<User> list = new ArrayList<User>();
    static {
        list.add(new User("zhangsan" , "123"));
        list.add(new User("lisi" , "1234"));
    }

    //定义变量记录用户名
    String nameInput = "";
    //定义变量记录密码
    String passwordInput = "";
    //定义变量记录验证码
    String codeInput = "";

    //定义变量记录登录按钮路径
    String path = "jigsawgam\\image\\login\\登录按钮.png";

    //存储验证码
    String codeStr = CodeUtil.getCode();

    //创建对象
    JTextField username = new JTextField();
    JTextField password = new JTextField();
    JTextField code = new JTextField();
    JLabel rightCode = new JLabel();

    JButton login = new JButton();
    JButton register = new JButton();

    //定义空参构造，初始化界面
    public LoginJFrame(){
        //初始化界面
        initJFrame();
        //在这个界面添加内容
        initView();
        //设置界面是否显示
        this.setVisible(true);
    }

    //初始化界面
    private void initView() {
        //清空已经出现的所有图片
        this.getContentPane().removeAll();

        //1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("jigsawgam\\image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("jigsawgam\\image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //4.密码输入框
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //验证码提示
        JLabel codeText = new JLabel(new ImageIcon("jigsawgam\\image\\login\\验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        //验证码的输入框
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        //设置内容
        rightCode.setText(codeStr);
        //位置和宽高
        rightCode.setBounds(300, 256, 50, 30);
        //添加到界面
        this.getContentPane().add(rightCode);
        //添加鼠标监听事件
        rightCode.addMouseListener(this);

        //5.添加登录按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon(path));
        //去除按钮的默认边框
        login.setBorderPainted(false);
        //去除按钮的默认背景
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);
        //添加鼠标监听事件
        login.addMouseListener(this);

        //6.添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("jigsawgam\\image\\login\\注册按钮.png"));
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);
        //添加鼠标监听事件
        register.addMouseListener(this);

        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("jigsawgam\\image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);

        //刷新一下界面
        this.getContentPane().repaint();
    }

    //初始化界面
    private void initJFrame() {
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
    }

    //定义方法比较用户、密码、验证码
    public boolean compareInput(){
        //比较验证码
        if (!codeInput.equalsIgnoreCase(codeStr)){
            showJDialog("验证码错误");
            return false;
        }else {
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).getName().equals(nameInput) && list.get(i).getPassword().equals(passwordInput)){
                    System.out.println(list.get(i).getName() + "," + list.get(i).getPassword());
                    return true;
                }
            }
            showJDialog("用户名或密码错误");
            return false;
        }
    }

    //要展示用户名或密码错误
    public void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }

    //点击
    @Override
    public void mouseClicked(MouseEvent e) {
        //获取点击的条目对象
        Object obj = e.getSource();
        //获取用户输入的用户名
        nameInput = username.getText();
        //获取用户输入的密码
        passwordInput = password.getText();
        //获取用户输入的验证码
        codeInput = code.getText();
        //点击验证码
        if (obj == rightCode){
            System.out.println("点击了验证码");
            codeStr = CodeUtil.getCode();
            //修改验证码内容
            rightCode.setText(codeStr);
        }
        //点击注册按钮
        if (obj == register) {
            System.out.println("点击了注册按钮");
            new RegisterJFrame();
        }
        //点击登录按钮
        if (obj == login){
            System.out.println("点击了登录按钮");
            if (nameInput.isEmpty() || passwordInput.isEmpty()){
                showJDialog("用户名或密码为空");
                return;
            }else if (codeInput.isEmpty()){
                showJDialog("验证码为空");
                return;
            }
            boolean flag = compareInput();
            if (flag){
                //用户名、密码、验证码正确
                //关闭当前界面
                this.setVisible(false);
                //打开游戏界面
                new GameJFrame();
            }
        }
    }

    //按下不松调用方法
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
        //获取点击的条目对象
        Object obj = e.getSource();
        if (obj == login){
            //修改图片路径
            path = "jigsawgam\\image\\login\\登录按下.png";
            //修改图片
            login.setIcon(new ImageIcon(path));
        }else if (obj == register){
            path = "jigsawgam\\image\\register\\注册按下.png";
            register.setIcon(new ImageIcon(path));
        }
    }

    //松开调用方法
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开按钮");
        //获取点击的条目对象
        Object obj = e.getSource();
        if (obj == login){
            //修改图片路径
            path = "jigsawgam\\image\\login\\登录按钮.png";
            login.setIcon(new ImageIcon(path));
        }else if (obj == register){
            path = "jigsawgam\\image\\register\\注册按钮.png";
            register.setIcon(new ImageIcon(path));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
