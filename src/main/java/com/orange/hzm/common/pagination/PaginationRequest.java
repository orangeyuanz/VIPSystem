package com.orange.hzm.common.pagination;

import lombok.Data;

import java.util.Map;
@Data
public class PaginationRequest<T> {
    /**
     * 当前页码
     */
    private int currentPage;
    /**
     * 页面大小
     */
    private int pageSize;
    /**
     * 分页查询参数
     */
    private T data;
    private String common;
}
