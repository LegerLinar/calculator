package com.besedin.skypro.calculator.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if(b == 0){
            throw new IllegalArgumentException("Делить на ноль нельзя");
        }
        return a / b;
    }
}
