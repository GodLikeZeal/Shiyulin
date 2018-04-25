/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.currency.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeal.shiyulin.common.structure.CommonEntity;
import com.zeal.shiyulin.utils.DateUtils;
import com.zeal.shiyulin.common.global.AutoCodeConstants;
import com.zeal.shiyulin.utils.CommonUtils;

import java.text.SimpleDateFormat;
import java.util.Map;


/**
 * zd_sex实体类接口
 * 
 * @author zeal
 * @date 2017-11-05 16:42:41
 */
public class DictionaryEntity extends CommonEntity<DictionaryEntity> {
	private static final long serialVersionUID = 1L;
	protected int revision;
	//属性字段
	private Long id; // 自增主键
	private String enumValue; // 枚举值
	private String enumName; // 显示值
	private String parentId; // 父节点外键
	private String describe; // 描述
	private String statu; // 状态 0失效 1正常
	private Date createTime; // 创建时间
	private String del; // 伪删除 0删除 1正常


	//属性字段是否变化
	private Boolean idChanged = false; // 自增主键
	private Boolean enumValueChanged = false; // 枚举值
	private Boolean enumNameChanged = false; // 显示值
	private Boolean parentIdChanged = false; // 父节点外键
	private Boolean describeChanged = false; // 描述
	private Boolean statuChanged = false; // 状态 0失效 1正常
	private Boolean createTimeChanged = false; // 创建时间
	private Boolean delChanged = false; // 伪删除 0删除 1正常


	/**
	 * 无参构造函数
	 */
	public DictionaryEntity() {
		super();
	}

	public DictionaryEntity(Map<String,String> allRequestParams)  throws Exception{
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");//用于时间格式化

        if(CommonUtils.mapContainsKey(allRequestParams,"size")){
            setSize(Integer.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"size")));  //每页显示数量
        }
        if(CommonUtils.mapContainsKey(allRequestParams,"start")){
            setStart(Integer.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"start"))); //每页显示起始序号
        }
        if(CommonUtils.mapContainsKey(allRequestParams,"order")){
            setOrder(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"order"))); //排序字段
        }
        if(CommonUtils.mapContainsKey(allRequestParams,"sort")){
           setSort(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"sort"))); //排序方式，desc或asc
        }

		if (CommonUtils.mapContainsKey(allRequestParams,"id")) {
			setId(Long.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"id"))); // 自增主键
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"enumValue")) {
			setEnumValue(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"enumValue"))); // 枚举值
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"enumName")) {
			setEnumName(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"enumName"))); // 显示值
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"parentId")) {
			setParentId(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"parentId"))); // 父节点外键
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"describe")) {
			setDescribe(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"describe"))); // 描述
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"statu")) {
			setStatu(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"statu"))); // 状态 0失效 1正常
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"createTime")) {
			setCreateTime(formater.parse(CommonUtils.getMapValueIgnoreCase(allRequestParams,"createTime"))); // 创建时间
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"del")) {
			setDel(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"del"))); // 伪删除 0删除 1正常
		}
	}



	/**
	 * 获取“自增主键”
	 *
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置“自增主键”
	 *
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
		idChanged = true;
	}
	/**
	 * 获取“枚举值”
	 *
	 * @return enumValue
	 */
	public String getEnumValue() {
		return enumValue;
	}

	/**
	 * 设置“枚举值”
	 *
	 * @param enumValue
	 */
	public void setEnumValue(String enumValue) {
		this.enumValue = enumValue;
		enumValueChanged = true;
	}
	/**
	 * 获取“显示值”
	 *
	 * @return enumName
	 */
	public String getEnumName() {
		return enumName;
	}

	/**
	 * 设置“显示值”
	 *
	 * @param enumName
	 */
	public void setEnumName(String enumName) {
		this.enumName = enumName;
		enumNameChanged = true;
	}
	/**
	 * 获取“父节点外键”
	 *
	 * @return parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * 设置“父节点外键”
	 *
	 * @param parentId
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
		parentIdChanged = true;
	}
	/**
	 * 获取“描述”
	 *
	 * @return describe
	 */
	public String getDescribe() {
		return describe;
	}

	/**
	 * 设置“描述”
	 *
	 * @param describe
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
		describeChanged = true;
	}
	/**
	 * 获取“状态 0失效 1正常”
	 *
	 * @return statu
	 */
	public String getStatu() {
		return statu;
	}

	/**
	 * 设置“状态 0失效 1正常”
	 *
	 * @param statu
	 */
	public void setStatu(String statu) {
		this.statu = statu;
		statuChanged = true;
	}
	/**
	 * 获取“创建时间”
	 *
	 * @return createTime
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置“创建时间”
	 *
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		createTimeChanged = true;
	}
	/**
	 * 获取“伪删除 0删除 1正常”
	 *
	 * @return del
	 */
	public String getDel() {
		return del;
	}

	/**
	 * 设置“伪删除 0删除 1正常”
	 *
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
		delChanged = true;
	}

    /**
	 * 对象结果输出字符串
	 * @return
	 * @throws Exception
     */
	public String entityToString(){
	    StringBuilder sbSql=new StringBuilder();
	    sbSql.append("this.class = " + this.toString() + AutoCodeConstants.LINEFEED);
	    sbSql.append("id = " + getId() + AutoCodeConstants.LINEFEED);  // 自增主键
	    sbSql.append("enumValue = " + getEnumValue() + AutoCodeConstants.LINEFEED);  // 枚举值
	    sbSql.append("enumName = " + getEnumName() + AutoCodeConstants.LINEFEED);  // 显示值
	    sbSql.append("parentId = " + getParentId() + AutoCodeConstants.LINEFEED);  // 父节点外键
	    sbSql.append("describe = " + getDescribe() + AutoCodeConstants.LINEFEED);  // 描述
	    sbSql.append("statu = " + getStatu() + AutoCodeConstants.LINEFEED);  // 状态 0失效 1正常
	    sbSql.append("createTime = " + DateUtils.formatDateTime(getCreateTime()) + AutoCodeConstants.LINEFEED);  // 创建时间
	    sbSql.append("del = " + getDel() + AutoCodeConstants.LINEFEED);  // 伪删除 0删除 1正常
        return sbSql.toString();

	}

    /**
     * 重置属性变化状态
     * @param changeState
     */
	public void resetChangeState(Boolean changeState){
        idChanged = changeState; // 自增主键
        enumValueChanged = changeState; // 枚举值
        enumNameChanged = changeState; // 显示值
        parentIdChanged = changeState; // 父节点外键
        describeChanged = changeState; // 描述
        statuChanged = changeState; // 状态 0失效 1正常
        createTimeChanged = changeState; // 创建时间
        delChanged = changeState; // 伪删除 0删除 1正常
    }


}