package com.bridgelabz.services;

import com.bridgelabz.exception.CliniqueException;
import com.bridgelabz.pojo.Appointment;
import com.bridgelabz.pojo.Doctor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class DoctorService extends CliniqueManagementMain {

    public String appointmentFilePath = "F:\\bridgelabze\\cliniqueManagementApplication\\src\\test\\resources\\appointment\\appointmentList.json";

    // constructor
    public DoctorService(String filePath) {
        super(filePath);

    }

    // Add doctor record
    public String addDoctorEntry(Doctor doctor) {
        return super.addRecord(doctor, Doctor.class);
    }

    // search doctor record
    public int searchDoctorEntry(String serchValue) {
        return super.searchRecord(serchValue, Doctor.class);
    }

    // list of all doctor records
    public String listOfAllDoctorRecords() {
        return super.listOfAllRecords(Doctor.class);
    }

    // Doctor patient report
    public int doctorPatientReport(String doctorId) throws IOException, ClassNotFoundException {
        AtomicInteger noOfRecord = new AtomicInteger();
        List<Appointment> list = new ArrayList<>();
        list = super.readFile(Appointment.class);
        list.stream().forEach(value -> {
            if (value.getDoctor_Id().compareTo(doctorId) == 0) {
                searchDoctorEntry(value.getPatient_Id());
                noOfRecord.getAndIncrement();
            }
        });
        return noOfRecord.get();
    }

    // Popular doctor
    public String popularDoctor() throws IOException, ClassNotFoundException {
        List<Doctor> list = readFile(Doctor.class);
        DoctorService doctor = new DoctorService(appointmentFilePath);
        Map<String, Integer> map = new HashMap<>();
        list.stream().forEach(value -> {
            map.put(value.getDoctor_Id(), searchRecord(value.getDoctor_Id(), Appointment.class));
        });
        return map.keySet().stream().filter(key -> Collections.max(map.values()).equals(map.get(key)))
                .findFirst().get();
    }
}
