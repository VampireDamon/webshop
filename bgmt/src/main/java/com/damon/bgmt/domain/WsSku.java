package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  
 */
@ApiModel(value = "WsSku", description = "")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsSku  extends ShareInfo{

    @ApiModelProperty(name = "id", value = "编号")
    private String id;
    @ApiModelProperty(name = "skuCode", value = "sku编码")
    private long skuCode;
    @ApiModelProperty(name = "spuId", value = "产品编号")
    private String spuId;
    @ApiModelProperty(name = "spuCode", value = "产品编码")
    private long spuCode;
    @ApiModelProperty(name = "name", value = "名称")
    private String name;
    @ApiModelProperty(name = "weight", value = "重量")
    private double weight;
    @ApiModelProperty(name = "price", value = "价格")
    private double price;
    @ApiModelProperty(name = "picPath", value = "图片")
    private String picPath;
    @ApiModelProperty(name = "status", value = "状态")
    private String status;

}
