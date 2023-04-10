package com.example.mevenproject.service;


import com.example.mevenproject.document.Teacher;
import com.example.mevenproject.exception.TeacherAlreadyExist;
import com.example.mevenproject.exception.TeacherNotFoundException;
import com.example.mevenproject.repository.TeacherRepository;
import com.example.mevenproject.request.AdditionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public Teacher createTeacher(Teacher teacher) throws TeacherAlreadyExist {
        try {
            Teacher teacher1 = teacherRepository.save(teacher);

            return teacher1;
        }catch (Exception e){
            throw new TeacherAlreadyExist("Teacher Already exist");
        }
    }

    @Override
    public List<Teacher> getAll() {
        List<Teacher> teacherList = teacherRepository.findAll();
        return teacherList;
    }
    //api-application programing interface

    @Override
    public Teacher getTeacherByName(String name) throws TeacherNotFoundException {
        Teacher teacher1 = null;
        Optional<Teacher> teacher=teacherRepository.findTeacherByName(name);
            try{
                if(teacher.isEmpty()) {
                    throw new TeacherNotFoundException("Teacher Not Found");
                }
                teacher1 = teacher.get();
                return  teacher1;

            }
            catch(TeacherNotFoundException e)
            {
                e.printStackTrace();
            }
            return teacher1;
        }








    @Override
    public Teacher updateTeacher(String name, Teacher teacher) throws TeacherNotFoundException {

        Optional<Teacher> teacherByName = teacherRepository.findTeacherByName(name);
        if(teacherByName.isEmpty())
        {
            throw  new TeacherNotFoundException("teacher not found");
        }
        Teacher teacher1 = teacherByName.get();

        teacher1.setEmail(teacher.getEmail());
        teacher1.setAddress(teacher.getAddress());

        return teacherRepository.save(teacher1);


    }

    @Override
    public String delete(String name) throws TeacherNotFoundException {

        Teacher teacherByName = getTeacherByName(name);


        teacherRepository.delete(teacherByName);
        return "delete data ";
    }

    @Override
    public double addition(AdditionRequest additionRequest) {

        return additionRequest.getFirstElement()+additionRequest.getSecondElement();//api-used for communiaction bw two software and system
    }
    //restAPI-represention state transfer
}
