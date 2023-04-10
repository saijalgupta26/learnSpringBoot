package com.example.mevenproject.exception;

public class TeacherNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
     public TeacherNotFoundException(String error)
     {
         super(error);
     }

}
