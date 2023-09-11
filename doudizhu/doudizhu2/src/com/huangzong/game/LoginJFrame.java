package com.huangzong.game;

import com.huangzong.domain.User;
import com.huangzong.util.CodeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {

    //创建集合存储
    static ArrayList<User> allUsers = new ArrayList<>();
    //静态代码块存储初始化用户名和密码
    static {
        allUsers.add(new User("zhangsan" , "1234567"));
        allUsers.add(new User("lisi" , "123456"));
    }

    //创建登录按钮对象
    JButton login = new JButton();
    //创建注册按钮对象
    JButton register = new JButton();
    //创建用户名输入框
    JTextField username = new JTextField();
    //创建密码输入框，密文输入
    JPasswordField password = new JPasswordField();
    //创建验证码输入框
    JTextField code = new JTextField();

    //正确的验证码
    JLabel rightCode = new JLabel();
    //获取正确的验证码
    String codeStr = CodeUtil.getCode();


    //空参构造
    public LoginJFrame() {
        //初始化界面
        initJFrame();
        //初始化组件，在这个界面中添加内容
        initView();
        //让当前界面显示出来
        this.setVisible(true);
    }

    //在这个界面中添加内容
    public void initView() {
        //清空已经出现的所有图片
        this.getContentPane().removeAll();
        //1. 添加用户名文字
        //创建字体格式对象
        Font usernameFont = new Font(null,1,16);
        //创建用户名对象
        JLabel usernameText = new JLabel("用户名");
        //设置字体颜色
        usernameText.setForeground(Color.white);
        //设置用户名字体格式
        usernameText.setFont(usernameFont);
        //设置用户名框位置和宽高
        usernameText.setBounds(140, 55, 55, 22);
        //将用户名框加入整个界面中
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框
        //设置用户名输入框位置和宽高
        username.setBounds(223, 46, 200, 30);
        //将用户名输入框加入整个界面
        this.getContentPane().add(username);

        //3.添加密码文字
        //创建密码对象
        JLabel passwordText = new JLabel("密码");
        //创建字体格式对象
        Font passwordFont = new Font(null,1,16);
        //设置字体颜色
        passwordText.setForeground(Color.white);
        //设置密码字体格式
        passwordText.setFont(passwordFont);
        //设置密码框位置和宽高
        passwordText.setBounds(197, 95, 40, 22);
        //将密码框加入整个界面
        this.getContentPane().add(passwordText);

        //4.密码输入框
        //设置密码输入框位置和宽高
        password.setBounds(263, 87, 160, 30);
        //将密码输入框加入整个界面
        this.getContentPane().add(password);

        //验证码提示
        //创建验证码对象
        JLabel codeText = new JLabel("验证码");
        //设置字体格式对象
        Font codeFont = new Font(null,1,16);
        //设置字体颜色
        codeText.setForeground(Color.white);
        //设置验证码字体格式
        codeText.setFont(codeFont);
        //设置验证码位置和宽高
        codeText.setBounds(215, 142, 55, 22);
        //将验证码框加入整个界面
        this.getContentPane().add(codeText);

        //验证码的输入框
        //设置验证码输入框位置和宽高
        code.setBounds(291, 133, 100, 30);
        //将验证吗输入框加入整个界面
        this.getContentPane().add(code);


        //设置正确验证码格式
        Font rightCodeFont = new Font(null,1,15);
        //设置颜色
        rightCode.setForeground(Color.RED);
        //设置字体
        rightCode.setFont(rightCodeFont);
        //设置内容
        rightCode.setText(codeStr);
        //绑定鼠标事件
        rightCode.addMouseListener(this);
        //位置和宽高
        rightCode.setBounds(400, 133, 100, 30);
        //添加到界面
        this.getContentPane().add(rightCode);

        //5.添加登录按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("doudizhu2\\image\\login\\登录按钮.png"));
        //去除按钮的边框
        login.setBorderPainted(false);
        //去除按钮的背景
        login.setContentAreaFilled(false);
        //给登录按钮绑定鼠标事件
        login.addMouseListener(this);
        this.getContentPane().add(login);

        //6.添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("doudizhu2\\image\\login\\注册按钮.png"));
        //去除按钮的边框
        register.setBorderPainted(false);
        //去除按钮的背景
        register.setContentAreaFilled(false);
        //给注册按钮绑定鼠标事件
        register.addMouseListener(this);
        this.getContentPane().add(register);


        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("doudizhu2\\image\\login\\background.png"));
        //设置背景宽高
        background.setBounds(0, 0, 633, 423);
        this.getContentPane().add(background);

        //刷新界面
        this.getContentPane().repaint();

    }

    //初始化组件，在这个界面中添加内容
    public void initJFrame() {
        //设置宽高
        this.setSize(633, 423);
        //设置标题
        this.setTitle("斗地主游戏 V1.0登录");
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //居中
        this.setLocationRelativeTo(null);
        //置顶
        this.setAlwaysOnTop(true);
        //取消内部默认布局
        this.setLayout(null);
    }

    //展示弹框
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

        //创建JLabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);
        //让弹框展示出来
        jDialog.setVisible(true);
    }

    //点击
    @Override
    public void mouseClicked(MouseEvent e) {
        //获取事件
        Object source = e.getSource();
        if (source == login){
            //获取验证码
            String codeInput = code.getText();
            //校验验证码
            if (codeInput.isEmpty()){
                showJDialog("验证码为空");
                return;
            }
            if (!codeInput.equalsIgnoreCase(codeStr)){
                showJDialog("验证码错误");
                return;
            }

            //获取用户名和密码
            String usernameInput = username.getText();
            String passwordInput = password.getText();
            //校验用户名和密码
            if (usernameInput.isEmpty() || passwordInput.isEmpty()){
                showJDialog("用户名或密码为空");
                return;
            }
            //将用户名和密码加入User类
            User user = new User(usernameInput, passwordInput);
            if (!allUsers.contains(user)){
                System.out.println(usernameInput + " " + passwordInput);
                showJDialog("用户名或密码错误");
                return;
            }

            //用户名和密码以及验证码都正确
            //关闭当前界面
            this.setVisible(false);
            //打开游戏界面
            new GameJFrame();
        }
        if (source == register){
            System.out.println("打开注册界面");
        }

        //更换验证码
        if (source == rightCode){
            //重新获取验证码
            codeStr = CodeUtil.getCode();
            //修改验证码内容
            rightCode.setText(codeStr);
        }
    }

    //按下不松
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("doudizhu2\\image\\login\\登录按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("doudizhu2\\image\\login\\注册按下.png"));
        }
    }

    //松开按钮
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("doudizhu2\\image\\login\\登录按钮.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("doudizhu2\\image\\login\\注册按钮.png"));
        }
    }

    //鼠标划入
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    //鼠标划出
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
