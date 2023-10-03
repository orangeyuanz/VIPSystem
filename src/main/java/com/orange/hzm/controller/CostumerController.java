package com.orange.hzm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.hzm.common.Constants;
import com.orange.hzm.common.pagination.PaginationRequest;
import com.orange.hzm.pojo.dto.CostumerDto;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import java.util.List;

import com.orange.hzm.common.Result;

import com.orange.hzm.service.ICostumerService;
import com.orange.hzm.pojo.entity.Costumer;

import org.springframework.web.bind.annotation.RestController;

/**
 * @Author orange
 * @Date 2023/09/23
 * @TODO
 **/
@RestController
@RequestMapping("/costumers")
public class CostumerController {

    /**
     * 客户接口
     */
    @Resource
    private ICostumerService costumerService;

    /**
     * @Author orange
     * @Date 2023/09/23
     * 查询所有信息
     * @TODO
     **/
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Result all(@RequestBody PaginationRequest<Costumer> paginationRequest){
        return Result.success(costumerService.findPage(paginationRequest));
    }
    /**
     * @Author orange
     * @Date 2023/09/29
     * @param costumerId
     *
     * @TODO
     **/
    @RequestMapping(value = "/find/{costumerId}",method = RequestMethod.GET)
    public Result findOne(@PathVariable Integer costumerId){
        Costumer costumer = costumerService.getById(costumerId);
        return Result.success(costumer);
    }

    /**
     * @author orange
     * @date 2023/10/02
     * 根据参数模糊查询多个字段（姓名 手机号码 会员ID）
     * @todo 实现对输入参数智能识别
     **/
    @RequestMapping(value = "/smartFind",method = RequestMethod.GET)
    public Result smartFind(@RequestBody PaginationRequest<Costumer> paginationRequest){

        return Result.success(costumerService.smartFindPage(paginationRequest).getRecords());
    }

    /**
     * @author orange
     * @date 2023/10/03
     * 保存客户信息接口
     * @todo
     **/
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@RequestBody CostumerDto costumerDto){
        Costumer costumer = costumerService.saveCostumer(costumerDto);
        if (costumer == null){
            return Result.error("202","手机号码已存在");
        }
        return Result.success(costumer);
    }

    /**
     * @param costumerDto
     * @author orange
     * @date 2023/10/03
     * 更新客户信息
     * @todo
     **/
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Result update(@RequestBody CostumerDto costumerDto){
        Costumer costumer = costumerService.updateCostumer(costumerDto);
        if (costumer == null){
            return Result.error("202","客户不存在");
        }
        return Result.success(costumer);
    }

}

