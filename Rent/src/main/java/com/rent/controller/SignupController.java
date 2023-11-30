package com.rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rent.model.User;
import com.rent.service.SignupService;

@RestController
@RequestMapping("/api/signup")
@CrossOrigin(origins = "*")
public class SignupController {
    @Autowired
    private SignupService signupService;

    @PostMapping
    public ResponseEntity<String> signUp(@RequestBody User user) {
        signupService.signUp(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
