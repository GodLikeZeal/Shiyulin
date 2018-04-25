/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.article.entity;

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
 * article实体类接口
 * 
 * @author zeal
 * @date 2018-01-12 23:03:17
 */
public class ArticleEntity extends CommonEntity<ArticleEntity> {
	private static final long serialVersionUID = 1L;
	protected int revision;
	//属性字段
	@ApiModelProperty(value = "收藏")
	private Integer collection; // 收藏
	@ApiModelProperty(value = "评论")
	private Integer comment; // 评论
	@ApiModelProperty(value = "文章内容")
	private String content; // 文章内容
	@ApiModelProperty(value = "创建时间")
	private Date createDate; // 创建时间
	@ApiModelProperty(value = "不喜欢")
	private Integer dislike; // 不喜欢
	@ApiModelProperty(value = "主键")
	private Long id; // 主键
	@ApiModelProperty(value = "是否删除")
	private String isDel; // 是否删除
	@ApiModelProperty(value = "标签")
	private String label; // 标签
	@ApiModelProperty(value = "封面")
	private String pic; // 封面
	@ApiModelProperty(value = "赞赏钱")
	private BigDecimal praiseMoney; // 赞赏钱
	@ApiModelProperty(value = "赞赏人数")
	private Integer praiseNum; // 赞赏人数
	@ApiModelProperty(value = "浏览量")
	private Integer reader; // 浏览量
	@ApiModelProperty(value = "转载")
	private Integer reprint; // 转载
	@ApiModelProperty(value = "副标题")
	private String subtitle; // 副标题
	@ApiModelProperty(value = "点赞")
	private Integer thumbs; // 点赞
	@ApiModelProperty(value = "标题")
	private String title; // 标题
	@ApiModelProperty(value = "类型")
	private String type; // 类型
	@ApiModelProperty(value = "更新时间")
	private Date updateDate; // 更新时间
	@ApiModelProperty(value = "用户外键")
	private String userId; // 用户外键


	//属性字段是否变化
	private Boolean idChanged = false; // 主键
	private Boolean collectionChanged = false; // 收藏
	private Boolean thumbsChanged = false; // 点赞
	private Boolean dislikeChanged = false; // 不喜欢
	private Boolean praiseNumChanged = false; // 赞赏人数
	private Boolean praiseMoneyChanged = false; // 赞赏钱
	private Boolean commentChanged = false; // 评论
	private Boolean userIdChanged = false; // 用户外键
	private Boolean isDelChanged = false; // 是否删除
	private Boolean createDateChanged = false; // 创建时间
	private Boolean updateDateChanged = false; // 更新时间
	private Boolean titleChanged = false; // 标题
	private Boolean subtitleChanged = false; // 副标题
	private Boolean picChanged = false; // 封面
	private Boolean contentChanged = false; // 文章内容
	private Boolean typeChanged = false; // 类型
	private Boolean labelChanged = false; // 标签
	private Boolean readerChanged = false; // 浏览量
	private Boolean reprintChanged = false; // 转载


	/**
	 * 无参构造函数
	 */
	public ArticleEntity() {
		super();
	}

