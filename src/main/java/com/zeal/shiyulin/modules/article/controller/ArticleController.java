/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.article.controller;



import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.Authorization;
import com.zeal.shiyulin.common.beans.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.zeal.shiyulin.modules.authority.entity.UserEntity;
import com.zeal.shiyulin.modules.authority.entity.UserInfoEntity;
import com.zeal.shiyulin.modules.authority.service.UserInfoService;
import com.zeal.shiyulin.modules.authority.service.UserService;
import com.zeal.shiyulin.modules.currency.service.CurrencyService;
import com.zeal.shiyulin.paginate.PaginateDataResponse;
import com.zeal.shiyulin.modules.article.entity.ArticleEntity;
import com.zeal.shiyulin.modules.article.service.ArticleService;
import com.zeal.shiyulin.exception.ExceptionUtils;
import com.zeal.shiyulin.exception.ZealException;
import com.zeal.shiyulin.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * articleRest服务接口
 *
 * @author zeal
 * @date 2017-11-05 16:40:54
 */
@RestController
@RequestMapping(value = "article")
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    CurrencyService currencyService;

    /**
     * 通过ID查找对象
     * @author zeal
     * @date 2017-12-07 15:36:36
     */
    @ApiOperation(value = "通过ID查找对象[对象]", response=ArticleEntity.class, notes = "通过ID查找对象")
    @RequestMapping(value="/findById/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id,HttpServletRequest request,
                           HttpServletResponse response){
        try{
            return new Result(articleService.findById(id));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class查找对象
     * @author zeal
     * @date 2017-12-07 15:36:36
     */
    @ApiOperation(value = "通过Class查找对象[List]", response=ArticleEntity.class, notes = "通过Class查找对象")
    @RequestMapping(value="/findByClass",method = RequestMethod.POST)
    public Result findByClass(@RequestBody ArticleEntity articleEntity,
                              HttpServletRequest request,HttpServletResponse response){
        try{
            return new Result(articleService.findByClass(articleEntity));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class分页查找对象
     * @author zeal
     * @date 2017-12-07 15:36:36
     */
    @ApiOperation(value = "通过Class分页查找对象[分页]", response=ArticleEntity.class, notes = "通过Class分页查找对象")
    @RequestMapping(value="/findByClassWithPaginate",method = RequestMethod.POST)
    public PaginateDataResponse findByClassWithPaginate(@RequestParam Map<String,String> allRequestParam,
                                                        @RequestBody ArticleEntity articleEntity,
                                                        HttpServletRequest request, HttpServletResponse response){

        try{
            if(allRequestParam.containsKey("size")){
                articleEntity.setSize(Integer.valueOf(allRequestParam.get("size")));
            }
            if(allRequestParam.containsKey("start")){
                articleEntity.setStart(Integer.valueOf(allRequestParam.get("start")));
            }
            if(allRequestParam.containsKey("order")){
                articleEntity.setOrder(String.valueOf(allRequestParam.get("order")));
            }
            if(allRequestParam.containsKey("sort")){
                articleEntity.setSort(String.valueOf(allRequestParam.get("sort")));
            }
            return articleService.listPage(articleEntity);
        }
        catch(Exception er){
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过url参数查找分页对象
     * @author zeal
     * @date 2017-12-07 15:36:36
     */
    @ApiOperation(value = "通过url参数查找分页对象[分页]", response=ArticleEntity.class, notes = "通过url参数查找分页对象")
    @RequestMapping(value="/findByClassWithPaginate",method = RequestMethod.GET)
    public PaginateDataResponse findByClassWithPaginate(@RequestParam Map<String,String> allRequestParam,
                                                        HttpServletRequest request, HttpServletResponse response){

        try{
            ArticleEntity articleEntity = new ArticleEntity(allRequestParam);
            return articleService.listPage(articleEntity);
        }
        catch(Exception er){
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 新增记录
     * @author zeal
     * @date 2017-12-07 15:36:36
     */
    @ApiOperation(value = "新增记录[对象]", response=ArticleEntity.class, notes = "新增记录")
    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public Result insert(@RequestBody ArticleEntity articleEntity,HttpServletRequest request,
                         HttpServletResponse response){
        try{
            return  new Result(articleService.insert(articleEntity));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 更新数据
     * @author zeal
     * @date 2017-12-07 15:36:36
     */
    @ApiOperation(value = "更新数据[对象]", response=ArticleEntity.class, notes = "更新数据")
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Result update(@RequestBody ArticleEntity articleEntity,HttpServletRequest request,
                         HttpServletResponse response){
        try{
            return new Result(articleService.update(articleEntity));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class删除信息
     * @author zeal
     * @date 2017-12-07 15:36:36
     */
    @ApiOperation(value = "通过Class删除信息[int]", response=Integer.class, notes = "通过Class删除信息")
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody ArticleEntity articleEntity,HttpServletRequest request,
                         HttpServletResponse response){
        try{
            return new Result(articleService.delete(articleEntity));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过ID删除信息
     * @author zeal
     * @date 2017-12-07 15:36:36
     */
    @ApiOperation(value = "通过ID删除信息[int]", response=Integer.class, notes = "通过ID删除信息")
    @RequestMapping(value="/deleteById/{id}",method = RequestMethod.POST)
    public Result deleteById(@PathVariable String id,HttpServletRequest request,
                             HttpServletResponse response){
        try{
            return new Result(articleService.deleteById(id));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }
    /**
     * @auther Zeal
     * @description 文章上传
     * @date 2017/11/5 16:50
     */
    @RequestMapping(value="/saveArticle",method = RequestMethod.POST)
    public long saveArticle(@RequestParam Map<String,String > allRequestParam,
                            HttpServletRequest request, HttpServletResponse response){

        try {
            UserEntity userEntity = (UserEntity)SecurityUtils.getSubject().getSession().getAttribute("user");
            if (userEntity != null) {
                MultipartHttpServletRequest re = (MultipartHttpServletRequest) request;
                ArticleEntity articleEntity = new ArticleEntity(allRequestParam);
                articleEntity.setUserId(String.valueOf(userEntity.getId()));
                articleService.saveArticle(re, articleEntity);
                return articleEntity.getId();
            }else {
                throw new ZealException("用户未登录或登陆超时");
            }
        }
        catch(Exception er){
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }
    /**
    * @auther zeal
    * @description 通过ID查找对象并且返回页面
    * @date 2017/11/6 18:58
    */
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ModelAndView articleDetail(@PathVariable String id, HttpServletRequest request,
                                      HttpServletResponse response){
        try{
            ModelAndView modelAndView=new ModelAndView();
            ArticleEntity articleEntity = articleService.findById(id);
            if (articleEntity!=null) {
                UserEntity author = userService.findById(String.valueOf(articleEntity.getUserId()));
                UserInfoEntity author_info = userInfoService.findUserInfoByUserId(articleEntity.getUserId());
                modelAndView.addObject("articleEntity", articleEntity);
                modelAndView.addObject("author", author);
                modelAndView.addObject("author_info", author_info);
                modelAndView.setViewName("article/articleDetail");
                //浏览量增加
                ArticleEntity articleEntity1 = new ArticleEntity();
                articleEntity1.setId(articleEntity.getId());
                articleEntity1.setReader(articleEntity.getReader() + 1);
                articleService.update(articleEntity1);
            }else {
                modelAndView.setViewName("erorr/404");
            }
            return modelAndView;
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }
    /**
     *@description 获取用户自身创建的资源列表
     *@author zeal
     *@date 2018/1/10 22:11
     *@version 1.0.0
     */
    @ApiOperation(value = "获取用户自身创建的资源列表[对象]", response=Result.class, notes = "获取用户自身创建的资源列表")
    @RequestMapping(value="/getArticleList",method = RequestMethod.GET)
    public PaginateDataResponse getArticleList(@RequestParam Map<String,String> map, HttpServletRequest request,
                                 HttpServletResponse response){
        try{
            if (StringUtils.isNotEmpty(map.get("pageNumber"))){
                map.put("start",String.valueOf(Integer.valueOf(map.get("pageNumber"))-1));
            }
            if (StringUtils.isNotEmpty(map.get("pageSize"))){
                map.put("size",map.get("pageSize"));
            }
            UserEntity userEntity = currencyService.getCurrentUser();
            if (userEntity!=null) {
                ArticleEntity articleEntity = new ArticleEntity(map);
                articleEntity.setUserId(userEntity.getId().toString());
                return articleService.listPage(articleEntity);
            }else {
                throw new ZealException("用户未登录");
            }
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }
}