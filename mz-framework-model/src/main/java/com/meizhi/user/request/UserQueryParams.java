package com.meizhi.user.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "查询参数封装")
public class UserQueryParams implements Serializable {

    @ApiModelProperty(value = "用户名")
    private String name;

    private String start_time;

    private String end_time;


}
