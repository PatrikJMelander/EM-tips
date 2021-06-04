package com.example.emtips.Models;

import com.example.emtips.DTO.AppUserResponse;
import com.example.emtips.DTO.MatchResponse;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Patrik Melander
 * Date: 2021-06-03
 * Time: 14:33
 * Project: EM-tips
 * Copyright: MIT
 */
@Entity
@Data
@Accessors(chain = true)
public class Match {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Team team1;
    @ManyToOne
    private Team team2;

    private String result;

    public MatchResponse toResponse() {
        return new MatchResponse()
                .setTeam1(this.team1)
                .setTeam2(this.team2)
                .setResult(this.result);
    }
}
