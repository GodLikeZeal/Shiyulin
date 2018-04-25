/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.article.dao;

import com.zeal.shiyulin.common.annotation.MyBatisDao;
import com.zeal.shiyulin.modules.article.entity.ArticleEntity;
import com.zeal.shiyulin.common.structure.CommonDao;

import java.util.List;

/**
 * article数据访问接口
 * 
 * @author zeal
 * @date 2017-11-05 16:40:54
 */
@MyBatisDao
public interface ArticleDao extends CommonDao<ArticleEntity> {

    /**
    *@description 根据用户编号来获取用户的所有文章列表
    *@author zeal
    *@date 2018/1/10 21:29
    *@version 1.0.0
    */
    List<ArticleEntity> findArticleListByUserId(String userId);
}