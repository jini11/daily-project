package com.graduation.daily.controller;

import com.graduation.daily.user.UserCreateForm;
import com.graduation.daily.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private final UserService userService;

    @GetMapping("/login")
    public String login(HttpSession session) {
        return "account/login";
    }

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {
        return "account/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "account/signup";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "account/signup";
        }

        try {
            userService.create(userCreateForm.getUserid(),
                    userCreateForm.getEmail(), userCreateForm.getPassword1());
        }catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "account/signup";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "account/signup";
        }

        return "redirect:/";
    }

    @GetMapping("/findID")
    public String findID() {
        return "account/findID";
    }

    @GetMapping("/findPW")
    public String findPW() {
        return "account/findPW";
    }
}
