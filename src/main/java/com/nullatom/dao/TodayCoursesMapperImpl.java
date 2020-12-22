package com.nullatom.dao;

import com.nullatom.pojo.Course;
import com.nullatom.pojo.TimeTable;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

public class TodayCoursesMapperImpl implements TodayCoursesMapper{
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


    public List<TimeTable> getDayTimeTables(Map<Integer,Integer> weekAndRound) {
        return sqlSessionTemplate.getMapper(TodayCoursesMapper.class).getDayTimeTables(weekAndRound);
    }

    public Course getCourseById(int id) {
        return sqlSessionTemplate.getMapper(TodayCoursesMapper.class).getCourseById(id);
    }


}
