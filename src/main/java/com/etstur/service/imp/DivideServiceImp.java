package com.etstur.service.imp;

import com.etstur.service.CalculateService;
import com.etstur.exception.ExceptionForDivide;
import com.etstur.util.ResponseCode;
import com.etstur.model.Operator;
import com.etstur.model.RequestModel;
import org.springframework.stereotype.Service;

@Service
public class DivideServiceImp implements CalculateService {
    private final Operator operator = Operator.DIVIDE;

    @Override
    public Float calculate(RequestModel requestModel) {
        if (requestModel.getSecondNumber().equals(0)) {
            throw new ExceptionForDivide(ResponseCode.EXCEPTION_FOR_DIVIDE);
        }
        return requestModel.getFirstNumber().floatValue() / requestModel.getSecondNumber().floatValue();
    }

    @Override
    public Boolean findOperator(Operator operator) {
        return this.operator.equals(operator);
    }
}
