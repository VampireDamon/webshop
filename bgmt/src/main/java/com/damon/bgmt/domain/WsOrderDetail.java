package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单详情 
 */
@ApiModel(value = "WsOrderDetail", description = "订单详情")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsOrderDetail extends ShareInfo {

    @ApiModelProperty(name = "id", value = "编号")
    private String id;
    @ApiModelProperty(name = "orderId", value = "订单编号")
    private String orderId;
    @ApiModelProperty(name = "goodsId", value = "商品编号")
    private String goodsId;
    @ApiModelProperty(name = "goodsName", value = "商品名称")
    private String goodsName;
    @ApiModelProperty(name = "goodsPrice", value = "商品价格")
    private double goodsPrice;
    @ApiModelProperty(name = "goodsNum", value = "商品数量")
    private long goodsNum;

}
