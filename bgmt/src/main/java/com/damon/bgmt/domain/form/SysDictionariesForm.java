package com.damon.bgmt.domain.form;

import com.damon.bgmt.domain.SysDictionaries;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典表视图类
 */
@ApiModel(value = "SysDictionariesForm", description = "字典表视图类")
@Data
@EqualsAndHashCode(callSuper=false)
public class SysDictionariesForm extends SysDictionaries {

    @ApiModelProperty(name = "isLeafName", value = "是否叶子")
    private String isLeafName;

    @ApiModelProperty(name = "isValidName", value = "是否有效")
    private String isValidName;

    @ApiModelProperty(name = "updateUserInfo", value = "更新人信息")
    private SysUserForm updateUserInfo;

    @ApiModelProperty(name = "createUserInfo", value = "创建人信息")
    private SysUserForm createUserInfo;


}