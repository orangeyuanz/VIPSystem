package com.orange.hzm.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author orange
 * @date 2023/09/30
 * @apiNote 后台登陆返回信息
 * @todo
 **/
@Data
public class LoginResponse implements Serializable {

    /**
     * 登陆状态
     */
    private Boolean isLogin;
    /**
     * token创建时间
     */
    private Date tokenCreateTime;
    /**
     * token到期时间
     */
    private Data tokenExpiryTime;
    /**
     * token
     */
    private String token;
}
