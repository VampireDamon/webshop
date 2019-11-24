package com.damon.bgmt.domain.form;

import com.damon.bgmt.domain.OauthClientDetails;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 客户端视图类
 */
@ApiModel(value = "OauthClientDetailsForm", description = "客户端视图类")
@Data
@EqualsAndHashCode(callSuper = false)
public class OauthClientDetailsForm extends OauthClientDetails {


}
