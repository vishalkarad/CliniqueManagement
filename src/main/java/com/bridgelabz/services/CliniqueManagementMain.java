package com.bridgelabz.services;

import com.bridgelabz.exception.CliniqueException;
import com.bridgelabz.interfaces.CliniqueInterface;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CliniqueManagementMain implements CliniqueInterface {

    // Variables
    String filePath;
    File file;
    ObjectMapper mapper = new ObjectMapper();

    // Constructor
    public CliniqueManagementMain(String filePath) {
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

    private <T> List<T> readFile() {
        try {
            if (file.length() == 0)
                throw new CliniqueException(CliniqueException.MyException.FILE_EMPTY, "File is Empty");
            return mapper.readValue(file, new TypeReference<ArrayList<T>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