	public ArticleEntity(Map<String,String> allRequestParams)  throws Exception{
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
			setId(Long.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"id"))); // 主键
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"collection")) {
			setCollection(Integer.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"collection"))); // 收藏
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"thumbs")) {
			setThumbs(Integer.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"thumbs"))); // 点赞
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"dislike")) {
			setDislike(Integer.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"dislike"))); // 不喜欢
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"praiseNum")) {
			setPraiseNum(Integer.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"praiseNum"))); // 赞赏人数
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"praiseMoney")) {
			setPraiseMoney(BigDecimal.valueOf(Long.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"praiseMoney")))); // 赞赏钱
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"comment")) {
			setComment(Integer.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"comment"))); // 评论
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"userId")) {
			setUserId(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"userId"))); // 用户外键
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"isDel")) {
			setIsDel(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"isDel"))); // 是否删除
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"createDate")) {
			setCreateDate(formater.parse(CommonUtils.getMapValueIgnoreCase(allRequestParams,"createDate"))); // 创建时间
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"updateDate")) {
			setUpdateDate(formater.parse(CommonUtils.getMapValueIgnoreCase(allRequestParams,"updateDate"))); // 更新时间
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"title")) {
			setTitle(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"title"))); // 标题
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"subtitle")) {
			setSubtitle(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"subtitle"))); // 副标题
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"pic")) {
			setPic(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"pic"))); // 封面
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"content")) {
			setContent(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"content"))); // 文章内容
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"type")) {
			setType(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"type"))); // 类型
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"label")) {
			setLabel(String.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"label"))); // 标签
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"reader")) {
			setReader(Integer.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"reader"))); // 浏览量
		}
		if (CommonUtils.mapContainsKey(allRequestParams,"reprint")) {
			setReprint(Integer.valueOf(CommonUtils.getMapValueIgnoreCase(allRequestParams,"reprint"))); // 转载
		}
	}



	/**
	 * 获取“主键”
	 *
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置“主键”
	 *
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
		idChanged = true;
	}
	/**
	 * 获取“收藏”
	 *
	 * @return collection
	 */
	public Integer getCollection() {
		return collection;
	}

	/**
	 * 设置“收藏”
	 *
	 * @param collection
	 */
	public void setCollection(Integer collection) {
		this.collection = collection;
		collectionChanged = true;
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
	 * 获取“不喜欢”
	 *
	 * @return dislike
	 */
	public Integer getDislike() {
		return dislike;
	}

	/**
	 * 设置“不喜欢”
	 *
	 * @param dislike
	 */
	public void setDislike(Integer dislike) {
		this.dislike = dislike;
		dislikeChanged = true;
	}
	/**
	 * 获取“赞赏人数”
	 *
	 * @return praiseNum
	 */
	public Integer getPraiseNum() {
		return praiseNum;
	}

	/**
	 * 设置“赞赏人数”
	 *
	 * @param praiseNum
	 */
	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
		praiseNumChanged = true;
	}
	/**
	 * 获取“赞赏钱”
	 *
	 * @return praiseMoney
	 */
	public BigDecimal getPraiseMoney() {
		return praiseMoney;
	}

	/**
	 * 设置“赞赏钱”
	 *
	 * @param praiseMoney
	 */
	public void setPraiseMoney(BigDecimal praiseMoney) {
		this.praiseMoney = praiseMoney;
		praiseMoneyChanged = true;
	}
	/**
	 * 获取“评论”
	 *
	 * @return comment
	 */
	public Integer getComment() {
		return comment;
	}

	/**
	 * 设置“评论”
	 *
	 * @param comment
	 */
	public void setComment(Integer comment) {
		this.comment = comment;
		commentChanged = true;
	}
	/**
	 * 获取“用户外键”
	 *
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 设置“用户外键”
	 *
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
		userIdChanged = true;
	}
	/**
	 * 获取“是否删除”
	 *
	 * @return isDel
	 */
	public String getIsDel() {
		return isDel;
	}

	/**
	 * 设置“是否删除”
	 *
	 * @param isDel
	 */
	public void setIsDel(String isDel) {
		this.isDel = isDel;
		isDelChanged = true;
	}
	/**
	 * 获取“创建时间”
	 *
	 * @return createDate
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置“创建时间”
	 *
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
		createDateChanged = true;
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
	 * 获取“标题”
	 *
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置“标题”
	 *
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
		titleChanged = true;
	}
	/**
	 * 获取“副标题”
	 *
	 * @return subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * 设置“副标题”
	 *
	 * @param subtitle
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
		subtitleChanged = true;
	}
	/**
	 * 获取“封面”
	 *
	 * @return pic
	 */
	public String getPic() {
		return pic;
	}

	/**
	 * 设置“封面”
	 *
	 * @param pic
	 */
	public void setPic(String pic) {
		this.pic = pic;
		picChanged = true;
	}
	/**
	 * 获取“文章内容”
	 *
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置“文章内容”
	 *
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
		contentChanged = true;
	}
	/**
	 * 获取“类型”
	 *
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置“类型”
	 *
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
		typeChanged = true;
	}
	/**
	 * 获取“标签”
	 *
	 * @return label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * 设置“标签”
	 *
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
		labelChanged = true;
	}
	/**
	 * 获取“浏览量”
	 *
	 * @return reader
	 */
	public Integer getReader() {
		return reader;
	}

	/**
	 * 设置“浏览量”
	 *
	 * @param reader
	 */
	public void setReader(Integer reader) {
		this.reader = reader;
		readerChanged = true;
	}
	/**
	 * 获取“转载”
	 *
	 * @return reprint
	 */
	public Integer getReprint() {
		return reprint;
	}

	/**
	 * 设置“转载”
	 *
	 * @param reprint
	 */
	public void setReprint(Integer reprint) {
		this.reprint = reprint;
		reprintChanged = true;
	}

    /**
	 * 对象结果输出字符串
	 * @return
	 * @throws Exception
     */
	public String entityToString(){
	    StringBuilder sbSql=new StringBuilder();
	    sbSql.append("this.class = " + this.toString() + AutoCodeConstants.LINEFEED);
	    sbSql.append("id = " + getId() + AutoCodeConstants.LINEFEED);  // 主键
	    sbSql.append("collection = " + getCollection() + AutoCodeConstants.LINEFEED);  // 收藏
	    sbSql.append("thumbs = " + getThumbs() + AutoCodeConstants.LINEFEED);  // 点赞
	    sbSql.append("dislike = " + getDislike() + AutoCodeConstants.LINEFEED);  // 不喜欢
	    sbSql.append("praiseNum = " + getPraiseNum() + AutoCodeConstants.LINEFEED);  // 赞赏人数
	    sbSql.append("praiseMoney = " + getPraiseMoney() + AutoCodeConstants.LINEFEED);  // 赞赏钱
	    sbSql.append("comment = " + getComment() + AutoCodeConstants.LINEFEED);  // 评论
	    sbSql.append("userId = " + getUserId() + AutoCodeConstants.LINEFEED);  // 用户外键
	    sbSql.append("isDel = " + getIsDel() + AutoCodeConstants.LINEFEED);  // 是否删除
	    sbSql.append("createDate = " + DateUtils.formatDateTime(getCreateDate()) + AutoCodeConstants.LINEFEED);  // 创建时间
	    sbSql.append("updateDate = " + DateUtils.formatDateTime(getUpdateDate()) + AutoCodeConstants.LINEFEED);  // 更新时间
	    sbSql.append("title = " + getTitle() + AutoCodeConstants.LINEFEED);  // 标题
	    sbSql.append("subtitle = " + getSubtitle() + AutoCodeConstants.LINEFEED);  // 副标题
	    sbSql.append("pic = " + getPic() + AutoCodeConstants.LINEFEED);  // 封面
	    sbSql.append("content = " + getContent() + AutoCodeConstants.LINEFEED);  // 文章内容
	    sbSql.append("type = " + getType() + AutoCodeConstants.LINEFEED);  // 类型
	    sbSql.append("label = " + getLabel() + AutoCodeConstants.LINEFEED);  // 标签
	    sbSql.append("reader = " + getReader() + AutoCodeConstants.LINEFEED);  // 浏览量
	    sbSql.append("reprint = " + getReprint() + AutoCodeConstants.LINEFEED);  // 转载
        return sbSql.toString();

	}

    /**
     * 重置属性变化状态
     * @param changeState
     */
	public void resetChangeState(Boolean changeState){
        idChanged = changeState; // 主键
        collectionChanged = changeState; // 收藏
        thumbsChanged = changeState; // 点赞
        dislikeChanged = changeState; // 不喜欢
        praiseNumChanged = changeState; // 赞赏人数
        praiseMoneyChanged = changeState; // 赞赏钱
        commentChanged = changeState; // 评论
        userIdChanged = changeState; // 用户外键
        isDelChanged = changeState; // 是否删除
        createDateChanged = changeState; // 创建时间
        updateDateChanged = changeState; // 更新时间
        titleChanged = changeState; // 标题
        subtitleChanged = changeState; // 副标题
        picChanged = changeState; // 封面
        contentChanged = changeState; // 文章内容
        typeChanged = changeState; // 类型
        labelChanged = changeState; // 标签
        readerChanged = changeState; // 浏览量
        reprintChanged = changeState; // 转载
    }


}