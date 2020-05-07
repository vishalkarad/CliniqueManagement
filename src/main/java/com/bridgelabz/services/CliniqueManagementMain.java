package com.bridgelabz.services;

import com.bridgelabz.exception.CliniqueException;
import com.bridgelabz.interfaces.CliniqueInterface;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            saveRecord(list);
            return "Add Records Successfully";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    // Search Record
    public String searchRecord(String id) {
        try {
            String length = readFile().stream().filter(value -> value.toString().contains(id)).collect(Collectors.toList()).toString();
            if (length!=null) {
                System.out.println(length);
                return "Search record";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Record are not found";
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

    // Save Records In File
    public <T> void saveRecord(List<T> list) throws IOException {
        mapper.writeValue(file, list);
    }
}
