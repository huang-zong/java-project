package com.huangzong.doudizhu1;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {

    //创建集合存储牌面
    static  ArrayList<String> list = new ArrayList<>();
    //静态代码块，随着类的加载而加载，并且只执行一次
    //准备牌
    static {
        //定义数组存储花色
        String[] color = new String[]{"♥" , "♠" , "♦" , "♣"};
        //定义数组存储拍马
        String[] number = new String[]{"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //存入集合
        for (String c : color) {
            for (String n : number) {
                list.add(c + n);
            }
        }
        //添加大小王
        list.add("小王");
        list.add("大王");
    }
    public PokerGame(){
        //洗牌
        Collections.shuffle(list);

        //发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        //遍历集合发牌
        for (int i = 0; i < list.size(); i++) {
            //获取牌
            String poker = list.get(i);
            if (i <= 2){
                //三张地主牌先存
                lord.add(poker);
                continue;
            }
            if (i % 3 == 0){
                player1.add(poker);
            }else if (i % 3 == 1){
                player2.add(poker);
            }else {
                player3.add(poker);
            }
        }

        //看牌
        lookPoker("地主" , lord);
        lookPoker("张三" , player1);
        lookPoker("李四" , player2);
        lookPoker("王五" , player3);

    }

    private static void lookPoker(String name , ArrayList<String> list) {
        System.out.print(name + ": ");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
