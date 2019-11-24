package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 店铺信息类
 */
@ApiModel(value = "WsShop", description = "店铺信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsShop extends ShareInfo {

    @ApiModelProperty(name = "id", value = "编号")
    private String id;

    @ApiModelProperty(name = "name", value = "店铺名称")
    private String name;

    @ApiModelProperty(name = "name", value = "店铺地址")
    private String address;

    @ApiModelProperty(name = "description", value = "店铺介绍")
    private String description;

    @ApiModelProperty(name = "phone", value = "联系电话")
    private String phone;

    @ApiModelProperty(name = "imagePath", value = "店铺图片地址")
    private String imagePath;

    @ApiModelProperty(name = "type", value = "分类（多选）")
    private String type;

    @ApiModelProperty(name = "status", value = "店铺状态（字典shop_status）")
    private String status;

}
