package com.orange.hzm.pojo.dto;

import lombok.Data;

/**
 * @author orange
 * @date 2023/10/01
 * 用户登陆信息实体
 **/
@Data
public class UserInfo {
    private Integer id;
    private String token;
}
