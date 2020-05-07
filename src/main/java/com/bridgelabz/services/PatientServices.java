package com.bridgelabz.services;

import com.bridgelabz.pojo.Patients;

public class PatientServices extends CliniqueManagementMain {

    // Constructor
    public PatientServices(String filePath) {
        super(filePath);
    }

    // Add patient
    public String  addPatient(Patients patients){
        return super.addRecord(patients);
    }

    // Add search record
    public String searchRecord(String serchValue) {
        return super.searchRecord(serchValue);
    }

    public String listOfAllRecords(){
        return super.listOfAllRecords();
    }
}
