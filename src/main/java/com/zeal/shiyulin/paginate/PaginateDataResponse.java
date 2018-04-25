package com.zeal.shiyulin.paginate;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by zeal on 2016/10/24.
 */
public class PaginateDataResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    protected int revision;
    @ApiModelProperty("����")
    Object data;
    @ApiModelProperty("��������")
    long total;
    @ApiModelProperty("ҳ��")
    int start;
    @ApiModelProperty("�������")
    String sort;
    @ApiModelProperty("�����ֶ�")
    String order;
    @ApiModelProperty("��ҳ��ʾ����")
    int size;
    @ApiModelProperty("����")
    Object rows;

    public PaginateDataResponse() {
    }

    public Object getData() {
        return this.data;
    }

    public PaginateDataResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }
}
