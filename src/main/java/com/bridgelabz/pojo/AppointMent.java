package com.bridgelabz.pojo;

public class AppointMent {

    private int appointMent_Id;
    private String doctor_id;
    private String appointment_Date;

    public AppointMent(int appointMent_Id, String doctor_id, String appointment_Date) {
        this.appointMent_Id = appointMent_Id;
        this.doctor_id = doctor_id;
        this.appointment_Date = appointment_Date;
    }

    public AppointMent() {
    }

    // Getter methods
    public int getAppointMent_Id() {
        return appointMent_Id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public String getAppointment_Date() {
        return appointment_Date;
    }

    public void setAppointMent_Id(int appointMent_Id) {
        this.appointMent_Id = appointMent_Id;
    }
}
