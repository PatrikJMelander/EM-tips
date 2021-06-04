package com.example.emtips.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
public class TeamResponse {
    private String name;
}
