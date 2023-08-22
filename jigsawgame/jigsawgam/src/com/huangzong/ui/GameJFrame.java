package com.huangzong.ui;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener , ActionListener {
    //JFrame 界面，窗体
    //GameJFrame表示游戏主界面
    //所有游戏相关的代码，写在这里

    //定义二维数组存储数据
    int[][] date = new int[4][4];

    //定义变量存储空白位置下标
    int x = 0;
    int y = 0;

    //定义变量存储路径
    String path = "jigsawgam\\image\\girl\\girl";
    //定义一个变量标记图片序号
    int number = 1;

    //定义一个二维数组存储正确的数据
    int[][] win = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0},
    };

    //创建选项下面的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("公众号");

    JMenuItem girlItem = new JMenuItem("美女");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem sportItem = new JMenuItem("运动");

    //定义变量统计步数
    int step = 0;
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
            //获取空白位置下标
            if (tempArr[i] == 0){
                x = i / 4;
                y = i % 4;
            }
            date[i / 4][i % 4] = tempArr[i];
        }
    }

    //初始化图片
    private void initImage() {
        //清空原本已经出现的所有图片
        this.getContentPane().removeAll();

        //调用方法判断是否胜利
        if (victory()){
            //创建一个对象
            ImageIcon imageIconWin = new ImageIcon("jigsawgam\\image\\win.png");
            //将对象添加进容器
            JLabel jLabelWin = new JLabel(imageIconWin);
            //设置位置和宽高
            jLabelWin.setBounds(203 , 283 , 197 , 73);
            //添加到界面
            this.getContentPane().add(jLabelWin);
        }

        //创建一个对象
        JLabel stepCount = new JLabel("步数：" + step);
        //设置位置和宽高
        stepCount.setBounds(50 , 30 ,100 ,50);
        //添加到界面
        this.getContentPane().add(stepCount);

        //双循环添加图片
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                //获取当前要加载的图片序号
                int num = date[i][j];
                //创建ImageIcon对象，使用想到路径
                ImageIcon imageIcon = new ImageIcon( path + number  + "\\" + num +".jpg");
                //创建JLabel对象（管理容器）
                JLabel jLabel = new JLabel(imageIcon);
                //指定图片的位置
                jLabel.setBounds(105 * j + 83 , 105 * i + 134 , 105 , 105);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED)); //BevelBorder 斜面边框

                //把管理容器添加到界面中
                //this.add(jLabel);
                //获取隐藏容器再添加
                this.getContentPane().add(jLabel);
            }
        }

        //添加背景图片要放到后面，否则会覆盖图片

        //添加背景图片
        ImageIcon imageIcon = new ImageIcon("jigsawgam\\image\\background.png");
        //添加进容器
        JLabel jLabel = new JLabel(imageIcon);
        //设置位置和宽高
        jLabel.setBounds(40 , 40 , 508 , 560);
        //把背景图片添加到界面中
        this.getContentPane().add(jLabel);

        //刷新一下界面
        this.getContentPane().repaint();
    }

    //初始化菜单
    private void initJMenuBar() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上的两个选项
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");

        //创建更换图片选项
        JMenu changeImage = new JMenu("更换图片");



        //添加到更换图片选项中
        changeImage.add(girlItem);
        changeImage.add(animalItem);
        changeImage.add(sportItem);

        //将更换图片添加到功能选项中
        functionMenu.add(changeImage);

        //将每一个条目添加到选项中
        functionMenu.add(replayItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(closeItem);

        aboutMenu.add(accountItem);

        //给菜单条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        girlItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);

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

        //给界面添加键盘监听
        this.addKeyListener(this);

        //取消默认的居中放置，只有取消了才会按照XY轴放置组件
        this.setLayout(null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下不松会调用这个方法
    @Override
    public void keyPressed(KeyEvent e) {
        //获取键盘按键
        int keyCode = e.getKeyCode();
        if (keyCode == 65){
            //清空界面中的所有图片
            this.getContentPane().removeAll();
            //加载第一张完整的图片
            //创建一个对象
            ImageIcon all = new ImageIcon(path + number + "all.jpg");
            //添加进容器
            JLabel jLabelAll = new JLabel(all);
            //设置位置和宽高
            jLabelAll.setBounds(83 , 134 , 420 , 420);
            //将图片添加到界面
            this.getContentPane().add(jLabelAll);

            //设置背景图片
            ImageIcon imageIcon = new ImageIcon("jigsawgam\\image\\background.png");
            //添加进容器
            JLabel jLabel = new JLabel(imageIcon);
            //设置位置和宽高
            jLabel.setBounds(40 , 40 , 508 , 560);
            //把背景图片添加到界面中
            this.getContentPane().add(jLabel);

            //刷新一下界面
            this.getContentPane().repaint();

        }
    }

    //按下松开按键调用这个方法
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        //当游戏胜利则退出方法
        if (victory()){
            return;
        }
        if (keyCode == 37){
            System.out.println("向左移动");
            if (y == 3){
                return;
            }
            //把空白方块左边的图片向左移动
            //x, y表示空白方块
            //x,y+1表示空白方块左边的图片
            date[x][y] = date[x][y+1];
            date[x][y+1] = 0;
            //空白方块下移一位
            y++;
            //步数自增
            step++;
            //调用方法按照最新数字加载图片
            initImage();
        }else if (keyCode == 38){
            System.out.println("向上移动");
            if (x == 3){
                return;
            }
            //把空白方块下方的图片向上移动
            //x, y表示空白方块
            //x+1,y表示空白方块下方的图片
            date[x][y] = date[x+1][y];
            date[x+1][y] = 0;
            //空白方块下移一位
            x++;
            //步数自增
            step++;
            //调用方法按照最新数字加载图片
            initImage();
        }else if (keyCode == 39){
            System.out.println("向右移动");
            if (y == 0){
                return;
            }
            //把空白方块右边的图片向右移动
            //x, y表示空白方块
            //x,y-1表示空白方块左边的图片
            date[x][y] = date[x][y-1];
            date[x][y-1] = 0;
            //空白方块下移一位
            y--;
            //步数自增
            step++;
            //调用方法按照最新数字加载图片
            initImage();
        }else if (keyCode == 40){
            System.out.println("向下移动");
            if (x == 0){
                return;
            }
            //把空白方块上方的图片向下移动
            //x, y表示空白方块
            //x-1,y表示空白方块上方的图片
            date[x][y] = date[x-1][y];
            date[x-1][y] = 0;
            //空白方块下移一位
            x--;
            //步数自增
            step++;
            //调用方法按照最新数字加载图片
            initImage();
        }else if (keyCode == 65){
            initImage();
        }else if (keyCode == 87){
            date = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0},
            };
            initImage();
        }
    }

    //定义一个方法比较date与win数组的数据
    public boolean victory(){
        for (int i = 0; i < date.length; i++) {
            for (int j = 0; j < date.length; j++) {
                if (date[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        //遍历结束返回true
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前被点击的条目对象
        Object obj = e.getSource();
        if (obj == replayItem){
            System.out.println("重新游戏");
            //计数清零
            step = 0;
            //打乱二维数组的数据
            initDate();
            //重新加载图片
            initImage();
        }else if (obj == reLoginItem){
            System.out.println("重新登录");
            //隐藏当前界面,关闭当前界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        }else if (obj == closeItem){
            System.out.println("关闭游戏");
            //直接关闭虚拟机
            System.exit(0);
        }else if (obj == accountItem){
            System.out.println("公众号");
            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            //创建一个图片对象
            ImageIcon imageIcon = new ImageIcon("jigsawgam\\image\\about.png");
            //添加到容器
            JLabel jLabel = new JLabel(imageIcon);
            //设置位置和宽高
            jLabel.setBounds(0 , 0 ,258 ,258);
            //把图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //设置弹框的宽高
            jDialog.setSize(344,344);
            //设置弹框置顶
            jDialog.setAlwaysOnTop(true);
            //设置弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭则无法操作下面的界面
            jDialog.setModal(true );
            //设置弹框显示
            jDialog.setVisible(true);
        }else if (obj == girlItem){
            System.out.println("更换girl图片");
            //修改存储路径
            path = "jigsawgam\\image\\girl\\girl";
            //生成随机数
            Random r = new Random();
            number = r.nextInt(13)+1;
            //计数清零
            step = 0;
            //打乱二维数组数据
            initDate();
            //重新加载图片
            initImage();
        }else if (obj == animalItem){
            System.out.println("更换animal图片");
            //修改存储路径
            path = "jigsawgam\\image\\animal\\animal";
            //生成随机数
            Random r = new Random();
            number = r.nextInt(8)+1;
            //计数清零
            step = 0;
            //打乱二维数组数据
            initDate();
            //重新加载图片
            initImage();
        }else if (obj == sportItem){
            System.out.println("更换sport图片");
            //修改存储路径
            path = "jigsawgam\\image\\sport\\sport";
            //生成随机数
            Random r = new Random();
            number = r.nextInt(10)+1;
            //计数清零
            step = 0;
            //打乱二维数组数据
            initDate();
            //重新加载图片
            initImage();
        }
    }
}
