package com.gl.users_service.service.impl;

import com.gl.users_service.entity.Users;
import com.gl.users_service.entity.UsersWishList;
import com.gl.users_service.exception.ResourceNotFoundException;
import com.gl.users_service.payload.UsersWishListDTO;
import com.gl.users_service.repository.UsersRepository;
import com.gl.users_service.repository.UsersWishListRepository;
import com.gl.users_service.service.UsersWishListService;
import com.gl.users_service.util.MapperLibrary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UsersWishListServiceImpl implements UsersWishListService {
    UsersWishListRepository usersWishListRepository;
    UsersRepository usersRepository;
    @Override
    public List<UsersWishListDTO> addWishLists(String userId, String wishlistId) {
        Users users = usersRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id",userId));
        UsersWishList usersWishList = new UsersWishList();
        usersWishList.setWishlistId(wishlistId);
        usersWishList.setUsers(users);

        users.getUsersWishLists().add(usersWishList);
        usersRepository.save(users);

        return usersWishListRepository.findByUsersUserID(userId).stream().map(MapperLibrary::mapToUsersWishlistDTO).collect(Collectors.toList());
    }

    @Override
    public List<UsersWishListDTO> deleteWishList(String userId, String wishlistId) {
        Users users = usersRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id",userId));
        UsersWishList usersWishList = usersWishListRepository.findById(wishlistId).orElseThrow(()->new ResourceNotFoundException("Wishlist","Wishlist Id",wishlistId));
        if (!usersWishList.getUsers().getUserID().equals(userId)){
            throw new ResourceNotFoundException("Wishlist with wishlist Id: "+wishlistId+" is not present in the User having user ID: "+userId);
        }
        users.getUsersWishLists().remove(usersWishList);
        usersWishList.setUsers(null);
        usersRepository.save(users);


        return usersWishListRepository.findByUsersUserID(userId).stream().map(MapperLibrary::mapToUsersWishlistDTO).collect(Collectors.toList());
    }

    @Override
    public List<UsersWishListDTO> getWishLists(String userId) {
        return usersWishListRepository.findByUsersUserID(userId).stream().map(MapperLibrary::mapToUsersWishlistDTO).collect(Collectors.toList());
    }
}
