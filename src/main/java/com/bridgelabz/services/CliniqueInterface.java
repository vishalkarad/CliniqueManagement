package com.bridgelabz.services;

import java.io.IOException;
import java.util.List;

public interface CliniqueInterface {

    public <T> String addRecord(T object, Class<?> className);

    public <T> int searchRecord(String searchValue, Class<?> className);

    public String listOfAllRecords(Class<?> className);

    public <T> List<T> readFile(Class<?> target) throws IOException, ClassNotFoundException;

    public <T> void saveRecord(List<T> list) throws IOException;
}
