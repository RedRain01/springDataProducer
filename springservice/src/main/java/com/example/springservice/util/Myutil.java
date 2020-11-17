package com.example.springservice.util;

import com.alibaba.druid.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author ：why
 * @description：TODO
 * @date ：2020/10/7 9:53
 */


public class Myutil {
    private  static int num=0;
    private  static int waterNum=0;
    private  static int proNum=0;
    public static String getName(){
        num++;
        return String.format("Stu"+"%05d",num);
    }

    public static String getXname(){
        num++;
        return String.format("Xstu"+"%05d",num);
    }
    //获取唯一id
    public static  String getId(){
        return UUID.randomUUID().toString();
    }
    //获取均匀随机分区
    public static String getPartition(String string){
        if (StringUtils.isEmpty(string)) {
            Random random=new Random();
            int num=random.nextInt(6);
            return num+"";
        }
      return string;
    }

    //获取均匀随机商品
    public static String getCommodity(String string){
        String[] str={"c1","c2","c3","c4","c5","c6","c7"};
        if (StringUtils.isEmpty(string)) {
            Random random=new Random();
            int num=random.nextInt(6);
            return str[num];
        }
        return string;
    }



    //生成均匀科目
    public static String getSubjec(){
        Random random=new Random();
        int num=random.nextInt(5)+1;

        switch(num){
            case 1 :
                return "数学";
            case 2 :
                return "语文";
            case 3 :
                return "英语";
            case 4 :
                return "体育";
            case 5 :
                return "生物";
            case 6 :
                return "物理";
            default : //可选
                return "化学";
        }

    }
    //制作乱序数据测试watermark
    public static long getTime () throws Exception {
        long[] ss ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37};
        waterNum++;
        Thread.sleep(1000);
        return (ss[waterNum]+1601049600)*1000;
    }
    public static int getScore(){
        return (int)(50+Math.random()*(50));
    }

    //制作数据测试定时器
    public static int getScoreMonitor(){
        int[] ss ={1,2,3,12,6,4,7,10,8,9,11,13,15,16,14,17,18,19,20,21,22,23,24,25,26,27,28,39,30,31,32,33,34,35,36,37};
        proNum++;
        return ss[35-proNum];
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(int time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_Date = sdf.format(new Date(time * 1000L));
        return time_Date;
    }
}
