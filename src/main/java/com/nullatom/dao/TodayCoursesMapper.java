package com.nullatom.dao;

import com.nullatom.pojo.Course;
import com.nullatom.pojo.TimeTable;

import java.util.List;
import java.util.Map;


/**
 * 获取单日的课程信息
 * @author VioletTec
 * */
public interface TodayCoursesMapper {
    /**
     * 查询今日课程
     * @param weekAndRound 今日周几&今天第几轮
     * @return 今日课程的List集合
     * */
    public List<TimeTable> getDayTimeTables(Map<Integer,Integer> weekAndRound);

    /**
     * 通过课程id（cid）查询某一课程
     * @param id 你需要查询课程的课程id（cid）
     * @return 查询到的课程实例对象
     * */
    public Course getCourseById(int id);
}
