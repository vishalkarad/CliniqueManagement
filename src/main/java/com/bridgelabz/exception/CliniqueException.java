package com.bridgelabz.exception;

public class CliniqueException extends Exception {

    public enum MyException {
        INVALID_MOBILE_NUMBER, FILE_EMPTY, INVALID_ID, INVALID_APPOINTMENT_DATE
    }

    MyException type;

    public CliniqueException(MyException type, String message) {
        super(message);
        this.type = type;
    }
}
