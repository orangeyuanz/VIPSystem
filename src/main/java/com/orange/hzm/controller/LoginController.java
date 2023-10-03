package com.orange.hzm.controller;

import com.orange.hzm.common.Constants;
import com.orange.hzm.common.Result;
import com.orange.hzm.pojo.dto.AccountInfo;
import com.orange.hzm.pojo.entity.Account;
import com.orange.hzm.request.LoginRequest;
import com.orange.hzm.response.LoginResponse;
import com.orange.hzm.service.impl.AccountServiceImpl;
import com.orange.hzm.utils.StringUtil;
import com.orange.hzm.utils.TokenUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author orange
 * @date 2023/09/30
 * @apiNote 后端登陆
 * @todo 日志功能 验证码
 **/
@RestController
@RequestMapping("/login")
public class LoginController {
    /**
     * 账户接口
     */
    @Resource
    private AccountServiceImpl accountService;
    /**
     * @author orange
     * @date 2023/09/30
     * @params
     * @apiNote 后台登陆接口
     * @todo 验证码
     **/
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Result doLogin(HttpServletRequest httpServletRequest, @RequestBody LoginRequest loginRequest){
        String userAgent = httpServletRequest.getHeader("user-agent");
        String userName = loginRequest.getUserName();
        String password = loginRequest.getPassword();
        //用户名密码检测
        if(StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)){
            return Result.error(Constants.CODE_400,"参数错误");
        } else{
            AccountInfo accountInfo = accountService.getAccountByName(userName);
            if (accountInfo == null){
                return Result.error(Constants.CODE_400,"参数错误");
            }
            Account account = accountService.getAccountById(accountInfo.getId());
            String myPassworld = account.getPassword();
            String inputPassworld = password; //todo 密码应使用md5加密
            if (!myPassworld.equals(inputPassworld)){
                return Result.error("201","账号或密码错误");
            }
            //设置token
            String token = TokenUtil.generateToken(accountInfo.getId(),password,userAgent);
            accountInfo.setToken(token);
            TokenUtil.saveAccountToken(accountInfo);
            //响应
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setIsLogin(true);
            loginResponse.setToken(token);
            loginResponse.setTokenCreateTime(new Date());
            return Result.success(loginResponse);
        }
    }
}
