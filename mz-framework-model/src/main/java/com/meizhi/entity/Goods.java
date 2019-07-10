package com.meizhi.entity;

import lombok.Data;

import javax.persistence.Entity;


@Entity
@Data
public class Goods {

    private String goodsId;
    private String goodsName;
    private Double price;

}
