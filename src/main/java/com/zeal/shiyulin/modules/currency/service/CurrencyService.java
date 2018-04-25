package com.zeal.shiyulin.modules.currency.service;

import com.zeal.shiyulin.modules.authority.entity.UserEntity;
import com.zeal.shiyulin.modules.authority.entity.UserInfoEntity;
import com.zeal.shiyulin.modules.currency.dao.CurrencyDao;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通用方法的service接口
 * Created by Zeal on 2017/4/26.
 */
@Service
public class CurrencyService {
    @Autowired
    CurrencyDao dao;

    /**
    *@description 获取当前用户
    *@author zeal
    *@date 2018/2/27 21:26
    *@version 1.0.0
    */
    public UserEntity getCurrentUser(){
        return (UserEntity) SecurityUtils.getSubject().getSession().getAttribute("user");
    }

    /**
    *@description 获取当前用户的信息
    *@author zeal
    *@date 2018/2/27 21:27
    *@version 1.0.0
    */
    public UserInfoEntity getCurrentUserInof(){
        return (UserInfoEntity) SecurityUtils.getSubject().getSession().getAttribute("userInfo");
    }
}
