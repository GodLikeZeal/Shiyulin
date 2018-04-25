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



/**
 * user_info实体类接口
 * 
 * @author zeal
 * @date 2017-11-30 11:52:18
 */
public class UserInfoEntity extends CommonEntity<UserInfoEntity> {
	private static final long serialVersionUID = 1L;
	protected int revision;
	//属性字段
	private Long id; // 自增主键
	private String nnationwide; // 当前地区
	private String nuserAdress; // 当前地址
	private Integer userAge; // 年龄
	private String userSex; // 性别
	private String userPic; // 用户头像
	private String userAutograph; // 用户个性签名
	private Integer score; // 积分
	private BigDecimal money; // 账户
	private Integer level; // 等级
	private String qrCode; // 二维码
	private String country; // 国家
	private Integer thumbs; // 点赞
	private String tags; // 标签
	private Date birthday; // 生日
	private String constellation; // 星座
	private String job; // 职业
	private String company; // 公司
	private String college; // 学校
	private Long userId; // 用户外键
	private Date updateDate; // 最后更新时间
	private String province; // 省
	private String city; // 市
	private String nationwide; // 地区
	private String userAdress; // 用户住址
	private String ncountry; // 当前国家
	private String nprovince; // 当前省份
	private String ncity; // 当前城市


	//属性字段是否变化
	private Boolean idChanged = false; // 自增主键
	private Boolean nnationwideChanged = false; // 当前地区
	private Boolean nuserAdressChanged = false; // 当前地址
	private Boolean userAgeChanged = false; // 年龄
	private Boolean userSexChanged = false; // 性别
	private Boolean userPicChanged = false; // 用户头像
	private Boolean userAutographChanged = false; // 用户个性签名
	private Boolean scoreChanged = false; // 积分
	private Boolean moneyChanged = false; // 账户
	private Boolean levelChanged = false; // 等级
	private Boolean qrCodeChanged = false; // 二维码
	private Boolean countryChanged = false; // 国家
	private Boolean thumbsChanged = false; // 点赞
	private Boolean tagsChanged = false; // 标签
	private Boolean birthdayChanged = false; // 生日
	private Boolean constellationChanged = false; // 星座
	private Boolean jobChanged = false; // 职业
	private Boolean companyChanged = false; // 公司
	private Boolean collegeChanged = false; // 学校
	private Boolean userIdChanged = false; // 用户外键
	private Boolean updateDateChanged = false; // 最后更新时间
	private Boolean provinceChanged = false; // 省
	private Boolean cityChanged = false; // 市
	private Boolean nationwideChanged = false; // 地区
	private Boolean userAdressChanged = false; // 用户住址
	private Boolean ncountryChanged = false; // 当前国家
	private Boolean nprovinceChanged = false; // 当前省份
	private Boolean ncityChanged = false; // 当前城市


	/**
	 * 无参构造函数
	 */
	public UserInfoEntity() {
		super();
	}

