package com.webpostman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webpostman.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration ,Long>{

    
} 
