package com.bridgelabz.services;

import com.bridgelabz.pojo.Doctor;

public class DoctorService extends CliniqueManagementMain {

    // constructor
    public DoctorService(String filePath) {
        super(filePath);
    }

    // Add doctor record
    public String addDoctorEntry(Doctor doctor){
        return super.addRecord(doctor);
    }

    // search doctor record
    public int searchDoctorEntry(String serchValue) {
        return super.searchRecord(serchValue);
    }

    // list of all doctor records
    public String listOfAllDoctorRecords(){
        return super.listOfAllRecords();
    }
}
