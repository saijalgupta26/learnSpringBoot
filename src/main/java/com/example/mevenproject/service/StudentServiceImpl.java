package com.example.mevenproject.service;


import com.example.mevenproject.document.Student;
import com.example.mevenproject.exception.StudentNotFound;
import com.example.mevenproject.repository.StudentRepository;
import com.example.mevenproject.request.StudentRequest;
import com.example.mevenproject.response.StudentResponse;
import com.example.mevenproject.utill.Trasnformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

  @Autowired
  private StudentRepository studentRepository;
  @Autowired
  private Trasnformer trasnformer;
   /* @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        if(studentRequest==null)
        {
            return null;
        }
        Student student = trasnformer.transformStudent(studentRequest);

        Student student1 = studentRepository.save(student);

        return trasnformer.prepareStudentResponse(student1);



    }*/

    public StudentResponse createStudent(StudentRequest studentRequest) {
        if(studentRequest==null)
        {
            return null;
        }

        Student student = trasnformer.transformStudent(studentRequest);

        Student student1 = studentRepository.save(student);

        return trasnformer.prepareStudentResponse(student1);




    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudenyByRollno(int rollno) throws StudentNotFound {
        Optional<Student> student = studentRepository.findByRollno(rollno);
        // throw new StudentNotFound("student not found");
        return student.orElse(null);



    }

    @Override
    public Student updateStudent(int rollno, Student student) throws StudentNotFound {
        Student studenyByRollno = findStudenyByRollno(rollno);
        studenyByRollno.setBranch(student.getBranch());
        studenyByRollno.setName(student.getName());
        studenyByRollno.setSection(student.getSection());
        return studentRepository.save(studenyByRollno);

    }

    @Override
    public String deleteStudent(int rollno) throws StudentNotFound {
        Student studenyByRollno = findStudenyByRollno(rollno);

        studentRepository.delete(studenyByRollno);
        return "student delete successfully";

    }
}
