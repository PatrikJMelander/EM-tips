package com.example.emtips.Service;

import com.example.emtips.Models.AppUser;
import com.example.emtips.Models.Match;
import com.example.emtips.Models.TipsRow;
import com.example.emtips.Repository.AppUserRepository;
import com.example.emtips.Repository.MatchRepository;
import com.example.emtips.Repository.TipsRowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-06-03
 * Time: 19:04
 * Project: EM-tips
 * Copyright: MIT
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TipsRowService {

    TipsRowRepository tipsRowRepository;
    MatchRepository matchRepository;

    public void fillTipsRowWithMatches(TipsRow tipsrow) {
        List<Match> matches = matchRepository.findAll();

        for (Match m : matches) {
            tipsrow.addMatchToTipsRow(m);
        }
        tipsRowRepository.save(tipsrow);
    }
}
