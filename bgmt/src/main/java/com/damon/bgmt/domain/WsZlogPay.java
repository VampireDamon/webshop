package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付日志 
 */
@ApiModel(value = "WsZlogPay", description = "支付日志")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsZlogPay  extends ShareInfo{

    @ApiModelProperty(name = "id", value = "编号")
    private String id;
    @ApiModelProperty(name = "outTradeNo", value = "对外业务编号")
    private String outTradeNo;
    @ApiModelProperty(name = "orderId", value = "订单编号")
    private String orderId;
    @ApiModelProperty(name = "alipayTradeNo", value = "支付宝交易流水编号")
    private String alipayTradeNo;
    @ApiModelProperty(name = "totalAmount", value = "支付金额")
    private double totalAmount;
    @ApiModelProperty(name = "subject", value = "交易内容")
    private String subject;
    @ApiModelProperty(name = "paymentType", value = "支付类型")
    private String paymentType;

}
