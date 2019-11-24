package com.damon.bgmt.domain.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.damon.bgmt.domain.WsOrderDetail;

/**
 * 订单详情视图 
 */
@ApiModel(value = "WsOrderDetailForm", description = "订单详情视图")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsOrderDetailForm extends WsOrderDetail {

    @ApiModelProperty(name = "updateUserInfo", value = "更新人信息")
    private SysUserForm updateUserInfo;
    @ApiModelProperty(name = "createUserInfo", value = "创建人信息")
    private SysUserForm createUserInfo;

}
