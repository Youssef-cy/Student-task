package com.example.TODO.Service.Impl;

import com.example.TODO.DTO.StudentsREQ;
import com.example.TODO.Entity.StudentEntity;
import com.example.TODO.Repo.StudentRepo;
import com.example.TODO.Service.StudentIMPL;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentService implements StudentIMPL {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<StudentEntity> getAllStudent() {
        log.debug("Receive Request for getAllStudent on Service ");
        List<StudentEntity> students = studentRepo.findAll();
        if (students.isEmpty()) {
            log.warn("Students not found");
            return new ArrayList<>();

        }
        log.info("all Students is returned on service ");
        return students;

    }

    @Override
    public HttpStatus createStudent(StudentsREQ student) {
        log.info("Receive Request for create Student on Service " + student.toString());
        if (studentRepo.findByEmail(student.getEmail()) != null) {
            log.warn("Student already exists");
            return HttpStatus.CONFLICT;

        }

        StudentEntity Student = new StudentEntity();
        Student.setFirstName(student.getFirstName());
        Student.setLastName(student.getLastName());
        Student.setEmail(student.getEmail());
        Student.setPassword(student.getPassword());


        studentRepo.save(Student);
        log.info("Student has been created");
        return HttpStatus.OK;

    }

    @Override
    public HttpStatus deleteStudent(Long id) {
        log.info("Receive Request for delete Student on Service " + id);
        if (studentRepo.findById(id).isPresent()) {
            studentRepo.deleteById(id);
            log.info("Student has been deleted");
            return HttpStatus.OK;
        }
        log.warn("Student not found");
        return HttpStatus.NOT_FOUND;

    }

}
