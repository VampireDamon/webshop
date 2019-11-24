package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 共有信息
 */
@ApiModel(value = "ShareInfo", description = "共有信息")
@Data
class ShareInfo {

    @ApiModelProperty(name = "updateUserId", value = "更新人")
    private String updateUserId;

    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private String updateTime;

    @ApiModelProperty(name = "createUserId", value = "创建人")
    private String createUserId;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private String createTime;

}