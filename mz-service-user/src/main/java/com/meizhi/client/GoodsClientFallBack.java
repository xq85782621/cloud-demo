package com.meizhi.client;

import com.meizhi.model.response.CommonCode;
import com.meizhi.model.response.ListResponseResult;
import org.springframework.stereotype.Component;

@Component
public class GoodsClientFallBack implements GoodsClient {
    @Override

    public ListResponseResult goodsList(Integer page, Integer size,Integer time) {
        System.err.println("是否走了失败逻辑");
       ListResponseResult responseResult = new ListResponseResult(CommonCode.Test, null);
       return responseResult;
    }
}
