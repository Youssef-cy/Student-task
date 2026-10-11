package com.example.TODO.Service.Impl;

import com.example.TODO.DTO.TeamDTO.TeamRequest;
import com.example.TODO.DTO.TeamDTO.TeamResponse;
import com.example.TODO.Entity.TeamEntity;
import com.example.TODO.Repo.StudentRepo;
import com.example.TODO.Repo.TeamRepo;
import com.example.TODO.Service.TeamService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepo teamRepo;
    private final StudentRepo studentRepo;

    @Override
    public List<TeamResponse> getTeams() {

        List<TeamEntity> teams = teamRepo.findAll();

        if (teams.isEmpty()) {
            return new ArrayList<>();
        }

        List<TeamResponse> teamResponses = new ArrayList<>();
        for (TeamEntity team : teams) {
            TeamResponse teamResponse = new TeamResponse();
            teamResponse.setName(team.getName());
            teamResponses.add(teamResponse);

        }
        return teamResponses;


    }

    @Override
    @Transactional
    public HttpStatus addTeam(TeamRequest team) {
        try {
            TeamEntity teamEntity = new TeamEntity();
            teamEntity.setName(team.getName());
            teamRepo.save(teamEntity);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @Override
    public HttpStatus deleteTeam(Long id) {
        if (teamRepo.existsById(id)) {
            try {
                teamRepo.deleteById(id);
                return HttpStatus.OK;
            } catch (Exception e) {
                return HttpStatus.BAD_REQUEST;
            }
        }
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public HttpStatus updateTeam(Long id, TeamRequest team) {

        if (teamRepo.existsById(id)) {
            try {
                TeamEntity teamEntity = teamRepo.findById(id).get();
                teamEntity.setName(team.getName());
                teamRepo.save(teamEntity);
                return HttpStatus.OK;
            } catch (Exception e) {
                return HttpStatus.BAD_REQUEST;
            }
        }
        return HttpStatus.NOT_FOUND;
    }
}
