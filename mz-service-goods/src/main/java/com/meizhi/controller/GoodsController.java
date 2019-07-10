package com.meizhi.controller;

import com.meizhi.api.GoodsControllerApi;
import com.meizhi.entity.Goods;
import com.meizhi.model.response.CommonCode;
import com.meizhi.model.response.ListResponseResult;
import com.meizhi.model.response.QueryResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/goods")
public class GoodsController implements GoodsControllerApi {


    @GetMapping("/{page}/{size}/{time}")
    public ListResponseResult goodsList(@PathVariable Integer page, @PathVariable Integer size ,@PathVariable Integer time) {
        System.err.println("进来了");
        try {
            Thread.sleep(time);
        }catch (Exception e){
            System.err.println("出错了");
        }

        List<Goods> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Goods goods = new Goods();
            goods.setGoodsId(i + "");
            goods.setGoodsName("可乐" + i);
            goods.setPrice((double) i + 1);
            list.add(goods);
        }

        QueryResult<Goods>  queryResult = new QueryResult<>();
        queryResult.setList(list);
        queryResult.setTotal(list.size());
        ListResponseResult responseResult = new ListResponseResult(CommonCode.SUCCESS, queryResult);
        return responseResult;

    }

}
