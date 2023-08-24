package com.huangzong.util;

import java.util.Random;

public class CodeUtil {
    //生成验证码
    //五位验证码，四位字母，一位0~9数字
    public static String getCode(){
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++){
            //定义变量
            int flag = r.nextInt(2);
            int temp = 0;
            char ch = 'a';
            if (flag == 0){
                //大写字母
                temp = r.nextInt(26);
                ch =(char) (65 + temp);
            }else {
                //小写字母
                temp = r.nextInt(26);
                ch =(char) (97 + temp);
            }
            sb.append(ch);
        }
        int num = r.nextInt(10);
        sb.append(num);
        //定义数组存储
        String[] str = sb.toString().split("");
        //打乱数组
        for (int i = 0; i < 5; i++){
            int index = r.nextInt(5);
            String temp = str[i];
            str[i] = str[index];
            str[index] = temp;
        }
        //转换为字符串
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 5; i++){
            sb1.append(str[i]);
        }
        return sb1.toString();
    }
}
