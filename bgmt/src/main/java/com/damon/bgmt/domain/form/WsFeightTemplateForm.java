package com.damon.bgmt.domain.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.damon.bgmt.domain.WsFeightTemplate;

/**
 * 运费模板视图 
 */
@ApiModel(value = "WsFeightTemplateForm", description = "运费模板视图")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsFeightTemplateForm extends WsFeightTemplate {

    @ApiModelProperty(name = "updateUserInfo", value = "更新人信息")
    private SysUserForm updateUserInfo;
    @ApiModelProperty(name = "createUserInfo", value = "创建人信息")
    private SysUserForm createUserInfo;

}
