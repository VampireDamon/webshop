package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  
 */
@ApiModel(value = "WsStock", description = "")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsStock  extends ShareInfo{

    @ApiModelProperty(name = "id", value = "编号")
    private String id;

}
