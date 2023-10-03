package com.orange.hzm.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.hzm.common.Constants;
import com.orange.hzm.pojo.dto.AccountInfo;
import com.orange.hzm.pojo.dto.UserInfo;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenUtil {
    public static int TOKEN_OVER_TIME = 604800;
    /**
     * 生成token
     *
     * @param userId,password 用户id 密码
     * @return
     * */
    public static String generateToken(Integer userId, String password,String userAgent) {
        StringBuilder token = new StringBuilder();
        UserAgent userAgent1 = UserAgent.parseUserAgentString(userAgent);
        if (userAgent1.getOperatingSystem().isMobileDevice()){
            token.append("APP_");
        } else {
            token.append("PC_");
        }
        token.append(userId);// 将 user id 保存到 token 里面,作为载荷
        return JWT.create().withAudience(token.toString())
                .withExpiresAt(DateUtil.offsetHour(new Date(), 48)) // 2小时后token过期
                .sign(Algorithm.HMAC256(password)); // 以 password 作为 token 的密钥
    }

    /**
     * 保存token
     * */
    public static void saveToken(UserInfo userInfo) {
        if (userInfo == null || userInfo.getToken() == null) {
            return;
        }
        RedisUtil.set(Constants.SESSION_USER + userInfo.getToken(), userInfo, TOKEN_OVER_TIME);
    }

    /**
     * 通过token获取后台登录信息
     *
     * @param token
     * @return
     * */
    public static UserInfo getUserInfoByToken(String token) {
        Object loginInfo = RedisUtil.get(Constants.SESSION_USER + token);
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfo userInfo = objectMapper.convertValue(loginInfo, UserInfo.class);
        if (userInfo != null && userInfo.getToken().equals(token)) {
            return userInfo;
        }
        return null;
    }

    /**
     * 检查是否登录
     *
     * @param token
     * @return
     * */
    public static boolean checkTokenLogin(String token) {
        UserInfo userInfo = RedisUtil.get(Constants.SESSION_USER + token);
        if (userInfo != null && userInfo.getToken().equals(token)) {
            return true;
        }
        return false;
    }

    /**
     * 删除登录信息
     *
     * @param token
     * @return
     * */
    public static boolean removeToken(String token) {
        RedisUtil.remove(token);
        return true;
    }

    /**
     * 保存后台登录token
     * @param accountInfo
     * @return
     * */
    public static void saveAccountToken(AccountInfo accountInfo) {
        if (accountInfo == null) {
            return;
        }
        RedisUtil.set(Constants.SESSION_ADMIN_USER + accountInfo.getToken(), accountInfo, -1);
    }

    /**
     * 通过登录token获取后台登录信息
     *
     * @param token
     * @return
     * */
    public static AccountInfo getAccountInfoByToken(String token) {
        Object loginInfo = RedisUtil.get(Constants.SESSION_ADMIN_USER + token);
        ObjectMapper objectMapper = new ObjectMapper();
        AccountInfo accountInfo = objectMapper.convertValue(loginInfo, AccountInfo.class);
        if (accountInfo != null && accountInfo.getToken().equals(token)) {
            return accountInfo;
        }
        return null;
    }
}
