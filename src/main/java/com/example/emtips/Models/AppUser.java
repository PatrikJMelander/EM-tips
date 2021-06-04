package com.example.emtips.Models;

import com.example.emtips.DTO.AppUserResponse;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Accessors(chain = true)
public class AppUser {

    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    @ManyToOne
    private TipsRow tipsRow;

    public AppUserResponse toResponse() {
        return new AppUserResponse()
                .setFirstName(this.firstName)
                .setLastName(this.lastName)
                .setEmail(this.email)
                .setTipsRow(this.tipsRow);
    }
}
