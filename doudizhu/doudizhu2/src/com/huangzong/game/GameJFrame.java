package com.huangzong.game;

import com.huangzong.domain.Poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class GameJFrame extends JFrame implements ActionListener {
    //获取界面的隐藏容器
    public static Container container = null;

    //创建抢地主和不抢两个按钮对象
    JButton[] landlord = new JButton[2];

    //创建出牌和不出牌两个按钮对象
    JButton[] publishCard = new JButton[2];

    //游戏界面地主的图标
    JLabel dizhu;

    //集合嵌套，小集合存储玩家要出的牌，大集合存储三位玩家的小集合
    ArrayList<ArrayList<Poker>> currentList = new ArrayList<>();

    //集合嵌套，小集合存储玩家分到的牌，大集合存储三位玩家的小集合
    ArrayList<ArrayList<Poker>> playerList = new ArrayList<>();

    //存储地主的底牌
    ArrayList<Poker> lordList = new ArrayList<>();

    //牌盒，装所有的牌
    ArrayList<Poker> pokerList = new ArrayList();

    //玩家的时间提示
    JTextField time[] = new JTextField[3];

    public GameJFrame() {
        //设置任务栏的图标
        setIconImage(Toolkit.getDefaultToolkit().getImage("doudizhu2\\image\\poker\\dizhu.png"));
        //设置界面
        initJframe();
        //添加组件
        initView();
        //界面显示出来
        //先展示界面再发牌，因为发牌里面有动画，界面不展示出来，动画无法展示
        this.setVisible(true);

        //初始化牌
        //准备牌，洗牌，发牌，排序
        initCard();
        //打牌之前的准备工作
        //展示抢地主和不抢地主两个按钮并且再创建三个集合用来装三个玩家准备要出的牌
        initGame();
    }

    //初始化牌（准备牌，洗牌，发牌，排序）
    public void initCard() {
        //准备牌，将牌加入集合
        for (int i = 1; i < 5; i++){
            for (int j = 1; j < 14; j++){
                Poker poker = new Poker(i , j);
                pokerList.add(poker);
            }
        }
        //添加大小王
        Poker poker1 = new Poker(5,1);
        Poker poker2 = new Poker(5,2);
        pokerList.add(poker1);
        pokerList.add(poker2);
        //洗牌
        Collections.shuffle(pokerList);

        //发牌
        ArrayList<Poker> player1 = new ArrayList<>();
        ArrayList<Poker> player2 = new ArrayList<>();
        ArrayList<Poker> player3 = new ArrayList<>();
        for (int i = 0; i < pokerList.size(); i++){
            //获取牌
            Poker poker = pokerList.get(i);
            if (i <= 2){
                lordList.add(poker);
                return;
            }
            if (i % 3 == 0){
                player1.add(poker);
            }else if (i % 3 == 1){
                player2.add(poker);
            }else {
                player3.add(poker);
            }
        }

        //排序
        order(player1);
        order(player2);
        order(player3);
        order(lordList);

        //将玩家牌集合加入大集合
        Collections.addAll(playerList , player1 , player2 , player3);
    }

    //排序
    public void order(ArrayList<Poker> list) {
        Collections.sort(list, new Comparator<Poker>() {
            @Override
            public int compare(Poker o1, Poker o2) {
                //获取花色
                int color1 = o1.getColor();
                //获取价值
                int value1 = getValue(o1);

                //获取已经发放的牌
                int color2 = o2.getColor();
                int value2 = getValue(o2);

                //比较牌面价值
                //首先比较牌面数字
                int i = value1 - value2;
                return i == 0 ? color1 - color2 : i;
            }
        });

    }

    //获取每一张牌的价值
    public int getValue(Poker poker) {
        //指定牌的价值
        HashMap<Integer , Integer> hm = new HashMap<>();
        hm.put(11,11);
        hm.put(12,12);
        hm.put(13,13);
        hm.put(1,14);
        hm.put(2,15);
        //获取牌数字
        int number = poker.getNumber();
        if (hm.containsKey(number)) {
            //集合中存在，返回集合值
            return hm.get(number);
        }else {
            return number;
        }
    }


    //打牌之前的准备工作
    private void initGame() {
        //创建三个集合用来装三个玩家准备要出的牌
        for (int i = 0; i < 3; i++) {
            ArrayList<Poker> list = new ArrayList<>();
            //添加到大集合中方便管理
            currentList.add(list);
        }

        //展示抢地主和不抢地主两个按钮
        landlord[0].setVisible(true);
        landlord[1].setVisible(true);

        //展示自己前面的倒计时文本
        for (JTextField field : time) {
            field.setText("倒计时30秒");
            field.setVisible(true);
        }

    }





    @Override
    public void actionPerformed(ActionEvent e) {

    }

    //添加组件
    public void initView() {
        //创建抢地主的按钮
        JButton robBut = new JButton("抢地主");
        //设置位置
        robBut.setBounds(320, 400, 75, 20);
        //添加点击事件
        robBut.addActionListener(this);
        //设置隐藏
        robBut.setVisible(false);
        //添加到数组中统一管理
        landlord[0] = robBut;
        //添加到界面中
        container.add(robBut);

        //创建不抢的按钮
        JButton noBut = new JButton("不     抢");
        //设置位置
        noBut.setBounds(420, 400, 75, 20);
        //添加点击事件
        noBut.addActionListener(this);
        //设置隐藏
        noBut.setVisible(false);
        //添加到数组中统一管理
        landlord[1] = noBut;
        //添加到界面中
        container.add(noBut);

        //创建出牌的按钮
        JButton outCardBut = new JButton("出牌");
        outCardBut.setBounds(320, 400, 60, 20);
        outCardBut.addActionListener(this);
        outCardBut.setVisible(false);
        publishCard[0] = outCardBut;
        container.add(outCardBut);

        //创建不要的按钮
        JButton noCardBut = new JButton("不要");
        noCardBut.setBounds(420, 400, 60, 20);
        noCardBut.addActionListener(this);
        noCardBut.setVisible(false);
        publishCard[1] = noCardBut;
        container.add(noCardBut);


        //创建三个玩家前方的提示文字：倒计时
        //每个玩家一个
        //左边的电脑玩家是0
        //中间的自己是1
        //右边的电脑玩家是2
        for (int i = 0; i < 3; i++) {
            time[i] = new JTextField("倒计时:");
            time[i].setEditable(false);
            time[i].setVisible(false);
            container.add(time[i]);
        }
        time[0].setBounds(140, 230, 60, 20);
        time[1].setBounds(374, 360, 60, 20);
        time[2].setBounds(620, 230, 60, 20);


        //创建地主图标
        dizhu = new JLabel(new ImageIcon("images/dizhu.png"));
        dizhu.setVisible(false);
        dizhu.setSize(40, 40);
        container.add(dizhu);
        
    }

    //设置界面
    public void initJframe() {
        //设置标题
        this.setTitle("斗地主");
        //设置大小
        this.setSize(830, 620);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口无法进行调节
        this.setResizable(false);
        //界面居中
        this.setLocationRelativeTo(null);
        //获取界面中的隐藏容器，以后直接用无需再次调用方法获取了
        container = this.getContentPane();
        //取消内部默认的居中放置
        container.setLayout(null);
        //设置背景颜色
        container.setBackground(Color.LIGHT_GRAY);
    }
}
