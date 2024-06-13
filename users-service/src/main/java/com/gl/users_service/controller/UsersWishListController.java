package com.gl.users_service.controller;

import com.gl.users_service.payload.UsersWishListDTO;
import com.gl.users_service.service.UsersWishListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users/{userId}/wishlist")
public class UsersWishListController {
    UsersWishListService usersWishListService;

    @PostMapping("/{wishlistId}")
    List<UsersWishListDTO> addWishLists(@PathVariable String userId, @PathVariable String wishlistId){
        return usersWishListService.addWishLists(userId,wishlistId);
    }
    @DeleteMapping("/{wishlistId}")
    List<UsersWishListDTO> deleteWishList(@PathVariable String userId, @PathVariable String wishlistId){
        return usersWishListService.deleteWishList(userId,wishlistId);
    }
    @GetMapping
    List<UsersWishListDTO> getWishLists(@PathVariable String userId){
       return usersWishListService.getWishLists(userId);
    }
}
