package com.example.springbootdb.repository;

import com.example.springbootdb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 根據需要，可以新增根據 email 查詢嘅方法
    User findByEmail(String email);
}
