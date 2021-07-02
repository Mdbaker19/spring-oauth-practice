package com.example.githuboauth.service;


import com.example.githuboauth.model.User;
import com.example.githuboauth.model.UserWithRoles;
import com.example.githuboauth.repository.userRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class userDetailsLoader implements UserDetailsService {

    private final userRepository userDao;

    public userDetailsLoader(userRepository userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String un) throws UsernameNotFoundException {
        User user = userDao.findByUsername(un);

        if(user == null) {
            throw new UsernameNotFoundException("No user found with UN: " + un);
        }

        return new UserWithRoles(user);
    }

}
