package com.example.emtips.Models;

import com.example.emtips.DTO.AppUserResponse;
import com.example.emtips.DTO.TipsRowResponse;
import com.example.emtips.Repository.MatchRepository;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by Patrik Melander
 * Date: 2021-06-03
 * Time: 14:32
 * Project: EM-tips
 * Copyright: MIT
 */
@Entity
@Data
@Accessors(chain = true)
public class TipsRow {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany
    private List<Match> match;

    public TipsRowResponse toResponse() {
        return new TipsRowResponse()
                .setMatch(this.match);

    }
    public void addMatchToTipsRow(Match match){
        this.match.add(match);
    }

}
