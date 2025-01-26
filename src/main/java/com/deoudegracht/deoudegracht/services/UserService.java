package com.deoudegracht.deoudegracht.services;


import com.deoudegracht.deoudegracht.models.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.deoudegracht.deoudegracht.repositories.UserRepository;

import java.util.Optional;

@Service
@Transactional
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
    public User createUser(User user) {
        String username = user.getUsername();
        if (findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        try
        {
            return userRepository.save(user);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to create user: " + e.getMessage());
        }
    }

}
