/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.authority.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeal.shiyulin.common.structure.CommonEntity;
import com.zeal.shiyulin.utils.DateUtils;
import com.zeal.shiyulin.common.global.AutoCodeConstants;
import com.zeal.shiyulin.utils.CommonUtils;

import java.text.SimpleDateFormat;
import java.util.Map;


/**
 * role实体类接口
 * 
 * @author zeal
 * @date 2017-11-05 16:44:15
 */
public class RoleEntity extends CommonEntity<RoleEntity> {
	private static final long serialVersionUID = 1L;
	protected int revision;
	//属性字段
	private Long id; // 自增主键
	private String roleName; // 角色名称
	private String roleDescribe; // 角色介绍
	private String roleStatu; // 角色状态 0失效 1有效
	private Date roleCreateTime; // 创建时间
	private String del; // 伪删除 0删除 1正常


	//属性字段是否变化
	private Boolean idChanged = false; // 自增主键
	private Boolean roleNameChanged = false; // 角色名称
	private Boolean roleDescribeChanged = false; // 角色介绍
	private Boolean roleStatuChanged = false; // 角色状态 0失效 1有效
	private Boolean roleCreateTimeChanged = false; // 创建时间
	private Boolean delChanged = false; // 伪删除 0删除 1正常


	/**
	 * 无参构造函数
	 */
	public RoleEntity() {
		super();
	}

	public RoleEntity(Map<String,String> allRequestParams)  throws Exception{
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
		if (CommonUtils.mapContainsKey(allRequestParams,"roleName")) {
			setRoleName(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"roleName"))); // 角色名称
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"roleDescribe")) {
			setRoleDescribe(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"roleDescribe"))); // 角色介绍
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"roleStatu")) {
			setRoleStatu(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"roleStatu"))); // 角色状态 0失效 1有效
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"roleCreateTime")) {
			setRoleCreateTime(formater.parse(CommonUtils.getMapValueIgnoreCase(allRequestParams,"roleCreateTime"))); // 创建时间
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
	 * 获取“角色名称”
	 *
	 * @return roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 设置“角色名称”
	 *
	 * @param roleName
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
		roleNameChanged = true;
	}
	/**
	 * 获取“角色介绍”
	 *
	 * @return roleDescribe
	 */
	public String getRoleDescribe() {
		return roleDescribe;
	}

	/**
	 * 设置“角色介绍”
	 *
	 * @param roleDescribe
	 */
	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
		roleDescribeChanged = true;
	}
	/**
	 * 获取“角色状态 0失效 1有效”
	 *
	 * @return roleStatu
	 */
	public String getRoleStatu() {
		return roleStatu;
	}

	/**
	 * 设置“角色状态 0失效 1有效”
	 *
	 * @param roleStatu
	 */
	public void setRoleStatu(String roleStatu) {
		this.roleStatu = roleStatu;
		roleStatuChanged = true;
	}
	/**
	 * 获取“创建时间”
	 *
	 * @return roleCreateTime
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRoleCreateTime() {
		return roleCreateTime;
	}

	/**
	 * 设置“创建时间”
	 *
	 * @param roleCreateTime
	 */
	public void setRoleCreateTime(Date roleCreateTime) {
		this.roleCreateTime = roleCreateTime;
		roleCreateTimeChanged = true;
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
	    sbSql.append("roleName = " + getRoleName() + AutoCodeConstants.LINEFEED);  // 角色名称
	    sbSql.append("roleDescribe = " + getRoleDescribe() + AutoCodeConstants.LINEFEED);  // 角色介绍
	    sbSql.append("roleStatu = " + getRoleStatu() + AutoCodeConstants.LINEFEED);  // 角色状态 0失效 1有效
	    sbSql.append("roleCreateTime = " + DateUtils.formatDateTime(getRoleCreateTime()) + AutoCodeConstants.LINEFEED);  // 创建时间
	    sbSql.append("del = " + getDel() + AutoCodeConstants.LINEFEED);  // 伪删除 0删除 1正常
        return sbSql.toString();

	}

    /**
     * 重置属性变化状态
     * @param changeState
     */
	public void resetChangeState(Boolean changeState){
        idChanged = changeState; // 自增主键
        roleNameChanged = changeState; // 角色名称
        roleDescribeChanged = changeState; // 角色介绍
        roleStatuChanged = changeState; // 角色状态 0失效 1有效
        roleCreateTimeChanged = changeState; // 创建时间
        delChanged = changeState; // 伪删除 0删除 1正常
    }


}