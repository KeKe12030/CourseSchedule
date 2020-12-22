package com.nullatom;

import com.nullatom.controller.Index;
import com.nullatom.handler.IndexHandler;
import com.nullatom.httpserver.NAServer;
import com.nullatom.util.CommonUtils;
import org.apache.log4j.Logger;

/**
 * 程序主入口
 * @author VioletTec
 * */
public class Main {
    static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("NA服务器开启成功！");
        NAServer naServer = CommonUtils.getBean("naServer", NAServer.class);
        IndexHandler indexHandler = CommonUtils.getBean("indexHandler", IndexHandler.class);
        naServer.setHandler(indexHandler);
        naServer.start();
        logger.info("NA服务器开启成功！");
    }
}
