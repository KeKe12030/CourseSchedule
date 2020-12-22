package com.nullatom.test.mybatis;

import com.nullatom.dao.TodayCoursesMapper;
import com.nullatom.pojo.TimeTable;
import com.nullatom.service.GetCourses;
import com.nullatom.util.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class MyBatisTests {


    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TodayCoursesMapper todayCoursesMapper = applicationContext.getBean("todayCoursesMapperImpl", TodayCoursesMapper.class);
        Map map = new HashMap();
        map.put("week",7);
        map.put("round",1);
        List<TimeTable> courseList = todayCoursesMapper.getDayTimeTables(map);
        for (TimeTable timeTable : courseList) {
            System.out.println(timeTable.toString());
        }
    }

    @Test
    public void test2(){
        List<TimeTable> todayCourses = GetCourses.getTodayCourses();
        for (TimeTable timeTable : todayCourses) {
            System.out.println(timeTable.toString());
        }
    }

    @Test
    public void test3(){
        Date date = new Date();
        date.setTime(1598939495000L);//9.1日是第36周
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        System.out.println(instance.get(Calendar.WEEK_OF_YEAR));
    }
}
