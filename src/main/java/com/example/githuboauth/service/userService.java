package com.example.githuboauth.service;

import com.example.githuboauth.model.User;
import com.example.githuboauth.repository.userRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class userService {


    private final userRepository userDao;

    public userService(userRepository userDao) {
        this.userDao = userDao;
    }

    public User getLoggedInUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDao.findById(user.getId()).get();
    }

}
