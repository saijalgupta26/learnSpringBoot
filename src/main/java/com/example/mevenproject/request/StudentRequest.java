package com.example.mevenproject.request;

import lombok.Data;

@Data
public class StudentRequest {
    private String id;
    private  String name;


    private int rollno;
    private String section;
    private  String branch;
    //@data--tostring and getter and setter
}
