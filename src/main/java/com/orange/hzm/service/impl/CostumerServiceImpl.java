package com.orange.hzm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.hzm.common.pagination.PaginationRequest;
import com.orange.hzm.pojo.dto.CostumerDto;
import com.orange.hzm.pojo.entity.Costumer;
import com.orange.hzm.mapper.CostumerMapper;
import com.orange.hzm.service.ICostumerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.hzm.utils.TimeUtil;
import jakarta.annotation.Resource;
import org.apache.commons.math3.analysis.function.Cos;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author orange
 * @since 2023-09-23
 */
@Service
public class CostumerServiceImpl extends ServiceImpl<CostumerMapper, Costumer> implements ICostumerService {

    @Resource
    private CostumerMapper costumerMapper;


    @Override
    public Page<Costumer> findPage(PaginationRequest<Costumer> paginationRequest) {
        //分页查询
        Page<Costumer> page = new Page<>(paginationRequest.getCurrentPage(),paginationRequest.getPageSize());
        costumerMapper.selectPage(page,null);
        return page;
    }

    @Override
    public Page<Costumer> smartFindPage(PaginationRequest<Costumer> paginationRequest) {
        QueryWrapper<Costumer> queryWrapper = new QueryWrapper<>();
        Page<Costumer> page = new Page<>(paginationRequest.getCurrentPage(),paginationRequest.getPageSize());
        if (paginationRequest.getCommon() != null){
            queryWrapper.like("name",paginationRequest.getCommon());
            if (costumerMapper.selectPage(page,queryWrapper).getTotal() != 0) {
                return page;
            }
            queryWrapper.clear();
            queryWrapper.like("phone",paginationRequest.getCommon());
            if (costumerMapper.selectPage(page,queryWrapper).getTotal() != 0){
                return page;
            }
            queryWrapper.clear();
            queryWrapper.like("id",paginationRequest.getCommon());
            if (costumerMapper.selectPage(page,queryWrapper).getTotal() != 0){
                return page;
            }
        }else {

            return null;
        }
        return null;
    }
    @Override
    public Costumer saveCostumer(CostumerDto costumerDto) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone",costumerDto.getPhone());
        if (costumerMapper.selectOne(queryWrapper) != null) {
            return null;
        }
        Costumer costumer = new Costumer();
        costumer.setId(null);
        costumer.setCard(costumerDto.getCard());
        costumer.setName(costumerDto.getName());
        costumer.setPhone(costumerDto.getPhone());
        costumer.setCardId(TimeUtil.timeStamp());
        costumer.setCount(costumerDto.getCount());
        costumer.setCreateDate(LocalDateTime.now());
        costumerMapper.insert(costumer);
        return costumer;
    }

    @Override
    public Costumer updateCostumer(CostumerDto costumerDto) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",costumerDto.getId());
        Costumer costumer = costumerMapper.selectOne(queryWrapper);
        if (costumer == null) {
            return null;
        }
        if (costumerDto.getName() != null)
        costumer.setName(costumerDto.getName());
        if (costumerDto.getCount() != null)
        costumer.setCount(costumerDto.getCount());
        if (costumerDto.getCard() != null)
        costumer.setCard(costumerDto.getCard());
        if (costumerDto.getPhone() != null)
        costumer.setPhone(costumerDto.getPhone());
        costumerMapper.update(costumer,queryWrapper);
        return costumer;
    }
}
