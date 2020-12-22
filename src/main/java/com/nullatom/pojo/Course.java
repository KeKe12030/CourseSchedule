package com.nullatom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程JavaBean
 * @author VioletTec
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int id;//课程id(cid)
    private String name;//课程名称
    private String teacher;//授课老师
    private int sub_course;//是否为主课？（1为是，0为否）
}
