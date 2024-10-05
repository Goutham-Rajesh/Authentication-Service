package com.demo.Authentication_Service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.Authentication_Service.Entity.UserCredentialsEntity;
import com.demo.Authentication_Service.Repository.UserCredentialsRepository;

@Service
public class UserCredentialService {

    @Autowired
    JwtService jwtService;
    
    @Autowired
    UserCredentialsRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserCredentialsEntity  register(UserCredentialsEntity user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return authRepository.saveAndFlush(user);
    }

    public String generateToken(String name) {
        return jwtService.generateToken(name);
    }

    public boolean verifyToken(String token) {
        jwtService.validateToken(token);
        return true;
    }

    
}
