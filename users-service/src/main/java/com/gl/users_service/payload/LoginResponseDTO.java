package com.gl.users_service.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDTO {
    private String userId;
    private String name;
    private String userRole;
    private boolean success;
    private String errorMessage;
}
