package com.huangzong.doudizhu2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {

    //创建集合存储牌序号
    static HashMap<Integer , String> hm = new HashMap<>();
    static  ArrayList<Integer> list = new ArrayList<>();

    //准备牌
    static {
        //定义数组存储花色
        String[] color = new String[]{"♥" , "♠" , "♦" , "♣"};
        //定义数组存储拍马
        String[] number = new String[]{"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //定义变量记录牌序号
        int serialNumber = 1;
        for (String n : number) {
            for (String c : color) {
                hm.put(serialNumber , c + n);
                list.add(serialNumber);
                serialNumber++;
            }
        }
        //添加大小王
        hm.put(serialNumber , "小王");
        list.add(serialNumber);
        serialNumber++;
        hm.put(serialNumber , "大王");
        list.add(serialNumber);

    }
    public PokerGame(){
        //洗牌
        Collections.shuffle(list);
        //发牌
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        for (int i = 0; i < list.size(); i++){
            int serialNumber = list.get(i);
            if (i <= 2){
                lord.add(serialNumber);
                continue;
            }
            if (i % 3 == 0){
                player1.add(serialNumber);
            }else if (i % 3 == 1){
                player2.add(serialNumber);
            }else {
                player3.add(serialNumber);
            }
        }
        //看牌
        lookPoker("地主" , lord);
        lookPoker("张三" , player1);
        lookPoker("李四" , player2);
        lookPoker("王五" , player3);
    }

    public static void lookPoker(String name , TreeSet<Integer> treeSet){
        System.out.print(name + ": ");
        for (Integer serialNumber : treeSet) {
            String poker = hm.get(serialNumber);
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
