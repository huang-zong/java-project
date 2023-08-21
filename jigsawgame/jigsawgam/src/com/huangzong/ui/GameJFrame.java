package com.huangzong.ui;


import javax.swing.*;
import java.util.Random;

public class GameJFrame extends JFrame {
    //JFrame 界面，窗体
    //GameJFrame表示游戏主界面
    //所有游戏相关的代码，写在这里

    //定义二维数组存储数据
    int[][] date = new int[4][4];

    //定义一个空参构造，初始化界面
    public GameJFrame(){
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据（打乱图片）
        initDate();

        //初始化图片
        initImage();

        //设置界面是否显示
        this.setVisible(true);
    }

    //初始化数据
    private void initDate() {
        //定义一个一维数组
        int[] tempArr = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //打乱数组中的数据顺序
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++){
            //随机生成下标
            int index = r.nextInt(tempArr.length);
            //交换数据
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        //将一维数组添加到二维数组
        for (int i = 0; i < tempArr.length; i++){
            date[i / 4][i % 4] = tempArr[i];
        }
    }

    //初始化图片
    private void initImage() {
        //双循环添加图片
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                //获取当前要加载的图片序号
                int num = date[i][j];
                //创建ImageIcon对象
                ImageIcon imageIcon = new ImageIcon("D:\\javacode\\jigsawgame\\jigsawgam\\image\\girl\\girl1\\f-" + num +".png");
                //创建JLabel对象（管理容器）
                JLabel jLabel = new JLabel(imageIcon);
                //指定图片的位置
                jLabel.setBounds(105 * j , 105 * i , 105 , 105);
                //把管理容器添加到界面中
                //this.add(jLabel);
                //获取隐藏容器再添加
                this.getContentPane().add(jLabel);
                System.out.print(date[i][j] + " ");
            }
        }
    }

    //初始化菜单
    private void initJMenuBar() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上的两个选项
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");

        //创建选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        //将每一个条目添加到选项中
        functionMenu.add(replayItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(closeItem);

        aboutMenu.add(accountItem);

        //将菜单的两个选项添加到菜单栏
        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutMenu);

        //将菜单添加到界面
        this.setJMenuBar(jMenuBar);
    }

    //初始化界面
    private void initJFrame() {
        //设置界面大小
        this.setSize(600 , 680);
        //设置界面标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面的关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认的居中放置，只有取消了才会按照XY轴放置组件
        this.setLayout(null);
    }
}
