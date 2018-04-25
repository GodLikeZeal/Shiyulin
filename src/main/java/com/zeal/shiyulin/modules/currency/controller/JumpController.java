package com.zeal.shiyulin.modules.currency.controller;

import com.zeal.shiyulin.modules.article.entity.ArticleEntity;
import com.zeal.shiyulin.modules.article.service.ArticleService;
import com.zeal.shiyulin.modules.authority.service.UserService;
import com.zeal.shiyulin.paginate.PaginateDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zeal on 2017/6/30.
 */
@Controller
public class JumpController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    /**
     * index页面跳转
     * @param request
     * @return
     */
    @RequestMapping(value = {"/","/index.html"})
    public ModelAndView index(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        //设置首页跳转路由
        modelAndView.setViewName("index");
        //封装页面数据
        //首先封装热门推荐的数据
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setSize(12);
        articleEntity.setStart(0);
        articleEntity.setSort("DESC");
        articleEntity.setOrder("createDate");
        PaginateDataResponse articleHotData = articleService.listPage(articleEntity);
        modelAndView.addObject("username","zeal");
        modelAndView.addObject("articleHotData",articleHotData);
        System.out.println("首页跳转!");
        return modelAndView;
    }

    /**
    *@description 个人页面跳转
    *@author  zeal
    *@date 2018/1/4 20:52
    * @version 1.0.0
    */
    @RequestMapping(value = {"/profile","/profile.html"})
    public ModelAndView profile(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        //设置首页跳转路由
        modelAndView.setViewName("profile");
        //首先封装热门推荐的数据
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setSize(12);
        articleEntity.setStart(0);
        articleEntity.setSort("DESC");
        articleEntity.setOrder("createDate");
        PaginateDataResponse articleHotData = articleService.listPage(articleEntity);
        modelAndView.addObject("username","zeal");
        modelAndView.addObject("articleHotData",articleHotData);
        System.out.println("首页跳转!");
        return modelAndView;
    }

    /**
    *@description
    *@author  zeal
    *@date 2018/1/6 21:06
    * @version 1.0.0
    */
    @GetMapping(value = "/release/article")
    public ModelAndView addArticle(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        //设置首页跳转路由
        modelAndView.setViewName("article/addArticle");
        //首先封装热门推荐的数据
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setSize(12);
        articleEntity.setStart(0);
        articleEntity.setSort("DESC");
        articleEntity.setOrder("createDate");
        PaginateDataResponse articleHotData = articleService.listPage(articleEntity);
        modelAndView.addObject("username","zeal");
        modelAndView.addObject("articleHotData",articleHotData);
        System.out.println("首页跳转!");
        return modelAndView;
    }
}
