package com.nullatom.handler;

import com.google.gson.Gson;
import com.nullatom.httpserver.handler.NAServerHandler;
import com.nullatom.httpserver.utils.Request;
import com.nullatom.httpserver.utils.Response;
import com.nullatom.pojo.TimeTable;
import com.nullatom.service.GetCourses;
import com.nullatom.util.DateUtils;
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
        String resource = "html/index.html";
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(resource);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while((line = br.readLine()) != null){
                stringBuilder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String html = stringBuilder.toString();
        html = html.replace("${week}", String.valueOf(DateUtils.getTodayWeek()));
        SimpleDateFormat  simpleFormatter = new SimpleDateFormat("yyyy-MM-dd");
        html = html.replace("${date}",simpleFormatter.format(new Date()));
        for(int i=0;i<todayCourses.size();i++){
            html = html.replace("${"+(i+1)+"}",todayCourses.get(i).getCourse().getName());
        }
        if(todayCourses.size() == 8){
            html = html.replaceAll("\\$\\{([0-9]|[0-9][0-9])}","");
        }
        response.print(html);
        try {
            response.pushToBrowser(200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
