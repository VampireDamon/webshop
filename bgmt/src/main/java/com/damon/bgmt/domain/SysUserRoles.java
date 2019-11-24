package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户角色信息类
 */
@ApiModel(value = "SysUserRoles", description = "用户角色信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class SysUserRoles extends ShareInfo {

    @ApiModelProperty(name = "userId", value = "用户编号")
    private String userId;

    @ApiModelProperty(name = "roleId", value = "角色编号")
    private String roleId;

}
