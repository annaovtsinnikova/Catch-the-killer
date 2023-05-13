package com.example.fxproject.CatchTheKiller;

public class WrongKeyException extends RuntimeException{
    public WrongKeyException(String message) {
        super(message);
    }
    @Override
    public String toString() {
        return getMessage();
    }
}
