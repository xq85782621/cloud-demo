package com.meizhi.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * 结果集是列表的都返回该类型
 * @param <T>
 */
@Data
@ToString
//因为该结果集可能要通过fegin返回,要加上空的构造器,不然会报错
@NoArgsConstructor
public class ListResponseResult<T> extends ResponseResult {

    QueryResult<T> queryResult;

    public ListResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
