package com.bridgelabz.services;

import com.bridgelabz.pojo.Doctor;

public class DoctorService extends CliniqueManagementMain {

    public DoctorService(String filePath) {
        super(filePath);
    }

    public String addRecord(Doctor doctor){
        return super.addRecord(doctor);
    }

    // Add search record
    public String searchRecord(String serchValue) {
        return super.searchRecord(serchValue);
    }

    public String listOfAllRecords(){
        return super.listOfAllRecords();
    }
}
