package com.meizhi.api;

import com.meizhi.model.response.ListResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.GetMapping;



@Api(value="商品管理",description = "商品中心相关接口")
public interface GoodsControllerApi {

    @GetMapping("/{page}/{size}/{time}")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    ListResponseResult goodsList( Integer page, Integer size,Integer time);
}
