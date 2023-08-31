package com.besedin.skypro.calculator.service;

import com.besedin.skypro.calculator.exceptions.DontDivideOnOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.besedin.skypro.calculator.constants.CalculatorServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceParametrizedTest {

    private final CalculatorService out = new CalculatorService();
    @ParameterizedTest
    @MethodSource("providedParamsForTests")
    public void shouldMakeRightCalculations(double a, double b){
        assertEquals(a + b,out.plus(a,b));
        assertEquals(a - b,out.minus(a,b));
        assertEquals(a * b, out.multiply(a, b));
        assertEquals(a / b, out.divide(a, b));
    }


    public static Stream<Arguments> providedParamsForTests(){
        return Stream.of(
                Arguments.of(ONE, FIVE),
                Arguments.of(NEGATIVE_FIVE, NEGATIVE_FIVE),
                Arguments.of(DOUBLE_NUMBER, NEGATIVE_FIVE)
        );
    }
}
