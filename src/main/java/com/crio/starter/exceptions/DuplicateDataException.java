package com.crio.starter.exceptions;

public class DuplicateDataException extends Exception {

    @Override 
    public String toString(){
        return "Duplicate data already exists";
    }
}
