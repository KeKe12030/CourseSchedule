package com.nullatom.util;

import com.nullatom.pojo.TimeTable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HtmlUtils {
    /**
     * 获取处理过的（通过replace()替换过${?}的）Html字符串
     * @param timeTableList 需要处理的课程的集合
     * @return 处理后的html字符串
     * */
    public static String getHandledCoursesHtml(List<TimeTable> timeTableList){
        String html = CommonUtils.getFileAsString("html/index.html");
        //设置星期
        html = html.replace("${week}", String.valueOf(DateUtils.getTodayWeek()));
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd");
        //设置日期
        html = html.replace("${date}",simpleFormatter.format(new Date()));
        TimeTable timeTable = null;
        //替换${?}
        if(timeTableList != null){
            for(int i=0;i<timeTableList.size();i++){
                //通过getNumber来替换，防止排序错误时替换错误
                timeTable = timeTableList.get(i);
                html = html.replace("${"+(timeTable.getNumber())+"}",timeTable.getCourse().getName());
            }
            if(timeTableList.size() < 11){//如果课程不满11节，则还有${?}未替换
                if(DateUtils.getTodayWeek() != 6) {//如果不是周六
                    html = html.replaceAll("\\$\\{([0-9]|[0-9][0-9])}", "");
                }else{//如果是周六
                    html = html.replaceAll("\\$\\{([0-9]|[0-9][0-9])}", "无");
                }
            }
        }
        return html;
    }

}
