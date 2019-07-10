package com.meizhi.user.response;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.meizhi.entity.Goods;
import com.meizhi.model.response.ListResponseResult;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private String name;//姓名
    private String sex;//性别
    private Date birthday;//出生日期
    private String zipcode;//邮政编码
    private String address;//地址
    private List<Goods> goodsList;
}
