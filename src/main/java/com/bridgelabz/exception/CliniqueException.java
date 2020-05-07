package com.bridgelabz.exception;

public class CliniqueException extends Exception{

    public enum MyException{
        INVALIED_MOBILE_NUMBER,FILE_EMPTY,INVALIED_ID,INVALIED_APPOINTMENT_DATE
    }
    MyException type;

    public CliniqueException(MyException type, String message) {
        super(message);
        this.type = type;
    }
}
