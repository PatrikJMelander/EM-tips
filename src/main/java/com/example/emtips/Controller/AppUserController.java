package com.example.emtips.Controller;

import com.example.emtips.DTO.AppUserResponse;
import com.example.emtips.DTO.TipsRowResponse;
import com.example.emtips.Models.AppUser;
import com.example.emtips.Models.TipsRow;
import com.example.emtips.Service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Created by Patrik Melander
 * Date: 2021-06-03
 * Time: 19:05
 * Project: EM-tips
 * Copyright: MIT
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
@CrossOrigin
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping
    public ResponseEntity<List<AppUserResponse>> getAllAppUsers() {
        return ResponseEntity.ok(appUserService.getAll());
    }

    @GetMapping("/validate/login")
    public ResponseEntity<AppUserResponse> validateLogin(@RequestParam String email,
                                                         @RequestParam String password) {
        return ResponseEntity.ok(appUserService.validateLogin(email, password));
    }

    @GetMapping("/get/one")
    public ResponseEntity<AppUserResponse> getOneByEmail(@RequestParam  String email) {
        return ResponseEntity.ok(appUserService.getAppUserByEmail(email));
    }

    @PostMapping("/add")
    public ResponseEntity<AppUserResponse> addAppUser(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(appUserService.addAppUser(appUser));
    }

    @GetMapping("/update/password")
    public ResponseEntity<AppUserResponse> updatePassword(@RequestParam String password,
                                                          @RequestParam String email) {
        return ResponseEntity.ok(appUserService.updatePassword(password,email));
    }

    @PostMapping("/update")
    public ResponseEntity<AppUserResponse> updateUser(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(appUserService.updateUser(appUser));
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteAppUser(@RequestParam String email,
                                                @RequestParam String password) {
        return ResponseEntity.ok(appUserService.deleteAppUser(email, password));
    }

    @GetMapping("/delete/byPostman")
    public ResponseEntity<String> deleteAppUserByPostman(@RequestParam String email) {
        return ResponseEntity.ok(appUserService.deleteAppUserByPostman(email));
    }

    @PostMapping("/update/tipsRow")
    public ResponseEntity<String> updateUserTipsRow(@RequestBody AppUser appUser,
                                    @RequestBody TipsRow tipsRow) {
        return ResponseEntity.ok(appUserService.updateUserTipsRow(appUser, tipsRow));
    }

    @GetMapping("/get/tipsRow")
    public ResponseEntity<TipsRowResponse> getUserTipsRow(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(appUserService.getUserTipsRow(appUser));
    }
}

