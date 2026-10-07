package com.example.TODO.Entity;

import com.example.TODO.Entity.Enum.Status;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Sessions")
public class SessionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private List<TeamEntity> team;

    private Date startDate;

    private Date endDate;

    @Enumerated(EnumType.STRING)
    private Status status;
}
