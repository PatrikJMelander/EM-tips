package com.example.emtips.Service;

import com.example.emtips.DTO.AppUserResponse;
import com.example.emtips.DTO.TipsRowResponse;
import com.example.emtips.Models.AppUser;
import com.example.emtips.Models.TipsRow;
import com.example.emtips.Repository.AppUserRepository;
import com.example.emtips.Repository.TipsRowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final TipsRowService tipsRowService;
    
    public AppUserResponse validateLogin(String email, String password) {
        AppUser appUser = appUserRepository.findByEmail(email)
                .orElseThrow(() -> { throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Could not find user");
                });
        if (appUser.getPassword().equals(password)){

            return appUser.toResponse();
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    public AppUserResponse getAppUserByEmail(String email) {

        AppUser appUser = appUserRepository.findByEmail(email)
                .orElseThrow(() -> { throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Could not find user");
                });

        return appUser.toResponse();

    }

    public AppUserResponse addAppUser(AppUser appUser) {
        Optional<AppUser> existingAppUser = appUserRepository.findByEmail(appUser.getEmail());

        if (existingAppUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        } else {
            validateAppUser(existingAppUser.get());
            TipsRow tipsRow = new TipsRow();
            tipsRowService.fillTipsRowWithMatches(tipsRow);
            existingAppUser.get().setTipsRow(tipsRow);

            return appUserRepository.save(appUser)
                    .toResponse();
        }
    }

    private void validateAppUser(AppUser appUser) {
        if (appUser.getEmail() == null || appUser.getFirstName() == null || appUser.getLastName() == null || appUser.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "User need to have a firstname, lastname, email and password");
        }
    }

    public AppUserResponse updatePassword(String password, String email) {

        Optional<AppUser> existingAppUser = appUserRepository.findByEmail(email);

        if (existingAppUser.isPresent()) {
            existingAppUser.get()
                    .setPassword(password);
            return appUserRepository.save(existingAppUser.get())
                    .toResponse();
        } else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Could not find user");
        }
    }

    @Transactional
    public AppUserResponse updateUser(AppUser appUser) {

        Optional<AppUser> existingAppUser = appUserRepository.findByEmail(appUser.getEmail());

        if (existingAppUser.isPresent()) {
            existingAppUser.get()
                    .setFirstName(appUser.getFirstName())
                    .setLastName(appUser.getLastName());
            return appUserRepository.save(existingAppUser.get())
                    .toResponse();
        } else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Could not find user");
        }
    }

    public String deleteAppUser(String email, String password) {

        appUserRepository.findByEmail(email)
                .ifPresentOrElse(appUser -> {
                    if (appUser.getPassword().equals(password)) {
                        appUserRepository.deleteById(appUser.getId());
                    }else {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                    }
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Email does not exist");
                });

        return "User with email: " + email + " has been deleted";
    }

    public String deleteAppUserByPostman(String email) {

        List<AppUser> usersToDelete = appUserRepository.findAllByEmail(email);

        for (AppUser user : usersToDelete) {
            appUserRepository.deleteById(user.getId());
        }

        return "Users with email: " + email + " has been deleted";
    }

    public List<AppUserResponse> getAll() {
        return appUserRepository.findAll().stream()
                .map(AppUser::toResponse)
                .collect(Collectors.toList());
    }

    public String updateUserTipsRow(AppUser appUser, TipsRow tipsrow) {
        AppUser user = appUserRepository.findAppUserByEmail(appUser.getEmail());
        user.setTipsRow(tipsrow);
        appUserRepository.save(user);

        return "TipsRow updated";

    }

    public TipsRowResponse getUserTipsRow(AppUser appUser) {
        AppUser user = appUserRepository.findAppUserByEmail(appUser.getEmail());
        return user.getTipsRow().toResponse();
    }

    public AppUserResponse addPoints(String email, double points) {
        AppUser user = appUserRepository.findAppUserByEmail(email);

        user.addPoints(points);
        appUserRepository.save(user);
        return user.toResponse();
    }
}
