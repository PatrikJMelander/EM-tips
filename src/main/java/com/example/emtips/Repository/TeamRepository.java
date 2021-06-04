package com.example.emtips.Repository;

import com.example.emtips.Models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by Patrik Melander
 * Date: 2021-06-03
 * Time: 19:00
 * Project: EM-tips
 * Copyright: MIT
 */
public interface TeamRepository  extends JpaRepository<Team, UUID> {

    Optional<Team> findByName(String name);
}
