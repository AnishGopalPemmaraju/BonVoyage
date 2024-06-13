package com.gl.users_service.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDetailsDTO {
    private String userEmail;
    private String userPassword;
}
