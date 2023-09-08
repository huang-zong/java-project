package com.huangzong.doudizhu3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PokerGame {
    //牌盒
    static ArrayList<String> list = new ArrayList<>();

    //创建集合存储牌的价值
    static HashMap<String , Integer> hm = new HashMap<>();
    //准备牌
    static {
        //定义数组存储花色
        String[] color = new String[]{"♥" , "♠" , "♦" , "♣"};
        //定义数组存储拍马
        String[] number = new String[]{"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        for (String c : color) {
            for (String n : number) {
                list.add(c + n);
            }
        }
        //添加大小王
        list.add(" 小王");
        list.add(" 大王");

        //指定牌的价值
        hm.put("J" , 11);
        hm.put("Q" , 12);
        hm.put("K" , 13);
        hm.put("A" , 14);
        hm.put("2" , 15);
        hm.put("小王" , 16);
        hm.put("大王" , 17);
    }
    public PokerGame(){
        //洗牌
        Collections.shuffle(list);

        //发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            //获取牌
            String poker = list.get(i);
            if (i <= 2){
                lord.add(poker);
                continue;
            }
            if (i % 3 == 0){
                player1.add(poker);
            } else if (i % 3 == 1) {
                player2.add(poker);
            }else {
                player3.add(poker);
            }
        }

        //排序
        getSort(lord);
        getSort(player1);
        getSort(player2);
        getSort(player3);

        //看牌
        lookPoker("地主" , lord);
        lookPoker("张三" , player1);
        lookPoker("李四" , player2);
        lookPoker("王五" , player3);

    }

    //定义方法进行排序，依据牌面价值
    public static void getSort(ArrayList<String> list){
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //获取花色
                String color1 = o1.substring(0, 1);
                //获取牌面数字
                String number1 = o1.substring(1);
                int value1 = getValue(number1);

                //获取已经排序的牌面
                String color2 = o2.substring(0 , 1);
                String number2 = o2.substring(1);
                int value2 = getValue(number2);

                //比较牌面价值
                int i = value1 - value2;
                i = i == 0 ? color1.compareTo(color2) : i;

                return i;
            }
        });
    }

    //定义方法获取牌面价值
    public static int getValue(String number){
        //与hasmap比较,如果存在则返回map集合
        if (hm.containsKey(number)){
            return hm.get(number);
        }else {
            //集合中不存在,类型转换
            return Integer.parseInt(number);
        }
    }

    //看牌
    private static void lookPoker(String name , ArrayList<String> list) {
        System.out.print(name + ": ");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
