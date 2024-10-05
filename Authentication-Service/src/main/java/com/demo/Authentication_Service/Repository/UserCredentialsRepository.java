package com.demo.Authentication_Service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Authentication_Service.Entity.UserCredentialsEntity;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentialsEntity,Integer> {
    
    public Optional<UserCredentialsEntity> findByName(String name);
 
}