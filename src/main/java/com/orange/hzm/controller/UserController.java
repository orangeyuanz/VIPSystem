package com.orange.hzm.controller;

import com.orange.hzm.common.Result;
import com.orange.hzm.pojo.entity.User;
import com.orange.hzm.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author orange
 * @Date 2023/09/23
 * 后台用户
 * @TODO
 **/
@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * @Author orange
     * @Date 2023/09/23
     * @Note 测试方法
     * @TODO
     **/
    @GetMapping("/findAll")
    public Result findAll(){
        return Result.success(userService.list(null));
    }

    /**
     * @Author orange
     * @Date 2023/09/23
     * @Note 创建后台用户
     * @TODO
     **/
    public Result doCreate(User user){


        return Result.success();
    }
}
