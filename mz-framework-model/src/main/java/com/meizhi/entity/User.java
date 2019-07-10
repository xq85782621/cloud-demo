package com.meizhi.entity;

import lombok.Data;

import java.util.Date;


@Data
public class User {

    private Long id;//id
    private String name;//姓名
    private String sex;//性别
    private Date birthday;//出生日期
    private Long address_id;

}
