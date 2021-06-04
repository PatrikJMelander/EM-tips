package com.example.emtips.Repository;

import com.example.emtips.Models.TipsRow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by Patrik Melander
 * Date: 2021-06-03
 * Time: 19:01
 * Project: EM-tips
 * Copyright: MIT
 */
public interface TipsRowRepository  extends JpaRepository<TipsRow, UUID> {
}
