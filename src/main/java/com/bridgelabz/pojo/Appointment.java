package com.bridgelabz.pojo;

public class Appointment {

    private int appointment_Number;
    private String doctor_Id;
    private String appointment_Date;
    private String patient_Id;

    public Appointment(int appointment_Number, String doctor_Id, String appointment_Date, String patient_Id) {
        this.appointment_Number = appointment_Number;
        this.doctor_Id = doctor_Id;
        this.appointment_Date = appointment_Date;
        this.patient_Id = patient_Id;
    }

    public Appointment() {
    }

    // Getter methods
    public int getAppointment_Number() {
        return appointment_Number;
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

    @Override
    public String toString() {
        return "Appointment{" +
                "appointment_Number=" + appointment_Number +
                ", doctor_Id='" + doctor_Id + '\'' +
                ", appointment_Date='" + appointment_Date + '\'' +
                ", patient_Id='" + patient_Id + '\'' +
                '}';
    }
}
