package com.example.springbootdb.controller;

import com.example.springbootdb.model.User;
import com.example.springbootdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 顯示註冊表單
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // 對應 src/main/resources/templates/register.html
    }

    // 處理註冊表單提交
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.registerUser(user);
        model.addAttribute("message", "註冊成功！");
        return "register"; // 註冊成功後依然留喺註冊頁，但顯示成功訊息
    }

    // 顯示登入表單
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login"; // 對應 src/main/resources/templates/login.html
    }
    
    // 處理登入表單提交
    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        boolean isAuthenticated = userService.authenticate(user.getEmail(), user.getPassword());
        if (isAuthenticated) {
            model.addAttribute("message", "Login successful!");
            return "home"; // 登入成功後導向首頁
        } else {
            model.addAttribute("error", "Invalid email or password.");
            return "login"; // 登入失敗，留返喺登入頁面
        }
    }
}
