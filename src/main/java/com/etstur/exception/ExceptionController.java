package com.etstur.exception;

import com.etstur.model.ResponseModel;
import com.etstur.util.ResponseCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ExceptionForDivide.class)
    @ResponseBody
    public ResponseModel exceptionResponse(ExceptionForDivide e){
        ResponseModel resModel = new ResponseModel(e.getResponseCode());
        resModel.setValidated(false);
        return resModel;
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseModel exception(Exception e){
        ResponseModel resModel = new ResponseModel(ResponseCode.BAD_REQUEST);
        return resModel;
    }
}
