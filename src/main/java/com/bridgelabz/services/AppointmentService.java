package com.bridgelabz.services;

import com.bridgelabz.exception.CliniqueException;
import com.bridgelabz.pojo.AppointMent;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AppointmentService {
    // Variable
    public static final String filePath = "F:\\bridgelabze\\CliniqueManagement\\src\\test\\resources\\appointment\\appointmentList.json";
    int count = 0;

    // Objects
    List<AppointMent> list = new ArrayList();
    ObjectMapper mapper = new ObjectMapper();
    File file;

    // Appointment
    public String appointment(String doctor_id, String date) throws IOException, CliniqueException, ParseException {
        compareDate(date); // Date in past then throw exception
        list = readFile(filePath);
        count = (int) list.stream().filter(value -> value.getDoctor_id().compareTo(doctor_id) == 0).count();
        if (count == 0)
            throw new CliniqueException(CliniqueException.MyException.INVALIED_ID, "This doctor are not present in clinique");
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getAppointment_Date().compareTo(date) == 0) {
                if (list.get(index).getAppointment_Date().compareTo(date) == 0 && list.get(index).getDoctor_id().compareTo(doctor_id) == 0
                        && list.get(index).getAppointMent_Id() < 5) {
                    list.get(index).setAppointMent_Id(list.get(index).getAppointMent_Id() + 1);
                    saveRecord(list);
                    return "Appointment fix";
                }
            } else
                count++;
            if (list.size() == count - 1) {
                list.add(new AppointMent(0, doctor_id, date));
                saveRecord(list);
            }
        }
        return "Appointment are not avalebale";
    }

    // Read Address book
    public List<AppointMent> readFile(String file_path) {
        try {
            this.file = new File(file_path);
            if (file.length() == 0)
                throw new CliniqueException(CliniqueException.MyException.FILE_EMPTY, "File is Empty");
            return mapper.readValue(file, new TypeReference<ArrayList<AppointMent>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Save Records In File
    public void saveRecord(List<AppointMent> list) throws IOException {
        mapper.writeValue(file, list);
    }

    // Date must be in future
    public void compareDate(String date) throws ParseException, CliniqueException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date appointmentDate = format.parse(date);
        if (cal.getTime().before(appointmentDate))
            throw new CliniqueException(CliniqueException.MyException.INVALIED_APPOINTMENT_DATE, "This doctor are not present in clinique");
    }
}
