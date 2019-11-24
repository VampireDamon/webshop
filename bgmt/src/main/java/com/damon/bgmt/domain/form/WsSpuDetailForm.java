package com.damon.bgmt.domain.form;

import com.damon.bgmt.domain.WsSpuDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 视图 
 */
@ApiModel(value = "WsSpuDetailForm", description = "视图")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsSpuDetailForm extends WsSpuDetail {

    @ApiModelProperty(name = "updateUserInfo", value = "更新人信息")
    private SysUserForm updateUserInfo;
    @ApiModelProperty(name = "createUserInfo", value = "创建人信息")
    private SysUserForm createUserInfo;

}
