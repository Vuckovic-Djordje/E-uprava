package com.licnaDokumenta.service;

import com.licnaDokumenta.dto.UserInfo;
import com.licnaDokumenta.model.User;
import com.licnaDokumenta.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    final private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User getLogged(Authentication authentication){
        return userRepository.findByUsername(authentication.getName());
    }


    public UserInfo getCitizenInfo(Authentication authentication){
        return new UserInfo(userRepository.findByUsername(authentication.getName()));
    }
}
