package com.rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rent.model.User;
import com.rent.repository.UserRepository;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService { // Implement the LoginService interface
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authenticate(User user) {
        // Retrieve the user from the database based on the provided username
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());

        // Check if the user exists and the password matches
        return optionalUser.isPresent() && optionalUser.get().getPassword().equals(user.getPassword());
    }
}
