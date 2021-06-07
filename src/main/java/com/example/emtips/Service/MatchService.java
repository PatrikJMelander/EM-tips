package com.example.emtips.Service;

import com.example.emtips.DTO.MatchResponse;
import com.example.emtips.Models.Match;
import com.example.emtips.Models.Team;
import com.example.emtips.Repository.MatchRepository;
import com.example.emtips.Repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
public class MatchService {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;


    public MatchResponse addMatch(String teamName1, String teamName2) {
        Match match = new Match();

        match.setTeam1(teamRepository.findByName(teamName1).get());
        match.setTeam2(teamRepository.findByName(teamName2).get());
        match.setResult("X");

        matchRepository.save(match);

        return match.toResponse();

    }

    public MatchResponse addMatchResult(String teamName1, String teamName2, String sign) {

        Team team1 = teamRepository.findByName(teamName1).get();
        Team team2 = teamRepository.findByName(teamName2).get();

        Match match = matchRepository.findMatchByTeam1AndTeam2(team1, team2).get();
        match.setResult(sign);
        matchRepository.save(match);

        return match.toResponse();
    }

    public MatchResponse getMatch(String teamName1, String teamName2) {
        Team team1 = teamRepository.findByName(teamName1).get();
        Team team2 = teamRepository.findByName(teamName2).get();

        return matchRepository.findMatchByTeam1AndTeam2(team1, team2).get().toResponse();
    }
}
