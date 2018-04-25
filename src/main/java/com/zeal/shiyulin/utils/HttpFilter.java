package com.zeal.shiyulin.utils;



import com.zeal.shiyulin.exception.ExceptionUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zeal on 2015/10/8.
 */
public class HttpFilter implements Filter {

//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
//            ServletException {
//        try {
//            HttpServletRequest  httpServletRequest=(HttpServletRequest) request;
//            String url = httpServletRequest.getRequestURI();
//            if (!StringUtils.isNull(httpServletRequest.getQueryString())) {
//                url +="?"+ httpServletRequest.getQueryString();
//            }
//            BufferedReader bufferedReader=null;
//            ServletRequest requestWrapper = null;
//            String s;
//            String strPostParam="";
//            StringBuilder sbPostParam=new StringBuilder();
//            if(url.indexOf("excursus/signatureimages/saveSignInfoRequest")==-1 && url.indexOf("mvcService")==-1) {
//
//                if (request instanceof HttpServletRequest) {
//                    requestWrapper = new RequestWrapperUtils((HttpServletRequest) request);
//                }
//                bufferedReader = requestWrapper.getReader();
//
//                while ((s = bufferedReader.readLine()) != null) {
////                  strPostParam+=s;
//                    sbPostParam.append(s);
//                    if (sbPostParam.length() > 1024 * 5)
//                        break;
//                }
//                bufferedReader.close();
//            }
//            else{
//                //bufferedReader=request.getReader();
//            }
//            /**
//             * 解决输出中文是乱码的问题
//             */
//            strPostParam=new String(sbPostParam.toString().getBytes(),"UTF-8");
//            Map map = new HashMap<>();
//            map.put("url", url);
//            map.put("method", httpServletRequest.getMethod());
//            map.put("post", strPostParam==null?"":StringUtils.trim(strPostParam)+"\r\n");
//
//            /**
//             * 记录URL参数信息，用于调试控制
//             */
//            ExceptionUtils.LoadLog(map);
//            chain.doFilter(requestWrapper==null?request:requestWrapper, response);
//
//        }
//        catch (Exception er){
//            ExceptionUtils.LoadLog(er);
//            throw new RuntimeException(ExceptionUtils.DealErrorMsg(er));
//        }
//    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        try {
            HttpServletRequest  httpServletRequest=(HttpServletRequest) request;
            HttpServletResponse httpServletResponse= (HttpServletResponse)response;
            String url = httpServletRequest.getRequestURI();
//            if (!StringUtils.isNull(httpServletRequest.getQueryString())) {
//                url +="?"+ httpServletRequest.getQueryString();
//            }
            String s;
            String strPostParam="";
            StringBuilder sbPostParam=new StringBuilder();
            Map<String,String[]> queryMap= (Map<String, String[]>) httpServletRequest.getParameterMap();
            if (queryMap!=null){
                for (String key:queryMap.keySet()) {
                    if (queryMap.get(key).length>1){
                        StringBuffer lastQuery= new StringBuffer();
                        for (String moQuery:queryMap.get(key)){
                            lastQuery.append(moQuery+",");
                        }
                        lastQuery.deleteCharAt(lastQuery.length()-1);
                        sbPostParam.append("\n"+key+":"+lastQuery+"\n");
                    }
                    sbPostParam.append("\n"+key+":"+queryMap.get(key)[0]+"\n");
                }
            }
            /**
             * 解决输出中文是乱码的问题
             */
            strPostParam=new String(sbPostParam.toString().getBytes(),"UTF-8");
            Map map = new HashMap<>();
            String ip =NetworkUtil.getIpAddress(httpServletRequest);
            map.put("ip",ip);
            map.put("url", url);
            map.put("method", httpServletRequest.getMethod());
            map.put("post", strPostParam==null?"":StringUtils.trim(strPostParam)+"\r\n");

            /**
             * 设置浏览器缓存，让浏览器不缓存数据
             */
           // httpServletResponse.setDateHeader("Expires", -1);              //告诉浏览器数据可以缓存多长时间，-1或0表示不缓存
           // httpServletResponse.setHeader("Cache_Control", "no-cache");    //支持HTTP 1.1，告诉浏览器要不要缓存数据，如“no-cache”
            httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            httpServletResponse.setHeader("Expires", "0"); // Proxies.
            //httpServletResponse.setHeader("Pragma", "no-cache");           //支持HTTP 1.0，告诉浏览器要不要缓存数据，如“no-cache”

            /**
             * 记录URL参数信息，用于调试控制
             */
            ExceptionUtils.LoadLog(map);
            chain.doFilter(request, response);


        }
        catch (Exception er){
            ExceptionUtils.LoadLog(er);
            throw new RuntimeException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    @Override
    public void destroy() {
        String str="";

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        String str="";
    }

}
