package com.example.githuboauth.repository;

import com.example.githuboauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Long> {


    User findByUsername(String un);
}
