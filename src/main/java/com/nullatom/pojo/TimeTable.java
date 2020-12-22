package com.nullatom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 具体课程信息类（包含课程的所有信息）
 * @author VioletTec
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TimeTable {
    private Course course;//对应课程实体类
    private int number;//位于一天中第几节课
    private int week;//该课是星期几的课程
    private int round;//该课是第几轮的课（0为部分轮数）
}
