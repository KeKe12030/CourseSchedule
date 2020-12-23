package com.nullatom.util;

import com.nullatom.dao.TodayCoursesMapper;
import com.nullatom.pojo.Course;
import com.nullatom.pojo.TimeTable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtils {
    private static ApplicationContext applicationContext; //Spring容器

    /**
     * 获取Spring容器
     * @return spring容器
     * */
    private static ApplicationContext getApplicationContext(){
        if(applicationContext == null) {//实例化，单例设计模式
            applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        }
        return applicationContext;
    }


    /**
     * 从Spring容器里获取Bean
     * @param <T> 需要获取的Bean的Class对象
     * @param name 需要获取的Bean的name（Spring中的id）
     * @param clazz 需要获取的Bean的Class对象
     * @return 从Spring容器中获取到的实例对象
     * */
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name,clazz);
    }

    /**
     * 获取文件的BufferedReader
     * @param resource 需要获取的文件的路径
     * @return 获取到的文件的BufferedReader
     * */
    private static BufferedReader getFileBufferedReader(String resource){
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(resource);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        return br;
    }

    /**
     * 获取一个文件以String方式返回
     * @param resource 需要获取的文件的路径
     * @return 获取到的文件以String形式的字符串
     * */
    public static String getFileAsString(String resource){
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        BufferedReader br = getFileBufferedReader(resource);
        while(true){
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }
}
