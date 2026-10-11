package com.example.TODO.DTO.TaksDTO;

import com.example.TODO.Entity.Enum.TaskType;
import com.example.TODO.Entity.StudentEntity;
import com.example.TODO.Entity.TeacherEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private String taskName;
    private String taskDescription;
    private List<StudentEntity> students;
    private TeacherEntity teacher;
    @Enumerated(EnumType.STRING)
    private TaskType taskType;
}
