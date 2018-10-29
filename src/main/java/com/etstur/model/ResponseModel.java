package com.etstur.model;

import com.etstur.util.ResponseCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseModel {
    private Integer code;
    private String message;
    private String response;
    private boolean validated;
    public ResponseModel(ResponseCode responseCode){
        this.code=responseCode.getCode();
        this.message=responseCode.getMessage();
    }
}
