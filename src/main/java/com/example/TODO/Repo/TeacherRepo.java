package com.example.TODO.Repo;

import com.example.TODO.Entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<TeacherEntity, Long> {
}
