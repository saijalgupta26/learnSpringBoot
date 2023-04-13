package com.example.mevenproject.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
    @Id
    private String id;
    private  String name;

    @Indexed(unique = true)
    private int rollno;
    private String section;
    private  String branch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getBranch() {
        return branch;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollno=" + rollno +
                ", section='" + section + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }


}
