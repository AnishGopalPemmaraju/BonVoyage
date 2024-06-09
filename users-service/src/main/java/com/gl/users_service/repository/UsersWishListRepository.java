package com.gl.users_service.repository;

import com.gl.users_service.entity.UsersWishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersWishListRepository extends JpaRepository<UsersWishList,String> {
    List<UsersWishList> findByUsersUserID(String userId);

}
