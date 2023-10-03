package com.orange.hzm.common.pagination;

import lombok.Data;

import java.util.List;

@Data
public class PaginationResponse<T> {
    /**
     * 当前页码
     */
    private int currentPage;
    /**
     * 页面大小
     */
    private int pageSize;
    /**
     * 总页面
     */
    private int totalPage;
    /**
     * 结果集合
     */
    private List<T> content;
}
