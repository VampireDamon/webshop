package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  
 */
@ApiModel(value = "WsSpecGroup", description = "")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsSpecGroup  extends ShareInfo{

    @ApiModelProperty(name = "id", value = "编号")
    private String id;
    @ApiModelProperty(name = "key", value = "键")
    private long key;
    @ApiModelProperty(name = "name", value = "名称")
    private String name;

}
