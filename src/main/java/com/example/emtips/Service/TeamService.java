package com.example.emtips.Service;

import com.example.emtips.DTO.TeamResponse;
import com.example.emtips.Models.Team;
import com.example.emtips.Repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * Created by Patrik Melander
 * Date: 2021-06-03
 * Time: 19:04
 * Project: EM-tips
 * Copyright: MIT
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {
    TeamRepository teamRepository;

    public TeamResponse addTeam(String teamName) {
        teamRepository.findByName(teamName).ifPresent(team ->{
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Team already exist");
        });

        Team team = new Team();
        team.setName(teamName);
        teamRepository.save(team);
        return team.toResponse();
    }

    public TeamResponse getTeam(String teamName) {
        Optional<Team> team = teamRepository.findByName(teamName);
        if (team.isPresent()){
            return getTeam(teamName);
        }else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No such team found");
        }
    }
}
