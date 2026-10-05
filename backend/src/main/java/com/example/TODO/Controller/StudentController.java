package com.example.TODO.Controller;

import com.example.TODO.DTO.StudentsREQ;
import com.example.TODO.Entity.StudentEntity;
import com.example.TODO.Service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/V1/Students")
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping()
    public List<StudentEntity> getAllStudents() {
        log.info("Receive Request for return all Students on Controller ");
        List<StudentEntity> students = studentService.getAllStudent();
        log.info("Return all Students on Controller ");
        log.info(students.toString());
        return students;

    }


    @PostMapping()
    public HttpStatus createStudent(@RequestBody StudentsREQ student) {
        log.info("Receive Request for create Student on Controller " + student.toString());
        HttpStatus student1 = studentService.createStudent(student);
        log.info("Create Student on Controller " + student1.toString());
        return student1;
    }


    @DeleteMapping("/{Id}")
    public HttpStatus deleteStudent(@PathVariable Long Id) {
        log.info("Receive Request for delete Student on Controller " + Id);
        HttpStatus student1 = studentService.deleteStudent(Id);
        log.info("Delete Student on Controller " + student1.toString());
        return student1;

    }


}
