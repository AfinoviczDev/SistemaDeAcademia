package dev.afinovicz.springbootessentialsJPA.exception;

public class NotFoundException extends Exception{

    public NotFoundException(String message) {
        super(message);
    }
}
