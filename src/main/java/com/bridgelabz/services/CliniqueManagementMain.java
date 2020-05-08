package com.bridgelabz.services;

import com.bridgelabz.exception.CliniqueException;
import com.bridgelabz.interfaces.CliniqueInterface;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

    // Search Record
    @Override
    public int searchRecord(String serchValue) {
        try {
            AtomicInteger count = new AtomicInteger();
            readFile().stream().forEach(value -> {
                if (value.toString().contains(serchValue)) {
                    System.out.println(value.toString());
                    count.getAndIncrement();
                }
            });
            return count.get();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Search whole list
    @Override
    public String listOfAllRecords() {
        try {
            readFile().stream().forEach(value -> System.out.println(value.toString()));
            return "Search record";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Read file
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
