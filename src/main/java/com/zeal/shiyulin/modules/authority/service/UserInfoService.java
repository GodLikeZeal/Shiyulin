/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.authority.service;

import com.zeal.shiyulin.modules.authority.dao.UserInfoDao;
import com.zeal.shiyulin.modules.authority.entity.UserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zeal.shiyulin.common.structure.CommonService;


/**
 * user_info业务层
 * 
 * @author zeal
 * @date 2017-11-30 11:52:18
 */
@Service
public class UserInfoService extends CommonService<UserInfoDao,UserInfoEntity> {
    @Autowired
    private UserInfoDao userInfoDao;

    /**
    * @auther Zeal
    * @description 根据主键来返回单条信息记录
    * @date 2017/12/5 14:26
    */
    public UserInfoEntity findUserInfoByUserId(String  userId){
        return userInfoDao.findUserInfoByUserId(userId);
    }
}