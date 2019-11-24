package com.damon.bgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 客户端信息类
 */
@ApiModel(value = "OauthClientDetails", description = "客户端信息")
@Data
@EqualsAndHashCode(callSuper=false)
public class OauthClientDetails {

    @ApiModelProperty(name = "clientId", value = "客户端编号")
    private String clientId;

    @ApiModelProperty(name = "resourceIds", value = "客户端所能访问的资源id集合")
    private String resourceIds;

    @ApiModelProperty(name = "clientSecret", value = "客户端(client)的访问密匙")
    private String clientSecret;

    @ApiModelProperty(name = "scope", value = "权限范围")
    private String scope;

    @ApiModelProperty(name = "authorizedGrantTypes", value = "客户端支持")
    private String authorizedGrantTypes;

    @ApiModelProperty(name = "webServerRedirectUri", value = "客户端的重定向URI")
    private String webServerRedirectUri;

    @ApiModelProperty(name = "authorities", value = "权限值")
    private String authorities;

    @ApiModelProperty(name = "accessTokenValidity", value = "客户端的access_token的有效时间值")
    private Integer accessTokenValidity;

    @ApiModelProperty(name = "refreshTokenValidity", value = "客户端的refresh_token的有效时间值")
    private Integer refreshTokenValidity;

    @ApiModelProperty(name = "additionalInformation", value = "预留")
    private String additionalInformation;

    @ApiModelProperty(name = "autoapprove", value = "设置用户是否自动Approval操作")
    private String autoapprove;
}
