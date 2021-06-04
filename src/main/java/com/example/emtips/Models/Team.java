package com.example.emtips.Models;

import com.example.emtips.DTO.MatchResponse;
import com.example.emtips.DTO.TeamResponse;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Team {
    @Id
    @GeneratedValue
    private UUID id;

    String name;

    public TeamResponse toResponse() {
        return new TeamResponse()
                .setName(this.name);
    }
}
