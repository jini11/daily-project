package com.graduation.daily.user;

import com.graduation.daily.model.Role;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User_register create(String userid,String email, String password) {
        User_register user = new User_register();

        user.setUserid(userid);
        user.setEmail(email);
        user.setPassword(password);

        Role role = new Role();
        role.setId(1L);
        user.getRoles().add(role);

        this.userRepository.save(user);
        return user;
    }
}