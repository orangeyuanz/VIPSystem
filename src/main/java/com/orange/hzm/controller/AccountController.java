package com.orange.hzm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.orange.hzm.common.Result;

import com.orange.hzm.service.IAccountService;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author orange
 * @since 2023-09-30
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private IAccountService accountService;


}

