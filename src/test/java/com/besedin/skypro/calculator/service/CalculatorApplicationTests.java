package com.besedin.skypro.calculator.service;

import com.besedin.skypro.calculator.exceptions.DontDivideOnOException;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeWithZoneIdSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.besedin.skypro.calculator.constants.CalculatorServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService out = new CalculatorService();

    @Test
    public void shouldReturnSummery() {
        assertEquals(ONE + FIVE, out.plus(ONE, FIVE));
        assertEquals(NEGATIVE_FIVE + FIVE, out.plus(NEGATIVE_FIVE, FIVE));
        assertEquals(DOUBLE_NUMBER + FIVE, out.plus(DOUBLE_NUMBER, FIVE));
    }

    @Test
    public void shouldReturnDifference() {
        assertEquals(ONE - FIVE, out.minus(ONE, FIVE));
        assertEquals(NEGATIVE_FIVE - FIVE, out.minus(NEGATIVE_FIVE, FIVE));
        assertEquals(DOUBLE_NUMBER - FIVE, out.minus(DOUBLE_NUMBER, FIVE));
    }

    @Test
    public void shouldReturnMultiplicationResult() {
        assertEquals(ONE * FIVE, out.multiply(ONE, FIVE));
        assertEquals(NEGATIVE_FIVE * NEGATIVE_FIVE, out.multiply(NEGATIVE_FIVE, NEGATIVE_FIVE));
        assertEquals(DOUBLE_NUMBER * FIVE, out.multiply(DOUBLE_NUMBER, FIVE));
    }

    @Test
    public void shouldReturnDivisionResult(){
        assertEquals(ONE / FIVE, out.divide(ONE, FIVE));
        assertEquals(NEGATIVE_FIVE / NEGATIVE_FIVE, out.divide(NEGATIVE_FIVE, NEGATIVE_FIVE));
        assertEquals(DOUBLE_NUMBER / FIVE, out.divide(DOUBLE_NUMBER, FIVE));
    }
    @Test
    public void shouldThrowOwnException(){
        assertThrows(DontDivideOnOException.class,
                () -> out.divide(ONE, ZERO));
    }

}
