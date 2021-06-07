package com.example.emtips.Controller;

import com.example.emtips.DTO.AppUserResponse;
import com.example.emtips.DTO.MatchResponse;
import com.example.emtips.Models.AppUser;
import com.example.emtips.Service.MatchService;
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
@RequestMapping("api/v1/match")
@CrossOrigin
public class MatchController {
    private final MatchService matchService;

    @PostMapping("/add")
    public ResponseEntity<MatchResponse> addMatch(@RequestParam String teamName1,
                                                    @RequestParam String teamName2) {
        return ResponseEntity.ok(matchService.addMatch(teamName1, teamName2));
    }

    @PostMapping("/add/result")
    public ResponseEntity<MatchResponse> addAppUser(@RequestParam String teamName1,
                                                      @RequestParam String teamName2,
                                                      @RequestParam String sign) {
        return ResponseEntity.ok(matchService.addMatchResult(teamName1, teamName2, sign));
    }
    @GetMapping("/get/match")
    public ResponseEntity<MatchResponse> getMatch(@RequestParam String teamName1,
                                                  @RequestParam String teamName2){
        return ResponseEntity.ok(matchService.getMatch(teamName1, teamName2));
    }

}
