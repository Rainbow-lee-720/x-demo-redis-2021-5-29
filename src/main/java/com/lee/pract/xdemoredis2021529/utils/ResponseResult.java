package com.lee.pract.xdemoredis2021529.utils;

import com.lee.pract.xdemoredis2021529.status.ResponseCodeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseResult <T> {

    private Integer code;

    private String message;

    private T data;

    public ResponseResult() {
    }

    public ResponseResult(ResponseCodeEnum responseCodeEnum) {
        this.code = responseCodeEnum.getCode();
        this.message = responseCodeEnum.getMessage();
    }

    public ResponseResult(ResponseCodeEnum responseCodeEnum, T data) {
        this.code = responseCodeEnum.getCode();
        this.message = responseCodeEnum.getMessage();
        this.data = data;
    }

}
