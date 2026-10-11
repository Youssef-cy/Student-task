package com.example.TODO.DTO;

import com.example.TODO.Entity.Enum.Status;
import com.example.TODO.Entity.TeamEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class SessionsDTO {
    private Date startDate;
    private Date endDate;
    @NotBlank
    private Status status;
    @NotBlank
    private List<TeamEntity> teams;
}
