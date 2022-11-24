//package com.graduation.daily.user;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//@Service
//public class UserSecurityService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
//        Optional<User_register> _siteUser = this.userRepository.findByUserid(userid);
//
//        /*
//        if (_siteUser.isEmpty()) {
//            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
//        }*/
//        User_register siteUser = _siteUser.get();
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        if ("admin".equals(userid)) {
//            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getId()));
//        } else {
//            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getId()));
//        }
//        return new User(siteUser.getUserid(), siteUser.getPassword(), authorities);
//    }
//}