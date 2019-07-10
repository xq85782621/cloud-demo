package com.meizhi.controller;


import com.meizhi.api.UserControllerApi;
import com.meizhi.client.GoodsClient;
import com.meizhi.entity.User;
import com.meizhi.exception.CustomException;
import com.meizhi.model.response.CommonCode;
import com.meizhi.model.response.DetailResponseResult;
import com.meizhi.model.response.ListResponseResult;
import com.meizhi.model.response.QueryResult;
import com.meizhi.service.UserService;
import com.meizhi.user.UserExceptionCode;
import com.meizhi.user.request.UserQueryParams;
import com.meizhi.user.response.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController implements UserControllerApi {

    @Autowired
    private UserService userService;
    @Autowired
    private GoodsClient goodsClient;


    /**
     * 用来测试结果集是list的接口
     * @param page
     * @param size
     * @param params
     * @return
     */
    @GetMapping("/{page}/{size}")
    public ListResponseResult findUser(@PathVariable Integer page, @PathVariable Integer size , UserQueryParams params){

        /**
         * 模拟出现异常的情况,抛出自定义异常
         */
        if(size == 3){
            throw new CustomException(CommonCode.FAIL);
        }

        /**
         * 抛出非自定义异常
         */
        if(size == 4){
            throw  new NullPointerException();
        }

        //带条件的分页查询
        QueryResult<User> queryResult = userService.listUser( page,size,params);
        ListResponseResult responseResult = new ListResponseResult(CommonCode.SUCCESS, queryResult);
        return responseResult;
    }

    /**
     * 用来测试结果集是对象的接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public DetailResponseResult getDetailById(@PathVariable Integer id){
        UserDto userDetail = userService.getDetaiById(id);
        if(userDetail ==null){
            throw  new CustomException(UserExceptionCode.USER_NOT_EXIST);
        }
        DetailResponseResult<UserDto> responseResult = new DetailResponseResult<>(CommonCode.SUCCESS, userDetail);
        return responseResult;

    }

    /**
     * 用来来测试远程调用
     * 这里通过fegin调用了goods服务中的接口
     */
    @GetMapping("/goods/{time}")
    public ListResponseResult getUserGoods(@PathVariable Integer time){

        long begin = System.currentTimeMillis();
        ListResponseResult response = goodsClient.goodsList(1, 10,time);
        System.err.println(response.getMessage());
        long end = System.currentTimeMillis();
        System.err.println("访问用时："+( end - begin));

        return response;

    }




}
