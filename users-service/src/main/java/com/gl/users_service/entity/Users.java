package com.gl.users_service.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Users {
    @Id
    private String userID;
    @Column(nullable = false,unique = true)
    private String userName;
    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false,unique = true)
    private String userEmail;
    @Column(nullable = false,unique = true)
    private String userPhone;
    @Column(nullable = false)
    private String userPassword;
    @Column(nullable = false)
    private String userAddress;
    @Column(nullable = false)
    private String userRole;
    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<UsersWishList> usersWishLists;
}

// "userName":
//"userEmail":
// "userPhone":
// "userPassword":
// "userAddress":
// "userRole":
// "usersWishLists":