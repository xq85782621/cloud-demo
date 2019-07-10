package com.meizhi.client;

import com.meizhi.model.response.ListResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 */
@FeignClient(value = "mz-service-goods",fallback = GoodsClientFallBack.class)
public interface GoodsClient {

    @GetMapping("/goods/{page}/{size}/{time}")
    ListResponseResult goodsList(@PathVariable("page") Integer page, @PathVariable("size") Integer size,@PathVariable("time") Integer time);
}
