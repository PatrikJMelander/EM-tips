package com.example.emtips.Repository;

import com.example.emtips.Models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Patrik Melander
 * Date: 2021-06-03
 * Time: 18:42
 * Project: EM-tips
 * Copyright: MIT
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
    Optional<AppUser> findByEmail(String email);

    AppUser findAppUserByEmail(String email);

    List<AppUser> findAllByEmail(String email);
}

