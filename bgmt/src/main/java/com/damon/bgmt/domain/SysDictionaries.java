package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典表信息
 */
@ApiModel(value = "SysParam", description = "字典表信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class SysDictionaries extends ShareInfo {

    @ApiModelProperty(name = "code", value = "字典代码")
    private String code;

    @ApiModelProperty(name = "refCode", value = "父字典代码")
    private String refCode;

    @ApiModelProperty(name = "level", value = "字典级别")
    private Integer level;

    @ApiModelProperty(name = "isLeaf", value = "是否叶子（0:否；1:是）")
    private Integer isLeaf;

    @ApiModelProperty(name = "name", value = "字典名称")
    private String name;

    @ApiModelProperty(name = "value", value = "字典值")
    private String value;

    @ApiModelProperty(name = "isValid", value = "是否有效（0:否；1:是）")
    private Integer isValid;

    @ApiModelProperty(name = "serial", value = "顺序")
    private Integer serial;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

}