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
import java.math.BigDecimal;
import com.wordnik.swagger.annotations.ApiModelProperty;



/**
 * user实体类接口
 * 
 * @author zeal
 * @date 2018-01-12 22:49:34
 */
public class UserEntity extends CommonEntity<UserEntity> {
	private static final long serialVersionUID = 1L;
	protected int revision;
	//属性字段
	@ApiModelProperty(value = "用户标识")
	private Long id; // 用户标识
	@ApiModelProperty(value = "更新时间")
	private Date updateDate; // 更新时间
	@ApiModelProperty(value = "用户邮箱")
	private String userEmail; // 用户邮箱
	@ApiModelProperty(value = "用户名")
	private String userName; // 用户名
	@ApiModelProperty(value = "用户的openid")
	private String userOpenId; // 用户的openid
	@ApiModelProperty(value = "用户手机号")
	private String userPhoneNumber; // 用户手机号
	@ApiModelProperty(value = "用户登录密码")
	private String userPsd; // 用户登录密码
	@ApiModelProperty(value = "用户QQ号码")
	private String userQQ; // 用户QQ号码
	@ApiModelProperty(value = "注册时间")
	private Date userRegisterTime; // 注册时间
	@ApiModelProperty(value = "用户角色外键")
	private String userRole; // 用户角色外键
	@ApiModelProperty(value = "用户状态")
	private String userStatu; // 用户状态


	//属性字段是否变化
	private Boolean idChanged = false; // 用户标识
	private Boolean userRegisterTimeChanged = false; // 注册时间
	private Boolean updateDateChanged = false; // 更新时间
	private Boolean userNameChanged = false; // 用户名
	private Boolean userPsdChanged = false; // 用户登录密码
	private Boolean userPhoneNumberChanged = false; // 用户手机号
	private Boolean userEmailChanged = false; // 用户邮箱
	private Boolean userQQChanged = false; // 用户QQ号码
	private Boolean userOpenIdChanged = false; // 用户的openid
	private Boolean userRoleChanged = false; // 用户角色外键
	private Boolean userStatuChanged = false; // 用户状态


	/**
	 * 无参构造函数
	 */
	public UserEntity() {
		super();
	}

