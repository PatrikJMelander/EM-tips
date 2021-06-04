package com.example.emtips.Repository;

import com.example.emtips.Models.Match;
import com.example.emtips.Models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by Patrik Melander
 * Date: 2021-06-03
 * Time: 18:43
 * Project: EM-tips
 * Copyright: MIT
 */
public interface MatchRepository extends JpaRepository<Match, UUID> {

    Optional<Match> findMatchByTeam1AndTeam2(Team team1, Team team2);
}
