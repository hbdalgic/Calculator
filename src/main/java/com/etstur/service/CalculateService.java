package com.etstur.service;

import com.etstur.model.Operator;
import com.etstur.model.RequestModel;

public interface CalculateService {
    Float calculate(RequestModel requestModel);
    Boolean findOperator(Operator operator);
}
