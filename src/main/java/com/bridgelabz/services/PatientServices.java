package com.bridgelabz.services;

import com.bridgelabz.model.Patient;

public class PatientServices extends CliniqueManagementMain {

    // Constructor
    public PatientServices(String filePath) {
        super(filePath);
    }

    // Add patient
    public String addPatientEntry(Patient patients) {
        return super.addRecord(patients, Patient.class);
    }

    // search patient
    public int searchPatientRecord(String searchValue) {
        return super.searchRecord(searchValue, Patient.class);
    }

    // list of all patientList
    public String listOfAllPatientRecords() {
        return super.listOfAllRecords(Patient.class);
    }
}
