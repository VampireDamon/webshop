package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  
 */
@ApiModel(value = "WsSkuDetail", description = "")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsSkuDetail  extends ShareInfo{

    @ApiModelProperty(name = "id", value = "编号")
    private String id;
    @ApiModelProperty(name = "paramDataKey", value = "参数键")
    private String paramDataKey;
    @ApiModelProperty(name = "paramData", value = "参数")
    private String paramData;

}
