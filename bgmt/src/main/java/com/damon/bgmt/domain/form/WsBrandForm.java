package com.damon.bgmt.domain.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.damon.bgmt.domain.WsBrand;

/**
 * 品牌表视图 
 */
@ApiModel(value = "WsBrandForm", description = "品牌表视图")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsBrandForm extends WsBrand {

    @ApiModelProperty(name = "updateUserInfo", value = "更新人信息")
    private SysUserForm updateUserInfo;
    @ApiModelProperty(name = "createUserInfo", value = "创建人信息")
    private SysUserForm createUserInfo;

}
