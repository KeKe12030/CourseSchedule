package com.nullatom.service;

import com.nullatom.dao.TodayCoursesMapperImpl;
import com.nullatom.pojo.TimeTable;
import com.nullatom.util.CommonUtils;
import com.nullatom.util.DateUtils;
import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取课程相关的工具
 * @author VioletTec
 * */
public class GetCourses {
    /**
     * 获取传入参数当天的所有科目（包括晚自习【如果为周日，则会特殊处理，拼接上午第3节课以及上午1-4节课以及下午和晚自习】）
     * @param week 星期数
     * @return 包含了当天课程的List集合
     * */
    private static List<TimeTable> getCoursesByWeek(int week){
        Logger logger = Logger.getLogger(GetCourses.class);
        TodayCoursesMapperImpl todayCoursesMapperImpl = CommonUtils.getBean("todayCoursesMapperImpl", TodayCoursesMapperImpl.class);
        int round = 0;//轮数
        Map map = new HashMap();
        map.put("week",week);
        map.put("round",round);
        //星期为week，轮数为0（不分轮数的课程，【周天上午除了第3节课 或 周1-4全天（包括晚自习）】）
        List<TimeTable> timeTableList = todayCoursesMapperImpl.getDayTimeTables(map);
        if(week == 7){//获取下午的课程
            //处理星期天的课程
            /*查询星期天下午的课程*/
            round = DateUtils.getTodayRound();//获取今天轮数
            map.remove("round");
            map.put("round",round);
            //周天下午的课程表
            List<TimeTable> sundayAfternoonTimeTables = todayCoursesMapperImpl.getDayTimeTables(map);
            timeTableList.addAll(sundayAfternoonTimeTables);//合并星期天上午的课程和下午的课程

            /* 添加物理 / 化学 */
            int pAndCRound = DateUtils.getTodayWeek()-36 % 2;//1是物理，0是化学
            TimeTable timeTable = null;
            if(pAndCRound == 1){//物理
                timeTable =  new TimeTable(todayCoursesMapperImpl.getCourseById(4), 3, 7, 0);
                timeTableList.add(timeTable);
            }else{ //化学
                timeTable =  new TimeTable(todayCoursesMapperImpl.getCourseById(5), 3, 7, 0);
                timeTableList.add(timeTable);
            }
        }
        return timeTableList;
    }
    /**
     * 获取今天的星期，以List集合方式返回
     * @return 今日的课程
     * */
    public static List<TimeTable> getTodayCourses(){
        int week = DateUtils.getTodayWeek();
        return getCoursesByWeek(week);
    }

}
