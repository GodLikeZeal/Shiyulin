/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.currency.controller;


import com.wordnik.swagger.annotations.ApiOperation;
import com.zeal.shiyulin.common.beans.Result;
import com.zeal.shiyulin.paginate.PaginateDataResponse;
import com.zeal.shiyulin.modules.currency.entity.DictionaryEntity;
import com.zeal.shiyulin.modules.currency.service.DictionaryService;
import com.zeal.shiyulin.exception.ExceptionUtils;
import com.zeal.shiyulin.exception.ZealException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * roleRest服务接口
 *
 * @author zeal
 * @date 2017-12-07 15:38:03
 */
@RestController
@RequestMapping(value="dictionary")
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    /**
     * 通过ID查找对象
     * @author zeal
     * @date 2017-12-07 15:38:03
     */
    @ApiOperation(value = "通过ID查找对象[对象]", response=DictionaryEntity.class, notes = "通过ID查找对象")
    @RequestMapping(value="/findById/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id,HttpServletRequest request,
                                            HttpServletResponse response){
        try{
            return new Result(dictionaryService.findById(id));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class查找对象
     * @author zeal
     * @date 2017-12-07 15:38:03
     */
    @ApiOperation(value = "通过Class查找对象[List]", response=DictionaryEntity.class, notes = "通过Class查找对象")
    @RequestMapping(value="/findByClass",method = RequestMethod.POST)
    public Result findByClass(@RequestBody DictionaryEntity dictionaryEntity,
                                            HttpServletRequest request,HttpServletResponse response){
        try{
            return new Result(dictionaryService.findByClass(dictionaryEntity));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class分页查找对象
     * @author zeal
     * @date 2017-12-07 15:38:03
     */
    @ApiOperation(value = "通过Class分页查找对象[分页]", response=DictionaryEntity.class, notes = "通过Class分页查找对象")
    @RequestMapping(value="/findByClassWithPaginate",method = RequestMethod.POST)
    public PaginateDataResponse findByClassWithPaginate(@RequestParam Map<String,String> allRequestParam,
                                                        @RequestBody DictionaryEntity dictionaryEntity,
                                                        HttpServletRequest request, HttpServletResponse response){

        try{
            if(allRequestParam.containsKey("size")){
                dictionaryEntity.setSize(Integer.valueOf(allRequestParam.get("size")));
            }
            if(allRequestParam.containsKey("start")){
                dictionaryEntity.setStart(Integer.valueOf(allRequestParam.get("start")));
            }
            if(allRequestParam.containsKey("order")){
                dictionaryEntity.setOrder(String.valueOf(allRequestParam.get("order")));
            }
            if(allRequestParam.containsKey("sort")){
                dictionaryEntity.setSort(String.valueOf(allRequestParam.get("sort")));
            }
            return dictionaryService.listPage(dictionaryEntity);
        }
        catch(Exception er){
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过url参数查找分页对象
     * @author zeal
     * @date 2017-12-07 15:38:03
     */
    @ApiOperation(value = "通过url参数查找分页对象[分页]", response=DictionaryEntity.class, notes = "通过url参数查找分页对象")
    @RequestMapping(value="/findByClassWithPaginate",method = RequestMethod.GET)
    public PaginateDataResponse findByClassWithPaginate(@RequestParam Map<String,String> allRequestParam,
                                                        HttpServletRequest request, HttpServletResponse response){

        try{
            DictionaryEntity dictionaryEntity = new DictionaryEntity(allRequestParam);
            return dictionaryService.listPage(dictionaryEntity);
        }
        catch(Exception er){
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 新增记录
     * @author zeal
     * @date 2017-12-07 15:38:03
     */
    @ApiOperation(value = "新增记录[对象]", response=DictionaryEntity.class, notes = "新增记录")
    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public Result insert(@RequestBody DictionaryEntity dictionaryEntity,HttpServletRequest request,
                       HttpServletResponse response){
        try{
              return  new Result(dictionaryService.insert(dictionaryEntity));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 更新数据
     * @author zeal
     * @date 2017-12-07 15:38:03
     */
    @ApiOperation(value = "更新数据[对象]", response=DictionaryEntity.class, notes = "更新数据")
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Result update(@RequestBody DictionaryEntity dictionaryEntity,HttpServletRequest request,
                       HttpServletResponse response){
        try{
            return new Result(dictionaryService.update(dictionaryEntity));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class删除信息
     * @author zeal
     * @date 2017-12-07 15:38:03
     */
    @ApiOperation(value = "通过Class删除信息[int]", response=Integer.class, notes = "通过Class删除信息")
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody DictionaryEntity dictionaryEntity,HttpServletRequest request,
                       HttpServletResponse response){
        try{
             return new Result(dictionaryService.delete(dictionaryEntity));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过ID删除信息
     * @author zeal
     * @date 2017-12-07 15:38:03
     */
    @ApiOperation(value = "通过ID删除信息[int]", response=Integer.class, notes = "通过ID删除信息")
    @RequestMapping(value="/deleteById/{id}",method = RequestMethod.POST)
    public Result deleteById(@PathVariable String id,HttpServletRequest request,
                       HttpServletResponse response){
        try{
            return new Result(dictionaryService.deleteById(id));
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }
}