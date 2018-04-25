/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.authority.service;

import com.zeal.shiyulin.modules.article.dao.ArticleDao;
import com.zeal.shiyulin.modules.article.entity.ArticleEntity;
import com.zeal.shiyulin.modules.authority.dao.UserDao;
import com.zeal.shiyulin.modules.authority.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zeal.shiyulin.common.structure.CommonService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * user业务层
 * 
 * @author zeal
 * @date 2017-11-05 16:39:27
 */
@Service
public class UserService extends CommonService<UserDao,UserEntity> {

    @Autowired
    private ArticleDao articleDao;

    /**
    *@description 根据用户名查询用户原创文件
    *@author zeal
    *@date 2018/1/10 21:51
    *@version 1.0.0
    */
    public Map<String,Object> getCreateByUserId(String userId){
        Map<String,Object>map = new HashMap<>();
        //获取原创文章列表
        List<ArticleEntity>articleEntityList = articleDao.findArticleListByUserId(userId);
        map.put("articleList",articleEntityList);
        return map;
    }

    /**
    *@description 根据电话号码查询单条记录
    *@author zeal
    *@date 2018/1/12 22:56
    *@version 1.0.0
    */
    public UserEntity findByPhone(String phone){
        return dao.findByPhone(phone);
    }
}