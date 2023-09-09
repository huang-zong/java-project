package com.huangzong.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CodeUtil {
    public static String getCode(){
        //创建集合存储验证码
        ArrayList<String> list = new ArrayList<>();
        //生成随机数
        Random r = new Random();
        for (int i = 0; i < 4; i++){
            //生成随机选择
            int count = r.nextInt(2);
            //生成随机字母
            int temp = r.nextInt(26);
            char ch = ' ';
            if (count == 1){
                ch = (char) ('a' + temp);
            }else {
                ch =(char) ('A' + temp);
            }
            list.add(String.valueOf(ch));
        }
        StringBuilder sb = new StringBuilder();
        //获取随机数字
        String num = String.valueOf(r.nextInt(10));
        list.add(num);
        //打乱字符顺序
        Collections.shuffle(list);
        //拼接字符串
        for (int i = 0; i < list.size(); i++){
            //获取字符
            String ch = list.get(i);
            sb.append(ch);
        }
        return sb.toString();
    }
}
