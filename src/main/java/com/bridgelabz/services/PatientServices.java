package com.bridgelabz.services;

import com.bridgelabz.pojo.Patients;

public class PatientServices extends CliniqueManagementMain {

    // Constructor
    public PatientServices(String filePath) {
        super(filePath);
    }

    // Add patient
    public void addPatient(Patients patients){
        super.addRecord(patients);
    }

    // Add search record
    public String searchRecord(String serchValue) {
        return super.searchRecord(serchValue);
    }
}
