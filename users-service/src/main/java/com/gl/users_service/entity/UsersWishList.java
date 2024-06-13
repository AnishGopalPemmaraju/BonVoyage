package com.gl.users_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "UsersWishLists")
public class UsersWishList {
    @Id
    @Column(nullable = false)
    private String wishlistId;
    @ManyToOne
    private Users users;
}
