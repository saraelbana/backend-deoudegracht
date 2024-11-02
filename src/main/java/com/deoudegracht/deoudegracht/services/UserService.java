package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.models.User;
import org.springframework.stereotype.Service;

import com.deoudegracht.deoudegracht.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<User> findByUsername(String username) {
        try {
            return userRepository.findByUsername(username);
        }
        catch (Exception e) {
            throw new RuntimeException("User not found");
        }
    }

}
