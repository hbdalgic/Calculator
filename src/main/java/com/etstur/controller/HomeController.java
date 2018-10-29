package com.etstur.controller;

import com.etstur.service.CalculateService;
import com.etstur.exception.ExceptionForDivide;
import com.etstur.util.ResponseCode;
import com.etstur.model.Operator;
import com.etstur.model.RequestModel;
import com.etstur.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private Collection<CalculateService> calculateService;

    @RequestMapping(value = "/")
    public String home(Model model) {
        List<Operator> enums = Arrays.asList(Operator.values());

        model.addAttribute("enums", enums);
        return "home";
    }

    @PostMapping(value = "/home", consumes = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseModel calculate(@Valid @RequestBody RequestModel rqModel) {

        if (!isValid(rqModel)) {
            throw new ExceptionForDivide(ResponseCode.BAD_REQUEST);
        }

        Float resultFloat = 0f;
        ResponseModel response = new ResponseModel(ResponseCode.SUCCESS);
        for (CalculateService c : calculateService) {
            if (c.findOperator(rqModel.getOperator())) {
                resultFloat = c.calculate(rqModel);
                response.setValidated(true);
                break;
            }
        }
        response.setResponse(resultFloat.toString());
        return response;
    }

    //Bana gelen mailde, sadece rakamlar girilebilecek yazıyordu. Bu yüzden bu kontrolü yapıyorum.
    private boolean isValid(RequestModel rqModel) {
        if (!Optional.ofNullable(rqModel)
                .map(second -> rqModel.getSecondNumber())
                .filter(p -> p <= 9)
                .filter(p -> p >= 0)
                .map(first -> rqModel.getFirstNumber())
                .filter(p -> p <= 9)
                .filter(p -> p >= 0)
                .map(operator -> rqModel.getOperator())
                .isPresent()) {
            return false;
        }
        return true;
    }
}
