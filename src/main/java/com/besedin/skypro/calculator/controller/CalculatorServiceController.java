package com.besedin.skypro.calculator.controller;

import com.besedin.skypro.calculator.exceptions.DontDivideOnOException;
import com.besedin.skypro.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorServiceController {

    private final CalculatorService calculatorService;

    public CalculatorServiceController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greeting() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam double a, @RequestParam double b) {
        String aString = String.valueOf(a);
        String bString = String.valueOf(b);
        return aString + " + " + bString + " = " + calculatorService.plus(a, b);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam double a, @RequestParam double b) {
        String aString = String.valueOf(a);
        String bString = String.valueOf(b);
        return aString + " - " + bString + " = " + calculatorService.minus(a, b);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam double a, @RequestParam double b) {
        String aString = String.valueOf(a);
        String bString = String.valueOf(b);
        return aString + " * " + bString + " = " + calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam double a, @RequestParam double b) {
        String aString = String.valueOf(a);
        String bString = String.valueOf(b);
        try{
            calculatorService.divide(a,b);
        } catch (DontDivideOnOException e ){
            return e.getMessage();
        }
        return aString + " / " + bString + " = " + calculatorService.divide(a, b);
    }

}
