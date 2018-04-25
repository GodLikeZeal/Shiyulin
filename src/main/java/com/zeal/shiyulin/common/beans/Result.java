package com.zeal.shiyulin.common.beans;
/**
 * Created by Zeal on 2017/12/6.
 */


import com.wordnik.swagger.annotations.ApiModelProperty;


import java.io.Serializable;

/**
 * 返回对象
 *
 * @auther Zeal
 * @create 2017/12/6
 **/
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="处理状态（success or error）", required=true)
    private String status;

    @ApiModelProperty("消息提示")
    private String message;

    @ApiModelProperty(value="数据", required=true)
    private T data;

    public Result() { setDataAndMessage(null, "请求成功", new Object[0]); }

    public Result(T data)
    {
        setDataAndMessage(data, "请求成功", new Object[0]);
    }

    public Result(String status,String message,T data)
    {
        this.status=status;
        this.data = data;
        this.message = message;
    }

    private void setDataAndMessage(T data, String message, Object[] args) {
        this.status="success";
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message, Object[] args) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
