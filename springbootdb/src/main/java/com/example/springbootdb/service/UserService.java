package com.example.springbootdb.service;

import com.example.springbootdb.model.User;
import com.example.springbootdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 用戶註冊
    public User registerUser(User user) {
        // 可加入驗證、密碼加密等邏輯
        return userRepository.save(user);
    }
    
    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    // 獲取所有用戶
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 根據 email 獲取用戶
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
