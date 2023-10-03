package com.orange.hzm.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author orange
 * @date 2023/09/30
 * @apiNote 后台登陆请求参数
 * @todo
 **/
@Data
public class LoginRequest implements Serializable {
    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名", name="userName")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码", name="password")
    private String password;

    /**
     * 图形验证码
     */
    @ApiModelProperty(value="captchaCode", name="captchaCode")
    private String captchaCode;

    /**
     * 图形验证码uuid
     */
    @ApiModelProperty(value="uuid", name="uuid")
    private String uuid;
}
