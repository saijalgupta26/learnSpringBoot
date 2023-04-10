package com.example.mevenproject.exception;

public class TeacherAlreadyExist extends Exception {
    private static final long serialVersionUID = 1L;
    public TeacherAlreadyExist(String error)
    {
        super(error);
    }
}
