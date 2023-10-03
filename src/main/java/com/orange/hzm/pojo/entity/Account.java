package com.orange.hzm.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author orange
 * @since 2023-09-30
 */
@Data
  @ApiModel(value = "Account对象", description = "")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("主键ID")
        private Integer id;

      @ApiModelProperty("账户编号")
      private String accountKey;

      @ApiModelProperty("账户名称")
      private String accountName;

      @ApiModelProperty("密码")
      private String password;

      @ApiModelProperty("账户状态（1有效，0无效）")
      private Boolean accountStatus;

      @ApiModelProperty("创建日期")
      private LocalDateTime createDate;

      @ApiModelProperty("修改日期")
      private LocalDateTime modifyDate;

      @ApiModelProperty("随机码")
      private String salt;

      @ApiModelProperty("角色Id")
      private String roleIds;


}
