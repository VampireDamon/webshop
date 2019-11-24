package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统参数类
 */
@ApiModel(value = "SysParam", description = "系统参数信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class SysParam  extends ShareInfo{

    @ApiModelProperty(name = "id", value = "编号")
    private String id;

    @ApiModelProperty(name = "name", value = "名称")
    private String name;

    @ApiModelProperty(name = "configKey", value = "配置键")
    private String configKey;

    @ApiModelProperty(name = "configValue", value = "配置值")
    private String configValue;

    @ApiModelProperty(name = "isValid", value = "是否有效（0:否；1:是）")
    private Integer isValid;

    @ApiModelProperty(name = "serial", value = "顺序")
    private Integer serial;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

}
