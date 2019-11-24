package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  
 */
@ApiModel(value = "WsSpecParamsData", description = "")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsSpecParamsData  extends ShareInfo{

    @ApiModelProperty(name = "id", value = "编号")
    private String id;
    @ApiModelProperty(name = "paramsId", value = "参数编号")
    private String paramsId;
    @ApiModelProperty(name = "paramsKey", value = "参数键")
    private long paramsKey;
    @ApiModelProperty(name = "key", value = "键")
    private long key;
    @ApiModelProperty(name = "name", value = "数据")
    private String name;

}