	public UserEntity(Map<String,String> allRequestParams)  throws Exception{
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
			setId(Long.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"id"))); // 用户标识
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userRegisterTime")) {
			setUserRegisterTime(formater.parse(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userRegisterTime"))); // 注册时间
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"updateDate")) {
			setUpdateDate(formater.parse(CommonUtils.getMapValueIgnoreCase(allRequestParams,"updateDate"))); // 更新时间
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userName")) {
			setUserName(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userName"))); // 用户名
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userPsd")) {
			setUserPsd(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userPsd"))); // 用户登录密码
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userPhoneNumber")) {
			setUserPhoneNumber(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userPhoneNumber"))); // 用户手机号
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userEmail")) {
			setUserEmail(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userEmail"))); // 用户邮箱
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userQQ")) {
			setUserQQ(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userQQ"))); // 用户QQ号码
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userOpenId")) {
			setUserOpenId(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userOpenId"))); // 用户的openid
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userRole")) {
			setUserRole(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userRole"))); // 用户角色外键
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userStatu")) {
			setUserStatu(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userStatu"))); // 用户状态
		}
	}



	/**
	 * 获取“用户标识”
	 *
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置“用户标识”
	 *
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
		idChanged = true;
	}
	/**
	 * 获取“注册时间”
	 *
	 * @return userRegisterTime
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUserRegisterTime() {
		return userRegisterTime;
	}

	/**
	 * 设置“注册时间”
	 *
	 * @param userRegisterTime
	 */
	public void setUserRegisterTime(Date userRegisterTime) {
		this.userRegisterTime = userRegisterTime;
		userRegisterTimeChanged = true;
	}
	/**
	 * 获取“更新时间”
	 *
	 * @return updateDate
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置“更新时间”
	 *
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		updateDateChanged = true;
	}
	/**
	 * 获取“用户名”
	 *
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置“用户名”
	 *
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
		userNameChanged = true;
	}
	/**
	 * 获取“用户登录密码”
	 *
	 * @return userPsd
	 */
	public String getUserPsd() {
		return userPsd;
	}

	/**
	 * 设置“用户登录密码”
	 *
	 * @param userPsd
	 */
	public void setUserPsd(String userPsd) {
		this.userPsd = userPsd;
		userPsdChanged = true;
	}
	/**
	 * 获取“用户手机号”
	 *
	 * @return userPhoneNumber
	 */
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	/**
	 * 设置“用户手机号”
	 *
	 * @param userPhoneNumber
	 */
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
		userPhoneNumberChanged = true;
	}
	/**
	 * 获取“用户邮箱”
	 *
	 * @return userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * 设置“用户邮箱”
	 *
	 * @param userEmail
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		userEmailChanged = true;
	}
	/**
	 * 获取“用户QQ号码”
	 *
	 * @return userQQ
	 */
	public String getUserQQ() {
		return userQQ;
	}

	/**
	 * 设置“用户QQ号码”
	 *
	 * @param userQQ
	 */
	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
		userQQChanged = true;
	}
	/**
	 * 获取“用户的openid”
	 *
	 * @return userOpenId
	 */
	public String getUserOpenId() {
		return userOpenId;
	}

	/**
	 * 设置“用户的openid”
	 *
	 * @param userOpenId
	 */
	public void setUserOpenId(String userOpenId) {
		this.userOpenId = userOpenId;
		userOpenIdChanged = true;
	}
	/**
	 * 获取“用户角色外键”
	 *
	 * @return userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * 设置“用户角色外键”
	 *
	 * @param userRole
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
		userRoleChanged = true;
	}
	/**
	 * 获取“用户状态”
	 *
	 * @return userStatu
	 */
	public String getUserStatu() {
		return userStatu;
	}

	/**
	 * 设置“用户状态”
	 *
	 * @param userStatu
	 */
	public void setUserStatu(String userStatu) {
		this.userStatu = userStatu;
		userStatuChanged = true;
	}

    /**
	 * 对象结果输出字符串
	 * @return
	 * @throws Exception
     */
	public String entityToString(){
	    StringBuilder sbSql=new StringBuilder();
	    sbSql.append("this.class = " + this.toString() + AutoCodeConstants.LINEFEED);
	    sbSql.append("id = " + getId() + AutoCodeConstants.LINEFEED);  // 用户标识
	    sbSql.append("userRegisterTime = " + DateUtils.formatDateTime(getUserRegisterTime()) + AutoCodeConstants.LINEFEED);  // 注册时间
	    sbSql.append("updateDate = " + DateUtils.formatDateTime(getUpdateDate()) + AutoCodeConstants.LINEFEED);  // 更新时间
	    sbSql.append("userName = " + getUserName() + AutoCodeConstants.LINEFEED);  // 用户名
	    sbSql.append("userPsd = " + getUserPsd() + AutoCodeConstants.LINEFEED);  // 用户登录密码
	    sbSql.append("userPhoneNumber = " + getUserPhoneNumber() + AutoCodeConstants.LINEFEED);  // 用户手机号
	    sbSql.append("userEmail = " + getUserEmail() + AutoCodeConstants.LINEFEED);  // 用户邮箱
	    sbSql.append("userQQ = " + getUserQQ() + AutoCodeConstants.LINEFEED);  // 用户QQ号码
	    sbSql.append("userOpenId = " + getUserOpenId() + AutoCodeConstants.LINEFEED);  // 用户的openid
	    sbSql.append("userRole = " + getUserRole() + AutoCodeConstants.LINEFEED);  // 用户角色外键
	    sbSql.append("userStatu = " + getUserStatu() + AutoCodeConstants.LINEFEED);  // 用户状态
        return sbSql.toString();

	}

    /**
     * 重置属性变化状态
     * @param changeState
     */
	public void resetChangeState(Boolean changeState){
        idChanged = changeState; // 用户标识
        userRegisterTimeChanged = changeState; // 注册时间
        updateDateChanged = changeState; // 更新时间
        userNameChanged = changeState; // 用户名
        userPsdChanged = changeState; // 用户登录密码
        userPhoneNumberChanged = changeState; // 用户手机号
        userEmailChanged = changeState; // 用户邮箱
        userQQChanged = changeState; // 用户QQ号码
        userOpenIdChanged = changeState; // 用户的openid
        userRoleChanged = changeState; // 用户角色外键
        userStatuChanged = changeState; // 用户状态
    }


}