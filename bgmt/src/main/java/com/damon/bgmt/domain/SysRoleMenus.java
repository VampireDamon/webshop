package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色菜单信息类
 */
@ApiModel(value = "SysRoleMenus", description = "角色菜单信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class SysRoleMenus extends ShareInfo {

    @ApiModelProperty(name = "roleId", value = "角色编号")
    private String roleId;

    @ApiModelProperty(name = "menuId", value = "菜单编号")
    private String menuId;

}
