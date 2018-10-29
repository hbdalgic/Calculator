package com.etstur.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class RequestModel {

    private Integer firstNumber;
    private Integer secondNumber;
    private Operator operator;
}
