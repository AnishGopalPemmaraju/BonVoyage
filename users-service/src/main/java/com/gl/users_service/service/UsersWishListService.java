package com.gl.users_service.service;

import com.gl.users_service.entity.UsersWishList;
import com.gl.users_service.payload.UsersWishListDTO;

import java.util.List;

public interface UsersWishListService {

    List<UsersWishListDTO> addWishLists(String userId, String wishlistId);
    List<UsersWishListDTO> deleteWishList(String userId, String wishlistId);
    List<UsersWishListDTO> getWishLists(String userId);

}
