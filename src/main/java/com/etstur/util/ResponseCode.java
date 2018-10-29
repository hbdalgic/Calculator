package com.etstur.util;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(200, "SUCCESS"),
    EXCEPTION_FOR_DIVIDE(406, "bölen sayı sıfır olamaz"),
    BAD_REQUEST(400,"BAD REQUEST");
    private Integer code;
    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    }
