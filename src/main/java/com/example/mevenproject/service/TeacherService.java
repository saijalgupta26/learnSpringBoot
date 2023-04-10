package com.example.mevenproject.service;


import com.example.mevenproject.document.Teacher;
import com.example.mevenproject.exception.TeacherAlreadyExist;
import com.example.mevenproject.exception.TeacherNotFoundException;
import com.example.mevenproject.request.AdditionRequest;

import java.util.List;

public interface TeacherService {
    public Teacher createTeacher(Teacher teacher) throws TeacherAlreadyExist;
    public List<Teacher> getAll();
    public Teacher getTeacherByName(String name) throws TeacherNotFoundException;
    public Teacher updateTeacher(String name,Teacher teacher) throws TeacherNotFoundException;
    public String delete(String name) throws TeacherNotFoundException;
    public  double addition(AdditionRequest additionRequest);

}

