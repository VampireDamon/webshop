package com.damon.bgmt.domain.form;

import com.damon.bgmt.domain.SysUserRoles;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户角色视图类
 */
@ApiModel(value = "SysUserRolesForm", description = "用户角色信息")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserRolesForm extends SysUserRoles {

    @ApiModelProperty(name = "sysUserForm", value = "用户信息")
    private SysUserForm sysUserForm;

    @ApiModelProperty(name = "sysRoleForm", value = "角色信息")
    private SysRoleForm sysRoleForm;


    @ApiModelProperty(name = "updateUserInfo", value = "更新人信息")
    private SysUserForm updateUserInfo;

    @ApiModelProperty(name = "createUserInfo", value = "创建人信息")
    private SysUserForm createUserInfo;

}
