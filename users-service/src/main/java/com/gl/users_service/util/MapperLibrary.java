package com.gl.users_service.util;

import com.gl.users_service.UsersServiceApplication;
import com.gl.users_service.entity.Users;
import com.gl.users_service.entity.UsersWishList;
import com.gl.users_service.payload.UsersDTO;
import com.gl.users_service.payload.UsersWishListDTO;

public class MapperLibrary {
    public static UsersDTO mapToUsersDto(Users users){
        return UsersServiceApplication.modelMapper().map(users,UsersDTO.class);
    }

    public static Users mapToUsers(UsersDTO usersDTO){
        return UsersServiceApplication.modelMapper().map(usersDTO, Users.class);
    }

    public static UsersWishListDTO mapToUsersWishlistDTO(UsersWishList usersWishList){
        return UsersServiceApplication.modelMapper().map(usersWishList, UsersWishListDTO.class);
    }

    public static UsersWishList mapToUsersWishlist(UsersWishListDTO usersWishListDTO){
        return UsersServiceApplication.modelMapper().map(usersWishListDTO, UsersWishList.class);
    }
}
