package com.damon.bgmt.domain.form;

import com.damon.bgmt.domain.SysMenu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单视图类
 */
@ApiModel(value = "SysMenuForm", description = "菜单信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class SysMenuForm extends SysMenu {

    @ApiModelProperty(name = "isValidName", value = "是否有效")
    private String isValidName;

    @ApiModelProperty(name = "updateUserInfo", value = "更新人信息")
    private SysUserForm updateUserInfo;

    @ApiModelProperty(name = "createUserInfo", value = "创建人信息")
    private SysUserForm createUserInfo;

}
