package com.damon.bgmt.domain.form;

import com.damon.bgmt.domain.SysRoleMenus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色菜单视图类
 */
@ApiModel(value = "SysRoleMenusForm", description = "角色菜单信息")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleMenusForm extends SysRoleMenus {

    @ApiModelProperty(name = "sysRoleForm", value = "角色信息")
    private SysRoleForm sysRoleForm;

    @ApiModelProperty(name = "sysMenuForm", value = "菜单信息")
    private SysMenuForm sysMenuForm;

    @ApiModelProperty(name = "updateUserInfo", value = "更新人信息")
    private SysUserForm updateUserInfo;

    @ApiModelProperty(name = "createUserInfo", value = "创建人信息")
    private SysUserForm createUserInfo;

}
