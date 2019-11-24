package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 人员信息类
 */
@ApiModel(value = "SysUser", description = "人员信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class SysUser  extends ShareInfo {

    @ApiModelProperty(name = "id", value = "编号")
    private String id;

    @ApiModelProperty(name = "name", value = "姓名")
    private String name;

    @ApiModelProperty(name = "loginPass", value = "登录密码")
    private String loginPass;

    @ApiModelProperty(name = "cardId", value = "身份证号")
    private String cardId;

    @ApiModelProperty(name = "birthday", value = "生日")
    private String birthday;

    @ApiModelProperty(name = "phone", value = "手机号")
    private String phone;

    @ApiModelProperty(name = "sex", value = "性别")
    private Integer sex;

    @ApiModelProperty(name = "loginAccount", value = "登录账号")
    private String loginAccount;

    @ApiModelProperty(name = "loginCode", value = "登录代码")
    private String loginCode;

    @ApiModelProperty(name = "isValid", value = "是否有效")
    private Integer isValid;

    @ApiModelProperty(name = "email", value = "邮箱")
    private String email;

}
