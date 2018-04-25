package com.zeal.shiyulin.modules.currency.controller;

import com.aliyuncs.exceptions.ClientException;
import com.zeal.shiyulin.common.beans.Result;
import com.zeal.shiyulin.exception.ZealException;
import com.zeal.shiyulin.modules.authority.service.UserService;
import com.zeal.shiyulin.modules.currency.service.CurrencyService;
import com.zeal.shiyulin.utils.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * 通用方法的入口
 * Created by Zeal on 2017/4/26.
 */
@Controller
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;
    @Autowired
    UserService userService;

    /**
     * 上传图片到OSS对象云存储，并返回图片链接
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(HttpServletRequest request,HttpServletResponse response) throws IOException {
        MultipartHttpServletRequest re = (MultipartHttpServletRequest) request;
        MultipartFile fileM = re.getFile("file");
        //File file= AliyunOSSUtils.multipartToFile(fileM);
        String resultUrl=new AliyunOSSMethod().uploadFile(fileM);
        return resultUrl;
    }

    /**
     * @auther Zeal
     * @description 用户发送短信验证码
     * @date 2017/11/29 16:58
     */
    @RequestMapping(value = "/currency/sendSMS", method = RequestMethod.POST)
    @ResponseBody
    public void sendSMS(@RequestParam Map<String, String> allRequestParam, HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ClientException, InterruptedException {
        if (StringUtils.isNotEmpty(allRequestParam.get("phone"))) {
            //生成一个随机六位的验证码
            String validate = VerifyCodeUtils.generateTextCode(VerifyCodeUtils.TYPE_NUM_ONLY, 6, null);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", validate);
            System.out.println("#####################################");
            System.out.println("短信验证码为: " + validate);
            System.out.println("#####################################");
            AliyunSMS.sendSms(allRequestParam.get("phone"), AliyunSMS.webSignName, AliyunSMS.codeTemplate, jsonObject);
            HttpSession session = request.getSession();
            session.setAttribute("phone", allRequestParam.get("phone"));
            session.setAttribute("code", validate);
            session.setAttribute("codeTime", System.currentTimeMillis());
        }
    }

    /**
     * @auther Zeal
     * @description 校验用户发送短信验证码
     * @date 2017/11/29 16:58
     */
    @RequestMapping(value = "/currency/validateCode", method = RequestMethod.POST)
    @ResponseBody
    public int validateCode(@RequestParam Map<String, String> allRequestParam, HttpServletRequest request, HttpServletResponse response)  {
        String phone = allRequestParam.get("phone");
        String code = allRequestParam.get("code");
        HttpSession session = request.getSession();
        String s_phone = (String) session.getAttribute("phone");
        String s_code = (String) session.getAttribute("code");
        Long s_timeOut = (Long) session.getAttribute("codeTime");
        Long timeout = System.currentTimeMillis();
        if (StringUtils.isNotEmpty(phone)&&phone.equals(s_phone)&&StringUtils.isNotEmpty(code)&&code.equals(s_code)&&s_timeOut!=null) {
            if (timeout-s_timeOut>5*60*1000){
                return 0; //验证码超时
            }else {
                return 1;
            }
        }else {
            return -1; //验证码不正确
        }
    }

    @RequestMapping(value = "/currency/test")
    @ResponseBody
    public Result test(@RequestParam Map<String, String> allRequestParam, HttpServletRequest request, HttpServletResponse response)  {
        throw new ZealException("报错愕");
//        return userService.findById("10001");
    }




}
