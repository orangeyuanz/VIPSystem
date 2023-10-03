package com.orange.hzm.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.security.PrivateKey;
import java.time.LocalDateTime;
@Data
public class CostumerDto {

    private Integer id;
    private String name;

    private String phone;

    private Integer count;

    private String card;

    private Integer cardId;

    private LocalDateTime createDate;
}
