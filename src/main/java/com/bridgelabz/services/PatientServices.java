package com.bridgelabz.services;

import com.bridgelabz.pojo.Patients;

public class PatientServices extends CliniiqueManagementMain {

    // Constructor
    public PatientServices(String filePath) {
        super(filePath);
    }

    // Add patient
    public void addPatient(Patients patients){
        super.addRecord(patients);
    }

}
