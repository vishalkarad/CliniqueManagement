package com.bridgelabz.services;

import com.bridgelabz.pojo.AppointMent;
import com.bridgelabz.pojo.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DoctorService extends CliniqueManagementMain {


    // constructor
    public DoctorService(String filePath) {
        super(filePath);
    }

    // Add doctor record
    public String addDoctorEntry(Doctor doctor) {
        return super.addRecord(doctor);
    }

    // search doctor record
    public int searchDoctorEntry(String serchValue) {
        return super.searchRecord(serchValue);
    }

    // list of all doctor records
    public String listOfAllDoctorRecords() {
        return super.listOfAllRecords();
    }

     // Doctor patient report
     public int doctorPatientReport(String doctorId) {
         AtomicInteger noOfRecord = new AtomicInteger();
         new AppointmentService().readFile().stream().forEach(value -> {
             if (value.getDoctor_Id().compareTo(doctorId)==0) {
                 searchDoctorEntry(value.getPatient_Id());
                 noOfRecord.getAndIncrement();
             }
         });
         return noOfRecord.get();
     }

}
