package com.bridgelabz.pojo;

import com.bridgelabz.exception.CliniqueException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Doctor {
    String doctor_Id;
    String doctor_Name;
    String doctor_MobileNumber;
    String doctor_Address;
    String doctor_Availability;
    String doctor_Specialist;

    public Doctor(){

    }
    // check valid mobile number or not
    public boolean isValid(String mobileNumber) {
        Pattern pattern = Pattern.compile("[7-9][0-9]{9}");
        Matcher matcher = pattern.matcher(mobileNumber);
        return (matcher.find() && matcher.group().equals(mobileNumber));
    }
    // constructor to assign doctor properties

    public Doctor(String doctor_Id, String doctor_Name, String doctor_MobileNumber, String doctor_Address,
                  String doctor_Availability, String doctor_Specialist) throws CliniqueException {
        this.doctor_Id = doctor_Id;
        this.doctor_Name = doctor_Name;
        this.doctor_Address = doctor_Address;
        this.doctor_Availability = doctor_Availability;
        this.doctor_Specialist = doctor_Specialist;
        if (isValid(doctor_MobileNumber))
            this.doctor_MobileNumber = doctor_MobileNumber;
        else
            throw new CliniqueException(CliniqueException.MyException.INVALIED_MOBILE_NUMBER, "Enter valied mobile Number");
    }

    // Getter method

    public String getDoctor_Id() {
        return doctor_Id;
    }

    public String getDoctor_Name() {
        return doctor_Name;
    }

    public String getDoctor_MobileNumber() {
        return doctor_MobileNumber;
    }

    public String getDoctor_Address() {
        return doctor_Address;
    }

    public String getDoctor_Availability() {
        return doctor_Availability;
    }

    public String getDoctor_Specialist() {
        return doctor_Specialist;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_Id='" + doctor_Id + '\'' +
                ", doctor_Name='" + doctor_Name + '\'' +
                ", doctor_MobileNumber='" + doctor_MobileNumber + '\'' +
                ", doctor_Address='" + doctor_Address + '\'' +
                ", doctor_Availability='" + doctor_Availability + '\'' +
                ", doctor_Specialist='" + doctor_Specialist + '\'' +
                '}';
    }
}
