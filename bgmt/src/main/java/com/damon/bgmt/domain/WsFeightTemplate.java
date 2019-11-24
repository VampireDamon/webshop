package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 运费模板 
 */
@ApiModel(value = "WsFeightTemplate", description = "运费模板")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsFeightTemplate extends ShareInfo {

    @ApiModelProperty(name = "id", value = "编号")
    private String id;
    @ApiModelProperty(name = "name", value = "名称")
    private String name;
    @ApiModelProperty(name = "chargeType", value = "计费类型:0->按重量；1->按件数")
    private long chargeType;
    @ApiModelProperty(name = "firstWeight", value = "首重kg")
    private double firstWeight;
    @ApiModelProperty(name = "firstFee", value = "首费（元）")
    private double firstFee;
    @ApiModelProperty(name = "continueWeight", value = "续重kg")
    private double continueWeight;
    @ApiModelProperty(name = "continueFee", value = "续费（元）")
    private double continueFee;
    @ApiModelProperty(name = "dest", value = "目的地（省、市）")
    private String dest;

}
