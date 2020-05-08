package com.bridgelabz.interfaces;

public interface CliniqueInterface {

    public <T> String addRecord(T object);
    public int searchRecord(String serachValue);
    public String listOfAllRecords();
}
