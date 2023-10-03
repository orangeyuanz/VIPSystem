package com.orange.hzm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.hzm.common.pagination.PaginationRequest;
import com.orange.hzm.pojo.dto.CostumerDto;
import com.orange.hzm.pojo.entity.Costumer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.commons.math3.analysis.function.Cos;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author orange
 * @since 2023-09-23
 */
public interface ICostumerService extends IService<Costumer> {
    /**
     * @author orange
     * @date 2023/10/01
     * 查询客户所有信息
     * @return Page
     **/
    Page<Costumer> findPage(PaginationRequest<Costumer> paginationRequest);

    /**
     * @param paginationRequest
     * @author orange
     * @date 2023/10/02
     * 一次查询多个字段
     * @todo
     **/
    Page<Costumer> smartFindPage(PaginationRequest<Costumer> paginationRequest);

    /**
     * @param costumerDto
     * @author orange
     * @date 2023/10/03
     * 保存客户信息
     * @todo
     **/
    Costumer saveCostumer(CostumerDto costumerDto);

    /**
     * @param costumerDto
     * @author orange
     * @date 2023/10/03
     * 更新客户信息
     * @todo
     **/
    Costumer updateCostumer(CostumerDto costumerDto);

}
