package kz.galina.springMVC.service.impl;

import kz.galina.springMVC.service.CalculatorService;
import org.springframework.stereotype.Service;


@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public double calculate(long number1, long number2, String action) {
        double result = 0;
        switch (action){
            case "multiply": result=number1*number2;
                break;
            case "add": result=number1+number2;
                break;
            case "subtract":result=number1-number2;
                break;
            case "divide":result=number1/number2;
                break;
        }
        return result;
    }
}
