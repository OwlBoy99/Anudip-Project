// SignupServiceImpl.java
package com.rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rent.model.User;
import com.rent.repository.UserRepository;

@Service
public class SignupServiceImpl implements SignupService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void signUp(User user) {
        // Check if the username is already taken
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken");
        }

        // Save the user in the database (without password encryption for simplicity)
        userRepository.save(user);
    }
}
