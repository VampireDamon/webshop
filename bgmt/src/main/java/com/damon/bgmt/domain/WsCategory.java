package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品细分类表 
 */
@ApiModel(value = "WsCategory", description = "商品细分类表")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsCategory extends ShareInfo {

    @ApiModelProperty(name = "id", value = "编号")
    private String id;
    @ApiModelProperty(name = "name", value = "名称")
    private String name;
    @ApiModelProperty(name = "categoryType", value = "大分类")
    private String categoryType;
    @ApiModelProperty(name = "categorySpecGroupKey", value = "规格参数键")
    private String categorySpecGroupKey;
    @ApiModelProperty(name = "categorySpecGroup", value = "规格参数")
    private String categorySpecGroup;

}
