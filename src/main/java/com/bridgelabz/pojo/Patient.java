package com.bridgelabz.pojo;

import com.bridgelabz.exception.CliniqueException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patient {
    String patientId;
    String patientName;
    String patientMobileNumber;
    int patientAge;

    // Default constructor
    public Patient() {

    }

    // Check valid mobile number or not
    public boolean isValid(String mobileNumber) {
        Pattern pattern = Pattern.compile("[7-9][0-9]{9}");
        Matcher matcher = pattern.matcher(mobileNumber);
        return (matcher.find() && matcher.group().equals(mobileNumber));
    }

    // Constructor to assign patient properties
    public Patient(String patientId, String patientName, String patientMobileNumber, int patientAge) throws CliniqueException {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientMobileNumber = patientMobileNumber;
        this.patientAge = patientAge;
        if (isValid(patientMobileNumber))
            this.patientMobileNumber = patientMobileNumber;
        else
            throw new CliniqueException(CliniqueException.MyException.INVALID_MOBILE_NUMBER, "Enter valid mobile Number");
    }

    // Getter methods


    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientMobileNumber() {
        return patientMobileNumber;
    }

    public int getPatientAge() {
        return patientAge;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientMobileNumber='" + patientMobileNumber + '\'' +
                ", patientAge=" + patientAge +
                '}';
    }
}
