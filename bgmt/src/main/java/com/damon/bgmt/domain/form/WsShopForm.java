package com.damon.bgmt.domain.form;

import com.damon.bgmt.domain.WsShop;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 店铺视图类
 */
@ApiModel(value = "SysRoleForm", description = "店铺信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsShopForm extends WsShop {

    @ApiModelProperty(name = "typeName", value = "分类（多选）名称")
    private String typeName;

    @ApiModelProperty(name = "statusName", value = "店铺状态名称")
    private String statusName;

    @ApiModelProperty(name = "updateUserInfo", value = "更新人信息")
    private SysUserForm updateUserInfo;

    @ApiModelProperty(name = "createUserInfo", value = "创建人信息")
    private SysUserForm createUserInfo;

}
