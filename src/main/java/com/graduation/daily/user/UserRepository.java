package com.graduation.daily.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User_register, Long> {
    List<User_register> findByUserid(String userid);
}