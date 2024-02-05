package com.webpostman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webpostman.entity.Registration;
import com.webpostman.repository.RegistrationRepository;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepo;

    public void saveRegistration(Registration registration){
        registrationRepo.save(registration);
    }
}
