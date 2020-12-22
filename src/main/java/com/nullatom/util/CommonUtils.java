package com.nullatom.util;

import com.nullatom.dao.TodayCoursesMapper;
import com.nullatom.pojo.Course;
import com.nullatom.pojo.TimeTable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtils {
    private static ApplicationContext applicationContext;
    private static ApplicationContext getApplicationContext(){
        if(applicationContext == null) {//实例化，单例设计模式
            applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        }
        return applicationContext;
    }
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name,clazz);
    }
}
