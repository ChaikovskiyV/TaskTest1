package com.VChaikovsky.task1.exception;

public class WrongDataException extends Exception{

    public WrongDataException(){
        super();
    }

    public WrongDataException(Exception e){
        super(e);
    }

    public WrongDataException(String message){
        super(message);
    }

    public WrongDataException(String message, Exception e){
        super(message, e);
    }
}