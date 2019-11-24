package com.damon.bgmt.domain.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.damon.bgmt.domain.WsCategory;

/**
 * 商品细分类表视图 
 */
@ApiModel(value = "WsCategoryForm", description = "商品细分类表视图")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsCategoryForm extends WsCategory {

    @ApiModelProperty(name = "updateUserInfo", value = "更新人信息")
    private SysUserForm updateUserInfo;
    @ApiModelProperty(name = "createUserInfo", value = "创建人信息")
    private SysUserForm createUserInfo;

}
