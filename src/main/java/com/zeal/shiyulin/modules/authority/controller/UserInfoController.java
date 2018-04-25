/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.authority.controller;


import com.wordnik.swagger.annotations.ApiOperation;
import com.zeal.shiyulin.common.beans.Result;
import com.zeal.shiyulin.paginate.PaginateDataResponse;
import com.zeal.shiyulin.modules.authority.entity.UserInfoEntity;
import com.zeal.shiyulin.modules.authority.service.UserInfoService;
import com.zeal.shiyulin.exception.ExceptionUtils;
import com.zeal.shiyulin.exception.ZealException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * user_infoRest服务接口
 *
 * @author zeal
 * @date 2017-12-06 15:58:02
 */
@RestController
@RequestMapping(value="userInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * 通过ID查找对象
     * @author zeal
     * @date 2017-12-07 15:37:29
     */
    @ApiOperation(value = "通过ID查找对象[对象]", response=UserInfoEntity.class, notes = "通过ID查找对象")
    @RequestMapping(value="/findById/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id,HttpServletRequest request,
                           HttpServletResponse response){
        try{
            return new Result(userInfoService.findById(id));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class查找对象
     * @author zeal
     * @date 2017-12-07 15:37:29
     */
    @ApiOperation(value = "通过Class查找对象[List]", response=UserInfoEntity.class, notes = "通过Class查找对象")
    @RequestMapping(value="/findByClass",method = RequestMethod.POST)
    public Result findByClass(@RequestBody UserInfoEntity userInfoEntity,
                              HttpServletRequest request,HttpServletResponse response){
        try{
            return new Result(userInfoService.findByClass(userInfoEntity));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class分页查找对象
     * @author zeal
     * @date 2017-12-07 15:37:29
     */
    @ApiOperation(value = "通过Class分页查找对象[分页]", response=UserInfoEntity.class, notes = "通过Class分页查找对象")
    @RequestMapping(value="/findByClassWithPaginate",method = RequestMethod.POST)
    public PaginateDataResponse findByClassWithPaginate(@RequestParam Map<String,String> allRequestParam,
                                                        @RequestBody UserInfoEntity userInfoEntity,
                                                        HttpServletRequest request, HttpServletResponse response){

        try{
            if(allRequestParam.containsKey("size")){
                userInfoEntity.setSize(Integer.valueOf(allRequestParam.get("size")));
            }
            if(allRequestParam.containsKey("start")){
                userInfoEntity.setStart(Integer.valueOf(allRequestParam.get("start")));
            }
            if(allRequestParam.containsKey("order")){
                userInfoEntity.setOrder(String.valueOf(allRequestParam.get("order")));
            }
            if(allRequestParam.containsKey("sort")){
                userInfoEntity.setSort(String.valueOf(allRequestParam.get("sort")));
            }
            return userInfoService.listPage(userInfoEntity);
        }
        catch(Exception er){
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过url参数查找分页对象
     * @author zeal
     * @date 2017-12-07 15:37:29
     */
    @ApiOperation(value = "通过url参数查找分页对象[分页]", response=UserInfoEntity.class, notes = "通过url参数查找分页对象")
    @RequestMapping(value="/findByClassWithPaginate",method = RequestMethod.GET)
    public PaginateDataResponse findByClassWithPaginate(@RequestParam Map<String,String> allRequestParam,
                                                        HttpServletRequest request, HttpServletResponse response){

        try{
            UserInfoEntity userInfoEntity = new UserInfoEntity(allRequestParam);
            return userInfoService.listPage(userInfoEntity);
        }
        catch(Exception er){
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 新增记录
     * @author zeal
     * @date 2017-12-07 15:37:29
     */
    @ApiOperation(value = "新增记录[对象]", response=UserInfoEntity.class, notes = "新增记录")
    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public Result insert(@RequestBody UserInfoEntity userInfoEntity,HttpServletRequest request,
                         HttpServletResponse response){
        try{
            return  new Result(userInfoService.insert(userInfoEntity));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 更新数据
     * @author zeal
     * @date 2017-12-07 15:37:29
     */
    @ApiOperation(value = "更新数据[对象]", response=UserInfoEntity.class, notes = "更新数据")
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Result update(@RequestBody UserInfoEntity userInfoEntity,HttpServletRequest request,
                         HttpServletResponse response){
        try{
            return new Result(userInfoService.update(userInfoEntity));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class删除信息
     * @author zeal
     * @date 2017-12-07 15:37:29
     */
    @ApiOperation(value = "通过Class删除信息[int]", response=Integer.class, notes = "通过Class删除信息")
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody UserInfoEntity userInfoEntity,HttpServletRequest request,
                         HttpServletResponse response){
        try{
            return new Result(userInfoService.delete(userInfoEntity));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过ID删除信息
     * @author zeal
     * @date 2017-12-07 15:37:29
     */
    @ApiOperation(value = "通过ID删除信息[int]", response=Integer.class, notes = "通过ID删除信息")
    @RequestMapping(value="/deleteById/{id}",method = RequestMethod.POST)
    public Result deleteById(@PathVariable String id,HttpServletRequest request,
                             HttpServletResponse response){
        try{
            return new Result(userInfoService.deleteById(id));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }
}