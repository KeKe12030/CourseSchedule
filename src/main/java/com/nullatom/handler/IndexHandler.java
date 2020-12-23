package com.nullatom.handler;

import com.google.gson.Gson;
import com.nullatom.httpserver.handler.NAServerHandler;
import com.nullatom.httpserver.utils.Request;
import com.nullatom.httpserver.utils.Response;
import com.nullatom.pojo.TimeTable;
import com.nullatom.service.GetCourses;
import com.nullatom.util.DateUtils;
import com.nullatom.util.HtmlUtils;
import org.apache.ibatis.io.Resources;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class IndexHandler implements NAServerHandler {
    public void handle(Request request, Response response) {
        List<TimeTable> todayCourses = GetCourses.getTodayCourses();
        response.setResponseType("text/html");
        String html = HtmlUtils.getHandledCoursesHtml(todayCourses);
        response.print(html);
        try {
            response.pushToBrowser(200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
