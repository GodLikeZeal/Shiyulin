/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.authority.dao;

import com.zeal.shiyulin.common.annotation.MyBatisDao;
import com.zeal.shiyulin.modules.authority.entity.UserInfoEntity;
import com.zeal.shiyulin.common.structure.CommonDao;

/**
 * user_info数据访问接口
 * 
 * @author zeal
 * @date 2017-11-30 11:52:18
 */
@MyBatisDao
public interface UserInfoDao extends CommonDao<UserInfoEntity> {
    /**
    * @auther Zeal
    * @description
    * @date 2017/11/30 17:18
    */
    UserInfoEntity findUserInfoByUserId(String  userId);

}