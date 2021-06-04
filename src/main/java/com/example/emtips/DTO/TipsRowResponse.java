package com.example.emtips.DTO;

import com.example.emtips.Models.Match;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-06-03
 * Time: 19:08
 * Project: EM-tips
 * Copyright: MIT
 */
@Getter
@Setter
@Accessors(chain = true)
public class TipsRowResponse {
    private List<Match> match;
}
