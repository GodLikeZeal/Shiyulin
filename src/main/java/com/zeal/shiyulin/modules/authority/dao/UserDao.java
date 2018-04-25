/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.authority.dao;

import com.zeal.shiyulin.common.annotation.MyBatisDao;
import com.zeal.shiyulin.modules.authority.entity.UserEntity;
import com.zeal.shiyulin.common.structure.CommonDao;

/**
 * user数据访问接口
 * 
 * @author zeal
 * @date 2017-11-05 16:39:27
 */
@MyBatisDao
public interface UserDao extends CommonDao<UserEntity> {

    /**
    *@description 根据电话号码查询单挑记录
    *@author zeal
    *@date 2018/1/12 22:52
    *@version 1.0.0
    */
     UserEntity findByPhone(String phone);
}