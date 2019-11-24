package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单信息 
 */
@ApiModel(value = "WsOrder", description = "订单信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsOrder  extends ShareInfo{

    @ApiModelProperty(name = "id", value = "编号")
    private String id;
    @ApiModelProperty(name = "totalAmount", value = "订单金额")
    private double totalAmount;
    @ApiModelProperty(name = "status", value = "订单状态")
    private String status;
    @ApiModelProperty(name = "userId", value = "用户编号")
    private String userId;
    @ApiModelProperty(name = "paymentWay", value = "支付方式")
    private String paymentWay;
    @ApiModelProperty(name = "outTradeNo", value = "支付流水号")
    private String outTradeNo;

}
