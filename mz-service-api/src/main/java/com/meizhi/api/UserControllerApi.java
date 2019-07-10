package com.meizhi.api;

import com.meizhi.model.response.DetailResponseResult;
import com.meizhi.model.response.ListResponseResult;
import com.meizhi.user.request.UserQueryParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Api(value="用户管理",description = "用户中心相关接口")
public interface UserControllerApi {

    @ApiOperation("根据用户名分页查询用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    ListResponseResult findUser(Integer page, Integer size , UserQueryParams params);



    @ApiOperation("用户详情查询接口")
    @GetMapping("/{id}")
     DetailResponseResult getDetailById(@PathVariable Integer id);


    @ApiOperation("测试feign对hystrix的支持")
    @GetMapping("/goods/{time}")
    @ApiImplicitParams({
            @ApiImplicitParam(name="time",value = "休眠时间",required=true,paramType="path",dataType="int"),
    })
    ListResponseResult getUserGoods(@PathVariable Integer time);
}
