package com.example.mevenproject.service;

import com.example.mevenproject.document.Student;
import com.example.mevenproject.exception.StudentNotFound;
import com.example.mevenproject.repository.StudentRepository;
import com.example.mevenproject.request.StudentRequest;
import com.example.mevenproject.response.StudentResponse;
import com.example.mevenproject.utill.Trasnformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private Trasnformer trasnformer;

    public StudentResponse createStudent(StudentRequest studentRequest) {
        if (ObjectUtils.isEmpty(studentRequest) ) {
            return null;
        }
        Student student = trasnformer.transformStudent(studentRequest);
        Student student1 = studentRepository.save(student);
        Optional<Student> login = studentRepository.findByEmailAndPassword(studentRequest.getEmail(), studentRequest.getName());
        System.out.println(login.isPresent());
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
        if(ObjectUtils.isEmpty(studenyByRollno))
        {
            throw  new StudentNotFound("student not found exception");
        }
        studenyByRollno.setName(student.getName());
        studenyByRollno.setSection(student.getSection());
        studenyByRollno.setEmail(student.getEmail());
        return studentRepository.save(studenyByRollno);
    }

    @Override
    public String deleteStudent(int rollno) throws StudentNotFound {
        Student studenyByRollno = findStudenyByRollno(rollno);
        if(ObjectUtils.isEmpty(studenyByRollno))
        {
            throw  new StudentNotFound("student not found");
        }
        studentRepository.delete(studenyByRollno);
        return "student delete successfully";
    }

    @Override
    public Student findStudentByEmailAndPassword(String email, String password) throws StudentNotFound {
        Optional<Student> student = studentRepository.findByEmailAndPassword(email, password);
        if(ObjectUtils.isEmpty(student))
        {
            throw new StudentNotFound("student not found");
        }
        return student.get();

    }
}

