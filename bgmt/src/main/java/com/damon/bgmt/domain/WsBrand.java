package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 品牌表
 */
@ApiModel(value = "WsBrand", description = "品牌表")
@Data
@EqualsAndHashCode(callSuper = false)
public class WsBrand extends ShareInfo {

    @ApiModelProperty(name = "id", value = "编号")
    private String id;
    @ApiModelProperty(name = "name", value = "名称")
    private String name;
    @ApiModelProperty(name = "firstLetter", value = "首字母")
    private String firstLetter;
    @ApiModelProperty(name = "serial", value = "顺序")
    private long serial;
    @ApiModelProperty(name = "factoryStatus", value = "是否品牌制造商：0->不是；1->是")
    private long factoryStatus;
    @ApiModelProperty(name = "isValid", value = "是否有效（0:否；1:是）")
    private long isValid;
    @ApiModelProperty(name = "productCount", value = "产品数量")
    private long productCount;
    @ApiModelProperty(name = "productCommentCount", value = "产品评论数量")
    private long productCommentCount;
    @ApiModelProperty(name = "logo", value = "品牌logo")
    private String logo;
    @ApiModelProperty(name = "bigPic", value = "专区大图")
    private String bigPic;
    @ApiModelProperty(name = "brandStory", value = "品牌故事")
    private String brandStory;
    @ApiModelProperty(name = "updateUserId", value = "更新人")
    private String updateUserId;
    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private String updateTime;
    @ApiModelProperty(name = "createUserId", value = "创建人")
    private String createUserId;
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private String createTime;

}
