package com.lee.pract.xdemoredis2021529.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCodeEnum {

    SUCCESS(200, "success"),
    BAD_REQUEST(400, "bad request"),
    API_NOT_FOUND(404, "api not found"),
    SERVER_ERROR(500, "server page error"),
    DATA_NOT_EXIST(888, "data not exist"),

    ;

    private Integer code;

    private String message;

}
