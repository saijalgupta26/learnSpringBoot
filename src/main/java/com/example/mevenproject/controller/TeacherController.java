package com.example.mevenproject.controller;


import com.example.mevenproject.document.Teacher;
import com.example.mevenproject.exception.ErrorModel;
import com.example.mevenproject.exception.TeacherAlreadyExist;
import com.example.mevenproject.exception.TeacherNotFoundException;
import com.example.mevenproject.request.AdditionRequest;
import com.example.mevenproject.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.Collections;
import java.util.List;
import java.util.Map;

//@RequestMapping("/teacher")
@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @PostMapping("/createTeacher")
    public ResponseEntity<?> createTeacher( @Valid @RequestBody Teacher teacher) throws TeacherAlreadyExist {
        try{
            Teacher teacher1 = teacherService.createTeacher(teacher);
            return new ResponseEntity<>(teacher1, HttpStatus.CREATED);

        }

        catch (TeacherAlreadyExist e)
        {
            return   new ResponseEntity<>("Teacher Already Exist",HttpStatus.BAD_REQUEST);
        }

    }
    @RestControllerAdvice
    public static class RestExceptionHandler extends ResponseEntityExceptionHandler {
        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(
                MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
            ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST, "Validation Error", ex.getBindingResult().toString());

            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping (value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam(value="name",defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "registration";

    }
    @RequestMapping(value = "/RegisterMe", method = RequestMethod.POST)
    public String registerMe(Teacher teacher)
    {
        System.out.println(teacher.getName());
        return "hello";
    }
    @ResponseBody
    @RequestMapping(value = "/hell", method = RequestMethod.GET)
    public String helloqq(@RequestParam(value="name",defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        //return new ModelAndView("hello");
        return "hello";
    }
    @ResponseBody
    @RequestMapping(value = "/hel", method = RequestMethod.GET)
    public String hellow()
    {
        return "hello";
    }
   // Optional is a container object used to contain not-null objects
//    @RequestMapping (value="/hello",method = RequestMethod.GET)
//    public String hello()
//    {
////        return "{\"message\": \"Hello, world!\"}";
//        return "hello";
//    }
    //json-used for communication bw frobted and backrend key value pair javascript object notation text formatter

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll()
    {
        List<Teacher> teacherList=teacherService.getAll();
        return new ResponseEntity<>(teacherList,HttpStatus.OK);
    }
    @GetMapping("/getByName/{name}")
    public ResponseEntity<?>  getTeacherByName(@PathVariable String name) throws TeacherNotFoundException {
        try {
            Teacher teacher = teacherService.getTeacherByName(name);
            return new ResponseEntity<>(teacher, HttpStatus.FOUND);
        }
        catch (TeacherNotFoundException e)
        {
            return  new ResponseEntity<>("teacher not found",HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/updateTeacher/{name}")
    public ResponseEntity<?> update(@PathVariable String name,@RequestBody Teacher teacher) throws TeacherNotFoundException {
        try{
            Teacher teacher1 = teacherService.updateTeacher(name, teacher);
            return new ResponseEntity<>(teacher1,HttpStatus.OK);

        }
        catch(TeacherNotFoundException e)
        {
            return  new ResponseEntity<>("teacher not found",HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> delete(@PathVariable String name) throws TeacherNotFoundException {
        try{
            String status = teacherService.delete(name);
            return new ResponseEntity<>(status,HttpStatus.OK);

        }
        catch (TeacherNotFoundException e)
        {
            return new ResponseEntity<>("Teacher not found",HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/addition")
    public ResponseEntity<?> addition(@RequestBody AdditionRequest additionRequest)
    {
        double addition = teacherService.addition(additionRequest);
        return new ResponseEntity<>(addition,HttpStatus.OK);
    }
}
