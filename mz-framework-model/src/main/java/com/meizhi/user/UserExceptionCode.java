package com.meizhi.user;

import com.meizhi.model.response.ResultCode;
import lombok.ToString;

@ToString
public enum UserExceptionCode implements ResultCode {


    USER_NOT_EXIST(false,24001,"查询的用户不存在");

    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;


     UserExceptionCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }



    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
