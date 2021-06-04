package com.example.emtips.DTO;

import com.example.emtips.Models.Team;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by Patrik Melander
 * Date: 2021-06-03
 * Time: 19:07
 * Project: EM-tips
 * Copyright: MIT
 */
@Getter
@Setter
@Accessors(chain = true)
public class MatchResponse {

    private Team team1;

    private Team team2;

    private String result;

}
