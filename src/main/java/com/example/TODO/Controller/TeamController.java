package com.example.TODO.Controller;

import com.example.TODO.DTO.TeamDTO.TeamRequest;
import com.example.TODO.DTO.TeamDTO.TeamResponse;
import com.example.TODO.Service.Impl.TeamServiceImpl;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/V1/Team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamServiceImpl teamService;

    //    add
    @PostMapping
    public HttpStatus addTeam(@RequestBody TeamRequest team) {
        HttpStatus teamCreation = teamService.addTeam(team);
        return teamCreation;
    }

//    update

    @PutMapping("/{id}")
    public HttpStatus updateTeam(@PathVariable Long id, @RequestBody @NotBlank TeamRequest team) {
        HttpStatus teamUpdate = teamService.updateTeam(id, team);
        return teamUpdate;
    }

    //    delete
    @DeleteMapping("/{id}")
    public HttpStatus deleteTeam(@PathVariable Long id) {
        HttpStatus teamDelete = teamService.deleteTeam(id);
        return teamDelete;
    }

    //    get
    @GetMapping
    public List<TeamResponse> getTeams() {
        List<TeamResponse> teamResponse = teamService.getTeams();
        return teamResponse;
    }

}
