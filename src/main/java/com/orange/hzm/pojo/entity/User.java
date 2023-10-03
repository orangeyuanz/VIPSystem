package com.orange.hzm.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    private Integer id;
    private String userName;
    private String passWorld;
    private String role;
}
