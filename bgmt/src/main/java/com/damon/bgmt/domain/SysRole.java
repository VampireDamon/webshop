package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色信息类
 */
@ApiModel(value = "SysRole", description = "角色信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class SysRole  extends ShareInfo {

    @ApiModelProperty(name = "id", value = "编号")
    private String id;

    @ApiModelProperty(name = "name", value = "角色名称")
    private String name;

    @ApiModelProperty(name = "isValid", value = "是否有效")
    private Integer isValid;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

}
