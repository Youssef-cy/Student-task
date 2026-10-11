package com.example.TODO.Service;

import com.example.TODO.DTO.StudentsREQ;
import com.example.TODO.DTO.TeacherDTO;
import com.example.TODO.Entity.StudentEntity;
import com.example.TODO.Entity.TeacherEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface StudentIMPL {

    List<StudentEntity> getAllStudent();

    HttpStatus deleteStudent(Long id);

    HttpStatus createStudent(StudentsREQ student);
}
