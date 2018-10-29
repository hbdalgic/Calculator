package com.etstur.exception;

import com.etstur.util.ResponseCode;

public class ExceptionForDivide extends DomainException {
    private ResponseCode responseCode;
    public ExceptionForDivide( ResponseCode responseCode){
        this.responseCode=responseCode;
    }

    public ResponseCode getResponseCode(){
        return responseCode;
    }
}
