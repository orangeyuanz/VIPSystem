package com.orange.hzm.pojo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author orange
 * @since 2023-09-23
 */
@Data
  @ApiModel(value = "Costumer对象", description = "")
public class Costumer implements Serializable {
  private static final long serialVersionUID = 1L;
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;
  @ApiModelProperty("客户姓名")
  private String name;

  @ApiModelProperty("电话号码")
  private String phone;

  @ApiModelProperty("余额")
  private Integer count;

  @ApiModelProperty("会员卡类型")
  private String card;

  @ApiModelProperty("会员卡编号")
  private Integer cardId;

  @ApiModelProperty("创建日期")
  private LocalDateTime createDate;


}
