package com.graduation.daily.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.graduation.daily.user.User_register;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User_register> users;
}