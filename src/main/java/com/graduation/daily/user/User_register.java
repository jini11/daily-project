package com.graduation.daily.user;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.graduation.daily.model.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User_register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userid;

    private String email;

    private String password;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

}