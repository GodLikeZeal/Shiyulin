package com.zeal.shiyulin.exception;



import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created by zeal on 2015/10/7.
 */
public class ExceptionUtils {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ExceptionUtils.class);

    /**
     * 记录本地日志
     * @param er
     */
    public static void LoadLog(Exception er){

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        er.printStackTrace(pw);
        log.error(sw.toString());
    }


    public static void LoadLog(Map map){
        String url=map.get("url").toString();
        String ip=map.get("ip").toString();
        String method=map.get("method").toString();
        String postParms=map.get("post").toString();

        log.info("ip:"+ip);
        log.info("url:"+url);
        log.info("method:"+method);
        log.info("postparams:"+postParms);
    }

    public static void LoadLog(String msg){
        log.info(msg);
    }


    /**
     * 处理错误信息，返回结果
     * @param er
     * @return
     */
    public static String DealErrorMsg(Exception er){
        String msg=er.getMessage();
        if(msg==null){
            msg=er.toString();
        }
        return msg;
    }
}
