package com.meizhi.exception;

import com.meizhi.model.response.ResultCode;

/**
 * 自定义异常
 */
public class CustomException extends  RuntimeException {

    private ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }
}
