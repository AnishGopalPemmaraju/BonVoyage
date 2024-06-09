package com.gl.users_service.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersWishListDTO {
    @NotEmpty(message = "WishList Id can't be empty")
    private String wishlistId;
}
