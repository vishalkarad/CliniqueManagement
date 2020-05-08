package com.bridgelabz.pojo;

public class Patients {
    String patients_Id;
    String patients_Name;
    String patients_MobileNumber;
    int patient_Age;

    public Patients(){

    }
    public Patients(String patients_Id, String patients_Name, String patients_MobileNumber, int patient_Age) {
        this.patients_Id = patients_Id;
        this.patients_Name = patients_Name;
        this.patients_MobileNumber = patients_MobileNumber;
        this.patient_Age = patient_Age;
    }

    // Getter methods
    public String getPatients_Id() {
        return patients_Id;
    }

    public String getPatients_Name() {
        return patients_Name;
    }

    public String getPatients_MobileNumber() {
        return patients_MobileNumber;
    }

    public int getPatient_Age() {
        return patient_Age;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patients_Id='" + patients_Id + '\'' +
                ", patients_Name='" + patients_Name + '\'' +
                ", patients_MobileNumber='" + patients_MobileNumber + '\'' +
                ", patient_Age=" + patient_Age +
                '}';
    }
}
