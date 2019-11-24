package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  
 */
@ApiModel(value = "WsSpecParams", description = "")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsSpecParams  extends ShareInfo{

    @ApiModelProperty(name = "id", value = "编号")
    private String id;
    @ApiModelProperty(name = "groupId", value = "父属性编号")
    private String groupId;
    @ApiModelProperty(name = "groupKey", value = "父属性键")
    private long groupKey;
    @ApiModelProperty(name = "key", value = "键")
    private long key;
    @ApiModelProperty(name = "name", value = "名称")
    private String name;

}
