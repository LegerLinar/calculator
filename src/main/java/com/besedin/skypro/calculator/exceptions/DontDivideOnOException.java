package com.besedin.skypro.calculator.exceptions;

public class DontDivideOnOException extends IllegalArgumentException{
    public DontDivideOnOException(String message){
        super(message);
    }
}
