package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单信息类
 */
@ApiModel(value = "SysMenu", description = "菜单信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class SysMenu extends ShareInfo {

    @ApiModelProperty(name = "id", value = "编号")
    private String id;

    @ApiModelProperty(name = "href", value = "链接")
    private String href;

    @ApiModelProperty(name = "icon", value = "图标")
    private String icon;

    @ApiModelProperty(name = "name", value = "菜单名称")
    private String name;

    @ApiModelProperty(name = "no", value = "菜单编号")
    private String no;

    @ApiModelProperty(name = "parentId", value = "直接上级编号")
    private String parentId;

    @ApiModelProperty(name = "parentIds", value = "全部上级编号")
    private String parentIds;

    @ApiModelProperty(name = "isValid", value = "是否有效")
    private Integer isValid;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

}
