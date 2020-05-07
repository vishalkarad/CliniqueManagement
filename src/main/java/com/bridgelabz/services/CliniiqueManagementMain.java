package com.bridgelabz.services;

import com.bridgelabz.interfaces.CliniqueInterface;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CliniiqueManagementMain implements CliniqueInterface {

    // Variables
    String filePath;
    File file;

    // Constructor
    public CliniiqueManagementMain(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    // Add record
    @Override
    public <T> String addRecord(T object) {
        try {
            List<T> list = new ArrayList<>();
            if (file.length() > 0)
                list = readFile();
            list.add(object);
            saveRecord();
            return "Add Records Successfully";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
