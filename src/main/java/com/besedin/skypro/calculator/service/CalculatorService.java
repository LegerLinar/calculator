package com.besedin.skypro.calculator.service;

import com.besedin.skypro.calculator.exceptions.DontDivideOnOException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double plus(double a, double b) {
        return a + b;
    }

    public double minus(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if(b == 0){
            throw new DontDivideOnOException("Делить на ноль нельзя");
        }
        return a / b;
    }
}
