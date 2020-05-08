package com.bridgelabz.pojo;

public class AppointMent {

    private int appointMent_Number;
    private String doctor_Id;
    private String appointment_Date;
    private String patient_Id;

    public AppointMent(int appointMent_Number, String doctor_Id, String appointment_Date, String patient_Id) {
        this.appointMent_Number = appointMent_Number;
        this.doctor_Id = doctor_Id;
        this.appointment_Date = appointment_Date;
        this.patient_Id = patient_Id;
    }

    public AppointMent() {
    }

    // Getter methods


    public int getAppointMent_Number() {
        return appointMent_Number;
    }

    public String getDoctor_Id() {
        return doctor_Id;
    }

    public String getAppointment_Date() {
        return appointment_Date;
    }

    public String getPatient_Id() {
        return patient_Id;
    }

    public void setAppointMent_Number(int appointMent_Number) {
        this.appointMent_Number = appointMent_Number;
    }
}
