package com.example.emtips.Controller;

import com.example.emtips.DTO.AppUserResponse;
import com.example.emtips.DTO.TeamResponse;
import com.example.emtips.Service.MatchService;
import com.example.emtips.Service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Patrik Melander
 * Date: 2021-06-03
 * Time: 19:06
 * Project: EM-tips
 * Copyright: MIT
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/team")
@CrossOrigin
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/add")
    public ResponseEntity<TeamResponse> addTeam(@RequestParam String teamName) {
        return ResponseEntity.ok(teamService.addTeam(teamName));
    }

    @PostMapping("/get")
    public ResponseEntity<TeamResponse> getTeam(@RequestParam String teamName) {
        return ResponseEntity.ok(teamService.getTeam(teamName));
    }
}