	public UserInfoEntity(Map<String,String> allRequestParams)  throws Exception{
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
		if (CommonUtils.mapContainsKey(allRequestParams,"nnationwide")) {
			setNnationwide(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"nnationwide"))); // 当前地区
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"nuserAdress")) {
			setNuserAdress(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"nuserAdress"))); // 当前地址
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userAge")) {
			setUserAge(Integer.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userAge"))); // 年龄
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userSex")) {
			setUserSex(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userSex"))); // 性别
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userPic")) {
			setUserPic(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userPic"))); // 用户头像
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userAutograph")) {
			setUserAutograph(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userAutograph"))); // 用户个性签名
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"score")) {
			setScore(Integer.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"score"))); // 积分
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"money")) {
			setMoney(BigDecimal.valueOf(Long.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"money")))); // 账户
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"level")) {
			setLevel(Integer.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"level"))); // 等级
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"qrCode")) {
			setQrCode(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"qrCode"))); // 二维码
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"country")) {
			setCountry(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"country"))); // 国家
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"thumbs")) {
			setThumbs(Integer.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"thumbs"))); // 点赞
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"tags")) {
			setTags(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"tags"))); // 标签
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"birthday")) {
			setBirthday(formater.parse(CommonUtils.getMapValueIgnoreCase(allRequestParams,"birthday"))); // 生日
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"constellation")) {
			setConstellation(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"constellation"))); // 星座
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"job")) {
			setJob(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"job"))); // 职业
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"company")) {
			setCompany(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"company"))); // 公司
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"college")) {
			setCollege(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"college"))); // 学校
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userId")) {
			setUserId(Long.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userId"))); // 用户外键
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"updateDate")) {
			setUpdateDate(formater.parse(CommonUtils.getMapValueIgnoreCase(allRequestParams,"updateDate"))); // 最后更新时间
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"province")) {
			setProvince(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"province"))); // 省
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"city")) {
			setCity(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"city"))); // 市
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"nationwide")) {
			setNationwide(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"nationwide"))); // 地区
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userAdress")) {
			setUserAdress(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userAdress"))); // 用户住址
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"ncountry")) {
			setNcountry(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"ncountry"))); // 当前国家
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"nprovince")) {
			setNprovince(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"nprovince"))); // 当前省份
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"ncity")) {
			setNcity(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"ncity"))); // 当前城市
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
	 * 获取“当前地区”
	 *
	 * @return nnationwide
	 */
	public String getNnationwide() {
		return nnationwide;
	}

	/**
	 * 设置“当前地区”
	 *
	 * @param nnationwide
	 */
	public void setNnationwide(String nnationwide) {
		this.nnationwide = nnationwide;
		nnationwideChanged = true;
	}
	/**
	 * 获取“当前地址”
	 *
	 * @return nuserAdress
	 */
	public String getNuserAdress() {
		return nuserAdress;
	}

	/**
	 * 设置“当前地址”
	 *
	 * @param nuserAdress
	 */
	public void setNuserAdress(String nuserAdress) {
		this.nuserAdress = nuserAdress;
		nuserAdressChanged = true;
	}
	/**
	 * 获取“年龄”
	 *
	 * @return userAge
	 */
	public Integer getUserAge() {
		return userAge;
	}

	/**
	 * 设置“年龄”
	 *
	 * @param userAge
	 */
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
		userAgeChanged = true;
	}
	/**
	 * 获取“性别”
	 *
	 * @return userSex
	 */
	public String getUserSex() {
		return userSex;
	}

	/**
	 * 设置“性别”
	 *
	 * @param userSex
	 */
	public void setUserSex(String userSex) {
		this.userSex = userSex;
		userSexChanged = true;
	}
	/**
	 * 获取“用户头像”
	 *
	 * @return userPic
	 */
	public String getUserPic() {
		return userPic;
	}

	/**
	 * 设置“用户头像”
	 *
	 * @param userPic
	 */
	public void setUserPic(String userPic) {
		this.userPic = userPic;
		userPicChanged = true;
	}
	/**
	 * 获取“用户个性签名”
	 *
	 * @return userAutograph
	 */
	public String getUserAutograph() {
		return userAutograph;
	}

	/**
	 * 设置“用户个性签名”
	 *
	 * @param userAutograph
	 */
	public void setUserAutograph(String userAutograph) {
		this.userAutograph = userAutograph;
		userAutographChanged = true;
	}
	/**
	 * 获取“积分”
	 *
	 * @return score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * 设置“积分”
	 *
	 * @param score
	 */
	public void setScore(Integer score) {
		this.score = score;
		scoreChanged = true;
	}
	/**
	 * 获取“账户”
	 *
	 * @return money
	 */
	public BigDecimal getMoney() {
		return money;
	}

	/**
	 * 设置“账户”
	 *
	 * @param money
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
		moneyChanged = true;
	}
	/**
	 * 获取“等级”
	 *
	 * @return level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * 设置“等级”
	 *
	 * @param level
	 */
	public void setLevel(Integer level) {
		this.level = level;
		levelChanged = true;
	}
	/**
	 * 获取“二维码”
	 *
	 * @return qrCode
	 */
	public String getQrCode() {
		return qrCode;
	}

	/**
	 * 设置“二维码”
	 *
	 * @param qrCode
	 */
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
		qrCodeChanged = true;
	}
	/**
	 * 获取“国家”
	 *
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 设置“国家”
	 *
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
		countryChanged = true;
	}
	/**
	 * 获取“点赞”
	 *
	 * @return thumbs
	 */
	public Integer getThumbs() {
		return thumbs;
	}

	/**
	 * 设置“点赞”
	 *
	 * @param thumbs
	 */
	public void setThumbs(Integer thumbs) {
		this.thumbs = thumbs;
		thumbsChanged = true;
	}
	/**
	 * 获取“标签”
	 *
	 * @return tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * 设置“标签”
	 *
	 * @param tags
	 */
	public void setTags(String tags) {
		this.tags = tags;
		tagsChanged = true;
	}
	/**
	 * 获取“生日”
	 *
	 * @return birthday
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * 设置“生日”
	 *
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
		birthdayChanged = true;
	}
	/**
	 * 获取“星座”
	 *
	 * @return constellation
	 */
	public String getConstellation() {
		return constellation;
	}

	/**
	 * 设置“星座”
	 *
	 * @param constellation
	 */
	public void setConstellation(String constellation) {
		this.constellation = constellation;
		constellationChanged = true;
	}
	/**
	 * 获取“职业”
	 *
	 * @return job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * 设置“职业”
	 *
	 * @param job
	 */
	public void setJob(String job) {
		this.job = job;
		jobChanged = true;
	}
	/**
	 * 获取“公司”
	 *
	 * @return company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * 设置“公司”
	 *
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
		companyChanged = true;
	}
	/**
	 * 获取“学校”
	 *
	 * @return college
	 */
	public String getCollege() {
		return college;
	}

	/**
	 * 设置“学校”
	 *
	 * @param college
	 */
	public void setCollege(String college) {
		this.college = college;
		collegeChanged = true;
	}
	/**
	 * 获取“用户外键”
	 *
	 * @return userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设置“用户外键”
	 *
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
		userIdChanged = true;
	}
	/**
	 * 获取“最后更新时间”
	 *
	 * @return updateDate
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置“最后更新时间”
	 *
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		updateDateChanged = true;
	}
	/**
	 * 获取“省”
	 *
	 * @return province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 设置“省”
	 *
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
		provinceChanged = true;
	}
	/**
	 * 获取“市”
	 *
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置“市”
	 *
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
		cityChanged = true;
	}
	/**
	 * 获取“地区”
	 *
	 * @return nationwide
	 */
	public String getNationwide() {
		return nationwide;
	}

	/**
	 * 设置“地区”
	 *
	 * @param nationwide
	 */
	public void setNationwide(String nationwide) {
		this.nationwide = nationwide;
		nationwideChanged = true;
	}
	/**
	 * 获取“用户住址”
	 *
	 * @return userAdress
	 */
	public String getUserAdress() {
		return userAdress;
	}

	/**
	 * 设置“用户住址”
	 *
	 * @param userAdress
	 */
	public void setUserAdress(String userAdress) {
		this.userAdress = userAdress;
		userAdressChanged = true;
	}
	/**
	 * 获取“当前国家”
	 *
	 * @return ncountry
	 */
	public String getNcountry() {
		return ncountry;
	}

	/**
	 * 设置“当前国家”
	 *
	 * @param ncountry
	 */
	public void setNcountry(String ncountry) {
		this.ncountry = ncountry;
		ncountryChanged = true;
	}
	/**
	 * 获取“当前省份”
	 *
	 * @return nprovince
	 */
	public String getNprovince() {
		return nprovince;
	}

	/**
	 * 设置“当前省份”
	 *
	 * @param nprovince
	 */
	public void setNprovince(String nprovince) {
		this.nprovince = nprovince;
		nprovinceChanged = true;
	}
	/**
	 * 获取“当前城市”
	 *
	 * @return ncity
	 */
	public String getNcity() {
		return ncity;
	}

	/**
	 * 设置“当前城市”
	 *
	 * @param ncity
	 */
	public void setNcity(String ncity) {
		this.ncity = ncity;
		ncityChanged = true;
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
	    sbSql.append("nnationwide = " + getNnationwide() + AutoCodeConstants.LINEFEED);  // 当前地区
	    sbSql.append("nuserAdress = " + getNuserAdress() + AutoCodeConstants.LINEFEED);  // 当前地址
	    sbSql.append("userAge = " + getUserAge() + AutoCodeConstants.LINEFEED);  // 年龄
	    sbSql.append("userSex = " + getUserSex() + AutoCodeConstants.LINEFEED);  // 性别
	    sbSql.append("userPic = " + getUserPic() + AutoCodeConstants.LINEFEED);  // 用户头像
	    sbSql.append("userAutograph = " + getUserAutograph() + AutoCodeConstants.LINEFEED);  // 用户个性签名
	    sbSql.append("score = " + getScore() + AutoCodeConstants.LINEFEED);  // 积分
	    sbSql.append("money = " + getMoney() + AutoCodeConstants.LINEFEED);  // 账户
	    sbSql.append("level = " + getLevel() + AutoCodeConstants.LINEFEED);  // 等级
	    sbSql.append("qrCode = " + getQrCode() + AutoCodeConstants.LINEFEED);  // 二维码
	    sbSql.append("country = " + getCountry() + AutoCodeConstants.LINEFEED);  // 国家
	    sbSql.append("thumbs = " + getThumbs() + AutoCodeConstants.LINEFEED);  // 点赞
	    sbSql.append("tags = " + getTags() + AutoCodeConstants.LINEFEED);  // 标签
	    sbSql.append("birthday = " + DateUtils.formatDateTime(getBirthday()) + AutoCodeConstants.LINEFEED);  // 生日
	    sbSql.append("constellation = " + getConstellation() + AutoCodeConstants.LINEFEED);  // 星座
	    sbSql.append("job = " + getJob() + AutoCodeConstants.LINEFEED);  // 职业
	    sbSql.append("company = " + getCompany() + AutoCodeConstants.LINEFEED);  // 公司
	    sbSql.append("college = " + getCollege() + AutoCodeConstants.LINEFEED);  // 学校
	    sbSql.append("userId = " + getUserId() + AutoCodeConstants.LINEFEED);  // 用户外键
	    sbSql.append("updateDate = " + DateUtils.formatDateTime(getUpdateDate()) + AutoCodeConstants.LINEFEED);  // 最后更新时间
	    sbSql.append("province = " + getProvince() + AutoCodeConstants.LINEFEED);  // 省
	    sbSql.append("city = " + getCity() + AutoCodeConstants.LINEFEED);  // 市
	    sbSql.append("nationwide = " + getNationwide() + AutoCodeConstants.LINEFEED);  // 地区
	    sbSql.append("userAdress = " + getUserAdress() + AutoCodeConstants.LINEFEED);  // 用户住址
	    sbSql.append("ncountry = " + getNcountry() + AutoCodeConstants.LINEFEED);  // 当前国家
	    sbSql.append("nprovince = " + getNprovince() + AutoCodeConstants.LINEFEED);  // 当前省份
	    sbSql.append("ncity = " + getNcity() + AutoCodeConstants.LINEFEED);  // 当前城市
        return sbSql.toString();

	}

    /**
     * 重置属性变化状态
     * @param changeState
     */
	public void resetChangeState(Boolean changeState){
        idChanged = changeState; // 自增主键
        nnationwideChanged = changeState; // 当前地区
        nuserAdressChanged = changeState; // 当前地址
        userAgeChanged = changeState; // 年龄
        userSexChanged = changeState; // 性别
        userPicChanged = changeState; // 用户头像
        userAutographChanged = changeState; // 用户个性签名
        scoreChanged = changeState; // 积分
        moneyChanged = changeState; // 账户
        levelChanged = changeState; // 等级
        qrCodeChanged = changeState; // 二维码
        countryChanged = changeState; // 国家
        thumbsChanged = changeState; // 点赞
        tagsChanged = changeState; // 标签
        birthdayChanged = changeState; // 生日
        constellationChanged = changeState; // 星座
        jobChanged = changeState; // 职业
        companyChanged = changeState; // 公司
        collegeChanged = changeState; // 学校
        userIdChanged = changeState; // 用户外键
        updateDateChanged = changeState; // 最后更新时间
        provinceChanged = changeState; // 省
        cityChanged = changeState; // 市
        nationwideChanged = changeState; // 地区
        userAdressChanged = changeState; // 用户住址
        ncountryChanged = changeState; // 当前国家
        nprovinceChanged = changeState; // 当前省份
        ncityChanged = changeState; // 当前城市
    }


}