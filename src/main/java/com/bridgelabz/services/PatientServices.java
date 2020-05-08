package com.bridgelabz.services;

import com.bridgelabz.pojo.Patients;

public class PatientServices extends CliniqueManagementMain {

    // Constructor
    public PatientServices(String filePath) {
        super(filePath);
    }

    // Add patient
    public String  addPatientEntry(Patients patients){
        return super.addRecord(patients);
    }

    // search patient
    public int searchPatientRecord(String serchValue) {
        return super.searchRecord(serchValue);
    }

    // list of all patientList
    public String listOfAllPatientRecords(){
        return super.listOfAllRecords();
    }
}
