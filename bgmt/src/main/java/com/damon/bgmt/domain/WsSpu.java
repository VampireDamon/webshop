package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  
 */
@ApiModel(value = "WsSpu", description = "")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsSpu  extends ShareInfo{

    @ApiModelProperty(name = "id", value = "编号")
    private String id;
    @ApiModelProperty(name = "spuCode", value = "spu编码")
    private long spuCode;
    @ApiModelProperty(name = "name", value = "商品名称")
    private String name;
    @ApiModelProperty(name = "description", value = "商品介绍")
    private String description;
    @ApiModelProperty(name = "status", value = "商品状态（字典goods_status）")
    private String status;
    @ApiModelProperty(name = "brandId", value = "品牌编号")
    private String brandId;
    @ApiModelProperty(name = "categoryId", value = "品类编号")
    private String categoryId;

}
