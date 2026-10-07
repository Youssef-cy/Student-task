package com.example.TODO.Repo;

import com.example.TODO.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Long> {
}
