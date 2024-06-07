package com.gl.users_service.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    private String userID;
    @NotEmpty @NotNull
    private String userName;
    private String userEmail;
    private long userPhone;
    private String userPassword;
    private String userAddress;
    private String userRole;
}
