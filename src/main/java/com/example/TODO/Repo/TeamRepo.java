package com.example.TODO.Repo;

import com.example.TODO.Entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<TeamEntity, Long> {
}
