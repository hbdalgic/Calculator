package com.etstur.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message){
        super(message);
    }
    public DomainException(){

    }
}
