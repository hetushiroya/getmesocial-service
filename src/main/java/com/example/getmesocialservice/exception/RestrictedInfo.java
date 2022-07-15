package com.example.getmesocialservice.exception;

public class RestrictedInfo extends Exception {

    @Override
    public String getMessage() {
        return "Classified Information";
    }
}
