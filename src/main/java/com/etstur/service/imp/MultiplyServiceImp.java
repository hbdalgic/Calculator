package com.etstur.service.imp;

import com.etstur.service.CalculateService;
import com.etstur.model.Operator;
import com.etstur.model.RequestModel;
import org.springframework.stereotype.Service;

@Service
public class MultiplyServiceImp implements CalculateService {
    private final Operator operator=Operator.MULTIPLY;
    @Override
    public Float calculate(RequestModel requestModel) {
        return requestModel.getFirstNumber().floatValue() * requestModel.getSecondNumber().floatValue();
    }

    @Override
    public Boolean findOperator(Operator operator) {
        return this.operator.equals(operator);
    }
}
