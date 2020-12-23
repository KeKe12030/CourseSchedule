package com.nullatom.handler;

import com.nullatom.httpserver.handler.NAServerHandler;
import com.nullatom.httpserver.utils.Request;
import com.nullatom.httpserver.utils.Response;
import com.nullatom.pojo.TimeTable;
import com.nullatom.service.GetCourses;
import com.nullatom.util.HtmlUtils;

import java.io.*;
import java.util.List;

public class IndexHandler implements NAServerHandler {
    public void handle(Request request, Response response) {
        List<TimeTable> todayCoursesList = GetCourses.getTodayCourses();
        response.setResponseType("text/html");
        String todayCourses = HtmlUtils.getHandledCoursesHtml(todayCoursesList,0);//获取今日课程表
        List<TimeTable> tomorrowCoursesList = GetCourses.getTomorrowCourses();
        String tomorrowCourses = HtmlUtils.getHandledCoursesHtml(tomorrowCoursesList,1);//获取明日课程表

        response.print("<h3>今日课程表</h3>" +
                "<br/>" +
                "<hr/>" +
                "<br/>");
        response.print(todayCourses);
        response.print("" +
                "<hr/>" +
                "<br/>"+
                "<h3>明日课程表</h3>" +
                "<br/>" +
                "<hr/>" +
                "<br/>");
        response.print(tomorrowCourses);
        try {
            response.pushToBrowser(200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
