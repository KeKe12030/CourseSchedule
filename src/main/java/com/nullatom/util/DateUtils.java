package com.nullatom.util;

import java.util.Calendar;

/**
 * 日期相关的工具类
 * @author VioletTec
 * */
public class DateUtils {
    /**
     * 获取今天是在一年中的第几天
     * @return 获取今天在一年中是第几周
     * */
    public static int getTodayWeekInYear(){
        return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);//获取今天是一年中的第几周
    }


    /**
     * 获取今天是课程的第几轮
     * @return 返回今天的轮数
     */
    public static int getTodayRound(){
        int todayWeek = getTodayWeekInYear();
        int roundWeek = todayWeek-37;//今天是第几轮
        int round = roundWeek % 3;
        return  round == 0 ? 3 : round;//如果round%3为0，则为第三轮。若round%3不是0，则余数为轮数
    }

    /**
     * 获取今日星期几
     * @return 今日的星期
     * */
    public static int getTodayWeek() {
//        return 7;
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) -1;//-1是因为老外一周是从周日开始的
    }
}
