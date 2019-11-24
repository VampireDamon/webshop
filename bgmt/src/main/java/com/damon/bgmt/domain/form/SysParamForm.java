package com.damon.bgmt.domain.form;

import com.damon.bgmt.domain.SysParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统参数视图类
 */
@ApiModel(value = "SysParamForm", description = "系统参数信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class SysParamForm extends SysParam {

    @ApiModelProperty(name = "isValidName", value = "是否有效")
    private String isValidName;

    @ApiModelProperty(name = "updateUserInfo", value = "更新人信息")
    private SysUserForm updateUserInfo;

    @ApiModelProperty(name = "createUserInfo", value = "创建人信息")
    private SysUserForm createUserInfo;

}
