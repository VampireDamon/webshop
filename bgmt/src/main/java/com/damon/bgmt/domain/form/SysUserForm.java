package com.damon.bgmt.domain.form;

import com.damon.bgmt.domain.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 人员信息视图类
 */
@ApiModel(value = "SysUserForm", description = "人员信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class SysUserForm extends SysUser {

    @ApiModelProperty(name = "sexName", value = "性别")
    private String sexName;

    @ApiModelProperty(name = "isValidName", value = "是否有效")
    private String isValidName;

    @ApiModelProperty(name = "updateUserInfo", value = "更新人信息")
    private SysUserForm updateUserInfo;

    @ApiModelProperty(name = "createUserInfo", value = "创建人信息")
    private SysUserForm createUserInfo;

}
