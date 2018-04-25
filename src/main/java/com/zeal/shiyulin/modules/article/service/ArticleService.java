/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.article.service;

import com.zeal.shiyulin.modules.article.dao.ArticleDao;
import com.zeal.shiyulin.modules.article.entity.ArticleEntity;
import com.zeal.shiyulin.paginate.PaginateDataResponse;
import com.zeal.shiyulin.utils.AliyunOSSMethod;
import com.zeal.shiyulin.utils.ImageUtils;
import org.springframework.stereotype.Service;
import com.zeal.shiyulin.common.structure.CommonService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;


/**
 * article业务层
 * 
 * @author zeal
 * @date 2017-11-05 16:40:54
 */
@Service
public class ArticleService extends CommonService<ArticleDao,ArticleEntity> {

    /**
     * @auther Zeal
     * @description
     * @date 2017/11/5 16:48
     */
    public int saveArticle(MultipartHttpServletRequest request, ArticleEntity articleEntity) throws IOException {
        String title= request.getParameter("title");
        String subtitle= request.getParameter("subtitle");
        String type= request.getParameter("type");
        String label= request.getParameter("label");
        String  content= request.getParameter("content");
        MultipartFile fileM = request.getFile("file");
        String resultUrl="";
        if (fileM!=null) {
            byte[] bytes = ImageUtils.cutImage(fileM, Integer.parseInt(request.getParameter("x")),
                    Integer.parseInt(request.getParameter("y")), Integer.parseInt(request.getParameter("w")), Integer.parseInt
                            (request.getParameter("h")));
            resultUrl = new AliyunOSSMethod().uploadFile(bytes);
        }else {
            resultUrl=request.getParameter("file");
        }
        articleEntity.setPic(resultUrl);
        articleEntity.setCreateDate(new Date());
        articleEntity.setUpdateDate(new Date());
        articleEntity.setCollection(0);
        articleEntity.setComment(0);
        articleEntity.setReprint(0);
        articleEntity.setThumbs(0);
        articleEntity.setPraiseNum(0);
        articleEntity.setPraiseMoney(new BigDecimal(0));
        articleEntity.setDislike(0);
        articleEntity.setReader(0);
        return dao.insert(articleEntity);
    }
    /**
     * @auther Zeal
     * @description
     * @date 2017/11/5 16:48
     */
    public int editArticle(MultipartHttpServletRequest request, ArticleEntity articleEntity) throws IOException {
        String title= request.getParameter("title");
        String subtitle= request.getParameter("subtitle");
        String type= request.getParameter("type");
        String label= request.getParameter("label");
        String  content= request.getParameter("content");
        MultipartFile fileM = request.getFile("file");
        String resultUrl="";
        if (fileM!=null) {
            byte[] bytes = ImageUtils.cutImage(fileM, Integer.parseInt(request.getParameter("x")),
                    Integer.parseInt(request.getParameter("y")), Integer.parseInt(request.getParameter("w")), Integer.parseInt
                            (request.getParameter("h")));
            resultUrl = new AliyunOSSMethod().uploadFile(bytes);
        }else {
            resultUrl=request.getParameter("file");
        }
        return dao.update(articleEntity);
    }


}