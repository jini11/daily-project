package com.graduation.daily.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User_register, Long> {
    Optional<User_register> findByuserid(String userid);
}