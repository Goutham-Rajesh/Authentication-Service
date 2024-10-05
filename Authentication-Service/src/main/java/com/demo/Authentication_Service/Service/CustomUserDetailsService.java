package com.demo.Authentication_Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.demo.Authentication_Service.Entity.UserCredentialsEntity;
import com.demo.Authentication_Service.Repository.UserCredentialsRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{


    @Autowired 
    UserCredentialsRepository UserCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentialsEntity> user =UserCredentialsRepository.findByName(username); 
        System.out.println("user 2: " + user);
        return user.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("Username/password not valid!"));
    }
 }

