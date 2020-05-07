package com.bridgelabz.services;

import com.bridgelabz.pojo.Doctor;

public class DoctorService extends CliniiqueManagementMain{

    public DoctorService(String filePath) {
        super(filePath);
    }

    public String addRecord(Doctor doctor){
        return super.addRecord(doctor);
    }
}
