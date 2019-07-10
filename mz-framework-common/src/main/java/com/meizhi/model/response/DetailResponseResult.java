package com.meizhi.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * 结果集是单个对象的都返回此类型
 * @param <T>
 */

@Data
@ToString
//因为该结果集可能要通过fegin返回,要加上空的构造器,不然会报错
@NoArgsConstructor
public class DetailResponseResult<T> extends ResponseResult{

    private T data;


    public DetailResponseResult(ResultCode resultCode,T data){
        super(resultCode);
        this.data = data;
    }

}
