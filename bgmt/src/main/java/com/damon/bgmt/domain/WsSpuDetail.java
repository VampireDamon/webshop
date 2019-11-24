package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  
 */
@ApiModel(value = "WsSpuDetail", description = "")
@Data
@EqualsAndHashCode(callSuper=false)
public class WsSpuDetail extends ShareInfo{

    @ApiModelProperty(name = "id", value = "编号")
    private String id;
    @ApiModelProperty(name = "genericSpecGroupKey", value = "普通规格键")
    private String genericSpecGroupKey;
    @ApiModelProperty(name = "genericSpecGroup", value = "普通规格")
    private String genericSpecGroup;
    @ApiModelProperty(name = "specialSpecGroupKey", value = "特殊规格键")
    private String specialSpecGroupKey;
    @ApiModelProperty(name = "specialSpecGroup", value = "特殊规格")
    private String specialSpecGroup;
    @ApiModelProperty(name = "packingList", value = "附赠品单")
    private String packingList;

}
