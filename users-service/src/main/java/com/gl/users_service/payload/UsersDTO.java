package com.gl.users_service.payload;

import com.gl.users_service.entity.UsersWishList;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UsersDTO {

    private String userID;

    @NotEmpty(message = "User Name can't be empty!")
    @Size(min = 3,message = "User Name must be minimum 3 characters")
    @NotNull
    private String userName;

    @NotEmpty(message = "User Email can't be empty!")
    @Email
    private String userEmail;

    @NotEmpty(message = "User Phone can't be empty!")
    @Size(min = 10,max = 10,message = "User's Phone No. must be 10 digits")
    @NotNull
    private String userPhone;

    @NotEmpty(message = "User Password can't be empty!")
    @NotNull
    private String userPassword;

    @NotEmpty(message = "User Address can't be empty!")
    @NotNull
    private String userAddress;

    @NotEmpty(message = "User Role can't be empty!")
    @NotNull
    private String userRole;

    private List<UsersWishListDTO> usersWishLists;
}
